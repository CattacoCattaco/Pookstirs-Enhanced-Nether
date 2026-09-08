package pookstir.pookstirsenhancednether.specialitems;

import java.util.Optional;
import java.util.function.Function;

import org.jspecify.annotations.Nullable;

import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.hurtingprojectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.windcharge.AbstractWindCharge;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.phys.*;

public class VolatileCharge extends AbstractHurtingProjectile implements ItemSupplier {
    public static final ExplosionDamageCalculator EXPLOSION_DAMAGE_CALCULATOR =  new SimpleExplosionDamageCalculator(
            true, false, Optional.empty(),
            BuiltInRegistries.BLOCK.get(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS).map(Function.identity()));
    private static final float MIN_CAMERA_DISTANCE_SQUARED = 12.5f;
    private int explosionPower = 6;
    private int noDeflectTicks = 5;

    public VolatileCharge(final EntityType<? extends AbstractWindCharge> type, final Level level) {
        super(type, level);
        this.accelerationPower = (double)0.0F;
    }

    public VolatileCharge(final Player player, final Level level, final double x, final double y, final double z) {
        super(EntityTypes.FIREBALL, x, y, z, level);
        this.setOwner(player);
        this.accelerationPower = (double)0.0F;
    }

    public VolatileCharge(final Level level, final double x, final double y, final double z, final Vec3 direction) {
        super(EntityTypes.FIREBALL, x, y, z, direction, level);
        this.accelerationPower = (double)0.0F;
    }

    protected AABB makeBoundingBox(final Vec3 position) {
        float width = this.getType().getDimensions().width() / 2.0F;
        float height = this.getType().getDimensions().height();
        float offset = 0.15F;
        return new AABB(position.x - (double)width, position.y - (double)0.15F,
                position.z - (double)width, position.x + (double)width,
                position.y - (double)0.15F + (double)height, position.z + (double)width);
    }

    public boolean canCollideWith(final Entity entity) {
        return entity instanceof AbstractHurtingProjectile ? false : super.canCollideWith(entity);
    }

    protected boolean canHitEntity(final Entity entity) {
        if (entity instanceof AbstractHurtingProjectile) {
            return false;
        } else {
            return entity.is(EntityTypes.END_CRYSTAL) ? true : super.canHitEntity(entity);
        }
    }

    protected void onHitEntity(final EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Level var3 = this.level();
        if (var3 instanceof ServerLevel serverLevel) {
            Entity var5 = this.getOwner();
            LivingEntity var10000;
            if (var5 instanceof LivingEntity entity) {
                var10000 = entity;
            } else {
                var10000 = null;
            }

            LivingEntity owner = var10000;
            Entity entity = hitResult.getEntity();
            if (owner != null) {
                owner.setLastHurtMob(entity);
            }

            DamageSource source = this.damageSources().windCharge(this, owner);
            if (entity.hurtServer(serverLevel, source, 1.0F) && entity instanceof LivingEntity mob) {
                EnchantmentHelper.doPostAttackEffects(serverLevel, mob, source);
            }

            this.explode(this.position());
        }
    }

    public void push(final double xa, final double ya, final double za) {
    }

    protected void explode(final Vec3 position) {
        Level level = this.level();
        if(level instanceof ServerLevel serverLevel) {
            boolean grief = (Boolean)serverLevel.getGameRules().get(GameRules.MOB_GRIEFING);
            level.explode(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, grief,
                    Level.ExplosionInteraction.MOB);
        }
    }

    protected void onHitBlock(final BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        if (!this.level().isClientSide()) {
            Vec3i collisionNormal = hitResult.getDirection().getUnitVec3i();
            Vec3 scaledNormal = Vec3.atLowerCornerOf(collisionNormal).multiply((double)0.25F, (double)0.25F, (double)0.25F);
            Vec3 explosionPos = hitResult.getLocation().add(scaledNormal);
            this.explode(explosionPos);
            this.discard();
        }

    }

    protected void onHit(final HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide()) {
            this.discard();
        }

    }

    protected boolean shouldBurn() {
        return false;
    }

    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }

    protected float getInertia() {
        return 1.0F;
    }

    protected float getLiquidInertia() {
        return this.getInertia();
    }

    protected @Nullable ParticleOptions getTrailParticle() {
        return null;
    }

    public void tick() {
        if (!this.level().isClientSide() && this.getBlockY() > this.level().getMaxY() + 30) {
            this.explode(this.position());
            this.discard();
        } else {
            super.tick();
        }

        if (this.noDeflectTicks > 0) {
            --this.noDeflectTicks;
        }
    }

    public boolean deflect(final ProjectileDeflection deflection, final @Nullable Entity deflectingEntity,
                           final @Nullable EntityReference<Entity> newOwner, final boolean byAttack) {
        return this.noDeflectTicks > 0 ? false : super.deflect(deflection, deflectingEntity, newOwner, byAttack);
    }

    public boolean shouldRenderAtSqrDistance(final double distance) {
        return this.tickCount < 2 && distance < (double)MIN_CAMERA_DISTANCE_SQUARED ? false :
                super.shouldRenderAtSqrDistance(distance);
    }
}
