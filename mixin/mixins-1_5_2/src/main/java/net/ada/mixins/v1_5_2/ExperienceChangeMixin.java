package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ExperienceChangeEvent;
import net.minecraft.src.EntityPlayer;
@Mixin(EntityPlayer.class)
public class ExperienceChangeMixin {
    @Inject(method = "addExperience", at = At.HEAD)
    private void herz$addExperience(int amount) {
        EventBus.INSTANCE.post(new ExperienceChangeEvent((EntityPlayer) (Object) this, amount));
    }
}
