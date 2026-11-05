package com.example.endshard;

import java.util.Map;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public final class ModArmorMaterial {
    /** Ссылка на assets/endshard/equipment/end_shard.json (внешний вид брони) */
    public static final RegistryKey<EquipmentAsset> ASSET_KEY =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(EndShardMod.MOD_ID, "end_shard"));

    // Незеритовая: прочность 37, защита 3/8/6/3, твёрдость 3, сопротивление отбрасыванию 0.1
    public static final ArmorMaterial END_SHARD = new ArmorMaterial(
            55,
            Map.of(
                    EquipmentType.HELMET, 4,
                    EquipmentType.CHESTPLATE, 9,
                    EquipmentType.LEGGINGS, 7,
                    EquipmentType.BOOTS, 4,
                    EquipmentType.BODY, 13),
            25,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            4.0F,
            0.15F,
            ModTags.REPAIRS_END_SHARD_GEAR,
            ASSET_KEY);

    private ModArmorMaterial() {}
}
