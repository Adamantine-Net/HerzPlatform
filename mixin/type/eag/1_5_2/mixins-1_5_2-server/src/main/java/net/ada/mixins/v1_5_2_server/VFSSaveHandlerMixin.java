package net.ada.mixins.v1_5_2_server;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.persist.PersistentIds;

import net.lax1dude.eaglercraft.sp.VFSSaveHandler;
import net.lax1dude.eaglercraft.sp.VFile;
import net.minecraft.src.WorldInfo;

import java.io.UnsupportedEncodingException;

@Mixin(VFSSaveHandler.class)
public class VFSSaveHandlerMixin {

    @Inject(method = "saveWorldInfo", at = At.TAIL)
    private void herz$afterSaveWorldInfo(WorldInfo worldInformation) {
        VFile file = new VFile(((VFSSaveHandler) (Object) this).worldDirectory, "notanorange_idmap.txt");
        file.setAllBytes(toBytesUtf8(PersistentIds.snapshot()));
    }

    @Inject(method = "loadWorldInfo", at = At.HEAD)
    private void herz$beforeLoadWorldInfo() {
        VFile file = new VFile(((VFSSaveHandler) (Object) this).worldDirectory, "notanorange_idmap.txt");
        if (file.exists()) {
            PersistentIds.verifyOrThrow(toStringUtf8(file.getAllBytes()));
        }
    }

    private static String toStringUtf8(byte[] data) {
        try {
            return new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] toBytesUtf8(String s) {
        try {
            return s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
