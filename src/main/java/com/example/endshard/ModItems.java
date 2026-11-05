package com.example.endshard;

import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class ModItems {
    // ---- материалы
    public static final Item END_SHARD = register("end_shard", Item::new, new Item.Settings());
    public static final Item END_SHARD_INGOT = register("end_shard_ingot", Item::new, new Item.Settings());

    // ---- инструменты (урон/скорость - как у алмазных, плюс бонус материала)
    public static final Item END_SHARD_SWORD = register("end_shard_sword", Item::new,
            new Item.Settings().sword(ModToolMaterial.END_SHARD, 3.0F, -2.4F));
    public static final Item END_SHARD_PICKAXE = register("end_shard_pickaxe", Item::new,
            new Item.Settings().pickaxe(ModToolMaterial.END_SHARD, 1.0F, -2.8F));
    public static final Item END_SHARD_AXE = register("end_shard_axe",
            s -> new AxeItem(ModToolMaterial.END_SHARD, 5.0F, -3.0F, s), new Item.Settings());
    public static final Item END_SHARD_SHOVEL = register("end_shard_shovel",
            s -> new ShovelItem(ModToolMaterial.END_SHARD, 1.5F, -3.0F, s), new Item.Settings());
    public static final Item END_SHARD_HOE = register("end_shard_hoe",
            s -> new HoeItem(ModToolMaterial.END_SHARD, -5.0F, 0.0F, s), new Item.Settings());

    // ---- броня
    public static final Item END_SHARD_HELMET = register("end_shard_helmet", Item::new,
            new Item.Settings().armor(ModArmorMaterial.END_SHARD, EquipmentType.HELMET));
    public static final Item END_SHARD_CHESTPLATE = register("end_shard_chestplate", Item::new,
            new Item.Settings().armor(ModArmorMaterial.END_SHARD, EquipmentType.CHESTPLATE));
    public static final Item END_SHARD_LEGGINGS = register("end_shard_leggings", Item::new,
            new Item.Settings().armor(ModArmorMaterial.END_SHARD, EquipmentType.LEGGINGS));
    public static final Item END_SHARD_BOOTS = register("end_shard_boots", Item::new,
            new Item.Settings().armor(ModArmorMaterial.END_SHARD, EquipmentType.BOOTS));

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(EndShardMod.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, factory.apply(settings.registryKey(key)));
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(e -> e.add(ModBlocks.END_SHARD_ORE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(e -> {
            e.add(END_SHARD);
            e.add(END_SHARD_INGOT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(e -> {
            e.add(END_SHARD_SHOVEL);
            e.add(END_SHARD_PICKAXE);
            e.add(END_SHARD_AXE);
            e.add(END_SHARD_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(e -> {
            e.add(END_SHARD_SWORD);
            e.add(END_SHARD_AXE);
            e.add(END_SHARD_HELMET);
            e.add(END_SHARD_CHESTPLATE);
            e.add(END_SHARD_LEGGINGS);
            e.add(END_SHARD_BOOTS);
        });
    }

    private ModItems() {}
}
