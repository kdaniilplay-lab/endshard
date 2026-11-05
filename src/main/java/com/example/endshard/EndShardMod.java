package com.example.endshard;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class EndShardMod implements ModInitializer {
    public static final String MOD_ID = "endshard";

    public static final RegistryKey<PlacedFeature> END_SHARD_ORE_PLACED =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "end_shard_ore"));

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();

        // Руда генерируется во всех биомах Края (остров дракона и внешние острова)
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                END_SHARD_ORE_PLACED);
    }
}
