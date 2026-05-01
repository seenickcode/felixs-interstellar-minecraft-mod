# Fabric Mod – 1.21

## Running
```
./gradlew runClient
```

## Custom Dimension: Farmland

A flat, wheat-covered dimension with a sandy golden sky.

**To enter in-game:**
```
/execute in modid:farmland run tp @s 0 5 0
```

**Key files:**
- `src/main/resources/data/modid/dimension/farmland.json` — flat world layers (bedrock → stone → coarse dirt → farmland)
- `src/main/resources/data/modid/dimension_type/farmland.json` — dimension type registration
- `src/main/resources/data/modid/worldgen/biome/interstellar_farmland.json` — sky color (`#C8A864`), water color, wheat feature reference
- `src/main/resources/data/modid/worldgen/configured_feature/wheat_field.json` — wheat patch config (96 tries, radius 8, fully grown age 7)
- `src/main/resources/data/modid/worldgen/placed_feature/wheat_field.json` — placement config

**To tweak the look:** edit `interstellar_farmland.json` (sky/water color, temperature, precipitation).  
**To tweak wheat density:** edit `wheat_field.json` (`tries`, `xz_spread`).  
**To change terrain layers:** edit `farmland.json` (`layers` array).

## Special Spawn Block

On every respawn, a `modid:special_spawn_block` is placed directly under the player. It glows (luminance 10), is stone-colored, and requires a tool to break.

**To test:** die or use `/kill @s`, then observe the glowing block placed at your feet on respawn.

**Key files:**
- `src/main/java/com/example/block/ExampleBlocks.java` — block definition and registration
- `src/main/java/com/example/block/SpecialSpawnBlock.java` — block class
- `src/main/java/com/example/event/ExampleEvents.java` — respawn event hook that places the block
