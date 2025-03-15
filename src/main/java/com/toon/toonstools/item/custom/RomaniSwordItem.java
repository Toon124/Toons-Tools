package com.toon.toonstools.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;

public class RomaniSwordItem extends SwordItem {
    public RomaniSwordItem(Tier tier, Properties properties) {
        super(tier, properties
                .attributes(SwordItem.createAttributes(tier, 5, -2.4f))
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide && player instanceof ServerPlayer serverPlayer) {
            // Calculate the position 5 blocks in the direction the player is looking
            Vec3 lookDirection = player.getLookAngle().normalize();
            Vec3 targetPosVec = player.position().add(lookDirection.scale(5));
            BlockPos targetPos = new BlockPos((int) targetPosVec.x,
                    (int) targetPosVec.y,
                    (int) targetPosVec.z);

            // Check if the target block is safe (air or passable)
            if (world.getBlockState(targetPos).isAir()) {
                serverPlayer.teleportTo(targetPos.getX(), targetPos.getY(), targetPos.getZ());
                world.playSound(null, targetPos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), world.isClientSide());
    }
}
