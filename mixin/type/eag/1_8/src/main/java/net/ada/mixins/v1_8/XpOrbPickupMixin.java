package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.XpOrbPickupEvent;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
@Mixin(EntityXPOrb.class)
public class XpOrbPickupMixin {
    @Inject(method = "onCollideWithPlayer", at = At.HEAD)
    private void herz$onCollideWithPlayer(EntityPlayer entityplayer) {
        EventBus.INSTANCE.post(new XpOrbPickupEvent(entityplayer, (EntityXPOrb) (Object) this));
    }
}
