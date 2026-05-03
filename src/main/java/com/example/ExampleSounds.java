package com.example;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ExampleSounds {

    public static final SoundEvent INTRO_MUSIC =
        SoundEvent.of(Identifier.of(ExampleMod.MOD_ID, "intro_music"));

    public static void register() {
        Registry.register(Registries.SOUND_EVENT,
            Identifier.of(ExampleMod.MOD_ID, "intro_music"), INTRO_MUSIC);
    }
}
