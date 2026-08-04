package net.ada.mixins.v1_5_2;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.callback.CallbackInfo;
import net.ada.v1_5_2.loot.LootModifier;
import net.ada.v1_5_2.loot.LootRegistry;

import net.minecraft.src.Block;
import net.minecraft.src.World;

@Mixin(Block.class)
public class BlockDropsMixin {

    @Inject(method = "dropBlockAsItemWithChance", at = At.HEAD, cancellable = true)
    private void herz$dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata,
                                                 float chance, int fortune, CallbackInfo ci) {
        LootModifier modifier = LootRegistry.get((Block) (Object) this);
        if (modifier != null) {
            modifier.drop(world, x, y, z, metadata, chance, fortune);
            ci.cancel();
        }
    }
}
