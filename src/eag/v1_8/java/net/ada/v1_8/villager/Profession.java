package net.ada.v1_8.villager;

import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public final class Profession {

    public final int id;
    public final ResourceLocation texture;
    public final List<TradeEntry> trades = new ArrayList<>();

    Profession(int id, ResourceLocation texture) {
        this.id = id;
        this.texture = texture;
    }

    public Profession addTrade(TradeEntry trade) {
        trades.add(trade);
        return this;
    }
}
