package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.Shadow;
import net.ada.v1_8.persist.PersistentIds;

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
