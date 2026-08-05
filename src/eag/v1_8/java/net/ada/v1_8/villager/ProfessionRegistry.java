package net.ada.v1_8.villager;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public final class ProfessionRegistry {

    private static int nextId = 5;// oops last time it was 2 and I fucked up all the other villys lol
    private static final Map<Integer, Profession> byId = new HashMap<>();

    public static Profession register(String name, ResourceLocation texture) {
        Profession profession = new Profession(nextId++, texture);
        byId.put(profession.id, profession);
        return profession;
    }

    public static Profession get(int id) {
        return byId.get(id);
    }

    private ProfessionRegistry() {
    }
}
