package pookstir.pookstirsenhancednether.specialitems;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.LargeFireball;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.entity.projectile.hurtingprojectile.windcharge.WindCharge;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;

public class VolatileChargeItem extends Item implements ProjectileItem {
    public static final float PROJECTILE_SHOOT_POWER = 1.5F;

    public VolatileChargeItem(final Item.Properties properties) {
        super(properties);
    }

    public InteractionResult use(final Level level, final Player player, final InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level instanceof ServerLevel serverLevel) {
            Projectile.spawnProjectileFromRotation((source, l, itemStack) ->
                    new VolatileCharge(player, level, player.position().x(), player.getEyePosition().y(),
                            player.position().z()),
                    serverLevel, stack, player, 0.0F, 1.5F, 1.0F);
        }

        level.playSound((Entity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT,
                SoundSource.NEUTRAL, 1.0F,
                (level.getRandom().nextFloat() - level.getRandom().nextFloat()) * 0.2F + 1.0F);
        player.awardStat(Stats.ITEM_USED.get(this));
        stack.consume(1, player);
        return InteractionResult.SUCCESS;
    }

    public Projectile asProjectile(final Level level, final Position position, final ItemStack itemStack,
                                   final Direction direction) {
        RandomSource random = level.getRandom();
        double dirX = random.triangle((double)direction.getStepX(), 0.11485000000000001);
        double dirY = random.triangle((double)direction.getStepY(), 0.11485000000000001);
        double dirZ = random.triangle((double)direction.getStepZ(), 0.11485000000000001);
        Vec3 dir = new Vec3(dirX, dirY, dirZ);
        VolatileCharge volatileCharge = new VolatileCharge(level, position.x(), position.y(), position.z(), dir);
        volatileCharge.setDeltaMovement(dir);
        return volatileCharge;
    }

    public void shoot(final Projectile projectile, final double xd, final double yd, final double zd, final float pow,
                      final float uncertainty) {
    }

    public ProjectileItem.DispenseConfig createDispenseConfig() {
        return DispenseConfig.builder().positionFunction((source, direction) ->
                DispenserBlock.getDispensePosition(source, (double)1.0F, Vec3.ZERO))
                .uncertainty(6.6666665F).power(1.0F).overrideDispenseEvent(1018).build();
    }
}
