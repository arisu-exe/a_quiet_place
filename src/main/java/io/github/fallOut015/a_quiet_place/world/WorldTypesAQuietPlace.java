package io.github.fallOut015.a_quiet_place.world;

import io.github.fallOut015.a_quiet_place.MainAQuietPlace;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.OverworldBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldTypesAQuietPlace {
    private static final DeferredRegister<ForgeWorldType> WORLD_TYPES = DeferredRegister.create(ForgeRegistries.WORLD_TYPES, MainAQuietPlace.MODID);



    public static RegistryObject<ForgeWorldType> A_QUIET_PLACE = WORLD_TYPES.register("a_quiet_place", () -> new ForgeWorldType((biomeRegistry, dimensionSettingsRegistry, seed) -> new NoiseBasedChunkGenerator(new OverworldBiomeSource(seed, false, false, biomeRegistry), seed, () -> dimensionSettingsRegistry.getOrThrow(NoiseGeneratorSettings.OVERWORLD))));



    public static void register(IEventBus bus) {
        WORLD_TYPES.register(bus);
    }
}
