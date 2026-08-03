package net.ada.mixins.v1_5_2;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.callback.CallbackInfo;
import net.ada.v1_5_2.loot.EntityLootModifier;
import net.ada.v1_5_2.loot.EntityLootRegistry;

import net.minecraft.src.EntityLiving;

@Mixin(EntityLiving.class)
public class EntityDropsMixin {

    @Inject(method = "dropFewItems", at = At.HEAD, cancellable = true)
    private void herz$dropFewItems(boolean recentlyHit, int looting, CallbackInfo ci) {
        EntityLiving self = (EntityLiving) (Object) this;
        EntityLootModifier modifier = EntityLootRegistry.get(self.getClass());
        if (modifier != null) {
            modifier.drop(self, recentlyHit, looting);
            ci.cancel();
        }
    }
}
