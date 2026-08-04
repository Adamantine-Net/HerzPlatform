package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.WorldSaveEvent;
import net.minecraft.world.storage.SaveHandler;
import net.minecraft.world.storage.WorldInfo;
@Mixin(SaveHandler.class)
public class WorldSaveMixin {
    @Inject(method = "saveWorldInfo", at = At.HEAD)
    private void herz$saveWorldInfo(WorldInfo worldInformation) {
        EventBus.INSTANCE.post(new WorldSaveEvent(worldInformation));
    }
}
