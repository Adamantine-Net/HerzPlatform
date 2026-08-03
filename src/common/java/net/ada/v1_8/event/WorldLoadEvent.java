package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.client.multiplayer.WorldClient;

public class WorldLoadEvent extends Event {

    public final WorldClient world;

    public WorldLoadEvent(WorldClient world) {
        this.world = world;
    }
}
