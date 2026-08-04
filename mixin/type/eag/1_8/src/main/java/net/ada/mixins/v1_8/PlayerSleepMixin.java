package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.PlayerSleepEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

@Mixin(EntityPlayer.class)
public class PlayerSleepMixin {

    @Inject(method = "trySleep", at = At.HEAD)
    private void herz$trySleep(BlockPos blockpos) {
        EventBus.INSTANCE.post(new PlayerSleepEvent((EntityPlayer) (Object) this, blockpos));
    }
}
