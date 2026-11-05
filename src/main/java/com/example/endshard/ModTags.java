package com.example.endshard;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModTags {
    /** Чем чинится снаряжение (см. data/endshard/tags/item/repairs_end_shard_gear.json) */
    public static final TagKey<Item> REPAIRS_END_SHARD_GEAR =
            TagKey.of(RegistryKeys.ITEM, Identifier.of(EndShardMod.MOD_ID, "repairs_end_shard_gear"));

    private ModTags() {}
}
