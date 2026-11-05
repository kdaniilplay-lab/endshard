package com.example.endshard;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public final class ModToolMaterial {
    //                                       какие блоки НЕ дропаются,          прочность, скорость, бонус урона, зачарование, чем чинить
    // Незеритовый: 2031 / 9.0 / 4.0 / 15
    public static final ToolMaterial END_SHARD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            4000,
            14.0F,
            6.0F,
            25,
            ModTags.REPAIRS_END_SHARD_GEAR);

    private ModToolMaterial() {}
}
