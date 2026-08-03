package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.WorldLoadEvent;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldSettings;

@Mixin(WorldClient.class)
public class WorldLoadMixin {

    @Inject(method = "<init>", at = At.TAIL)
    private void herz$onWorldLoad(NetHandlerPlayClient parNetHandlerPlayClient, WorldSettings parWorldSettings,
                                   int parInt1, EnumDifficulty parEnumDifficulty) {
        EventBus.INSTANCE.post(new WorldLoadEvent((WorldClient) (Object) this));
    }
}
