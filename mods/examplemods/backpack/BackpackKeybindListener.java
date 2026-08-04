package net.ada.example.backpack;

import net.ada.api.event.SubscribeEvent;
import net.ada.v1_8.event.GuiKeyTypedEvent;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;

public class BackpackKeybindListener {

    public static final ItemBackpack BACKPACK_ITEM = new ItemBackpack();

    @SubscribeEvent
    public void onKeyTyped(GuiKeyTypedEvent event) {
        if (event.keyCode != KeyboardConstants.KEY_B) {
            return;
        }

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.thePlayer;
        if (player == null) {
            return; // shouldnt happen but if it does no crash :D
        }

        ItemStack backpackStack = findBackpack(player);
        if (backpackStack == null) {
            return; //no backpack equipped dont do shit
        }

        BackpackInventory inventory = new BackpackInventory(backpackStack);
        mc.displayGuiScreen(new GuiBackpack(player.inventory, inventory));
        event.cancel(); // eat the keypress so it doesnt also do whatever B normally does
    }

    private ItemStack findBackpack(EntityPlayerSP player) {
        ItemStack held = player.getCurrentEquippedItem();
        if (held != null && held.getItem() == BACKPACK_ITEM) {
            return held;
        }

        //2 is chestplate
        ItemStack chest = player.inventory.armorInventory[2];
        if (chest != null && chest.getItem() == BACKPACK_ITEM) {
            return chest;
        }

        return null; //the held items always wins idk how you have the same backpack in 2 spots but :sob:
    }
}
