package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ItemStackSplitEvent;
import net.minecraft.item.ItemStack;
@Mixin(ItemStack.class)
public class ItemStackSplitMixin {
    @Inject(method = "splitStack", at = At.HEAD)
    private void herz$splitStack(int amount) {
        EventBus.INSTANCE.post(new ItemStackSplitEvent((ItemStack) (Object) this, amount));
    }
}
