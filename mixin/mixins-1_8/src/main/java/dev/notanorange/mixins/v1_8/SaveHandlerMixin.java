package dev.notanorange.mixins.v1_8;

import dev.notanorange.mixin.annotation.At;
import dev.notanorange.mixin.annotation.Inject;
import dev.notanorange.mixin.annotation.Mixin;
import dev.notanorange.mixin.annotation.Shadow;
import dev.notanorange.v1_8.persist.PersistentIds;

import net.lax1dude.eaglercraft.v1_8.internal.vfs2.VFile2;
import net.lax1dude.eaglercraft.v1_8.sp.server.WorldsDB;
import net.minecraft.world.storage.SaveHandler;
import net.minecraft.world.storage.WorldInfo;

@Mixin(SaveHandler.class)
public class SaveHandlerMixin {

    @Shadow
    public VFile2 getWorldDirectory() {
        return null;
    }

    @Inject(method = "saveWorldInfo", at = At.TAIL)
    private void herz$afterSaveWorldInfo(WorldInfo worldInformation) {
        VFile2 file = WorldsDB.newVFile(getWorldDirectory(), "notanorange_idmap.txt");
        file.setAllChars(PersistentIds.snapshot());
    }

    @Inject(method = "loadWorldInfo", at = At.HEAD)
    private void herz$beforeLoadWorldInfo() {
        VFile2 file = WorldsDB.newVFile(getWorldDirectory(), "notanorange_idmap.txt");
        if (file.exists()) {
            PersistentIds.verifyOrThrow(file.getAllChars());
        }
    }
}
