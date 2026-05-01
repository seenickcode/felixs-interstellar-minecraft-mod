package com.example.event;

import com.example.ExampleMod;
import com.example.block.ExampleBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class ExampleEvents {
    public static void register() {
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            ServerPlayerEntity player = newPlayer;
            BlockPos pos = player.getBlockPos().down();
            BlockState specialBlock = ExampleBlocks.SPECIAL_SPAWN_BLOCK.getDefaultState();
            player.getEntityWorld().setBlockState(pos, specialBlock, 3);
            ExampleMod.LOGGER.info("Spawned special block for " + player.getName().getString());
        });
    }
}
