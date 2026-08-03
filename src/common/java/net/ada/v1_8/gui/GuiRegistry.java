package net.ada.v1_8.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.world.IInteractionObject;

import java.util.HashMap;
import java.util.Map;

public final class GuiRegistry {

    private static final Map<String, GuiFactory> byId = new HashMap<>();

    public static void register(String guiId, GuiFactory factory) {
        byId.put(guiId, factory);
    }

    public static GuiScreen create(String guiId, IInteractionObject owner) {
        GuiFactory factory = byId.get(guiId);
        return factory != null ? factory.create(owner) : null;
    }

    private GuiRegistry() {
    }
}
