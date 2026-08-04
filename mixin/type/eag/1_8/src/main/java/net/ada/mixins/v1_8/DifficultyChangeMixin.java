package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.DifficultyChangeEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.storage.WorldInfo;
@Mixin(WorldInfo.class)
public class DifficultyChangeMixin {
    @Inject(method = "setDifficulty", at = At.HEAD)
    private void herz$setDifficulty(EnumDifficulty enumdifficulty) {
        EventBus.INSTANCE.post(new DifficultyChangeEvent(enumdifficulty));
    }
}
