package com.example.block;

import com.example.ExampleMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ExampleBlocks {
    private static final RegistryKey<Block> SPECIAL_SPAWN_BLOCK_KEY =
        RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExampleMod.MOD_ID, "special_spawn_block"));

    private static final RegistryKey<Item> SPECIAL_SPAWN_BLOCK_ITEM_KEY =
        RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, "special_spawn_block"));

    public static final Block SPECIAL_SPAWN_BLOCK = Registry.register(
        Registries.BLOCK,
        SPECIAL_SPAWN_BLOCK_KEY,
        new SpecialSpawnBlock(AbstractBlock.Settings.create()
            .registryKey(SPECIAL_SPAWN_BLOCK_KEY)
            .mapColor(MapColor.STONE_GRAY)
            .instrument(NoteBlockInstrument.BASS)
            .strength(3.0f)
            .requiresTool()
            .luminance(state -> 10))
    );

    public static final Item SPECIAL_SPAWN_BLOCK_ITEM = Registry.register(
        Registries.ITEM,
        SPECIAL_SPAWN_BLOCK_ITEM_KEY,
        new BlockItem(SPECIAL_SPAWN_BLOCK, new Item.Settings().registryKey(SPECIAL_SPAWN_BLOCK_ITEM_KEY))
    );

    public static void register() {}
}
