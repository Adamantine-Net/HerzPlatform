package net.ada.example.backpack;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiBackpack extends GuiContainer {

    private static final ResourceLocation TEXTURE = new ResourceLocation("ada_example:textures/gui/backpack.png");

    public GuiBackpack(InventoryPlayer playerInv, IInventory backpackInventory) {
        super(new ContainerBackpack(playerInv, backpackInventory));
        xSize = 176;
        ySize = 222;
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(TEXTURE);
        int left = (width - xSize) / 2;
        int top = (height - ySize) / 2;
        drawTexturedModalRect(left, top, 0, 0, xSize, ySize);
    }
}
