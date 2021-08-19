package io.github.fallOut015.a_quiet_place.world.level.block;

import io.github.fallOut015.a_quiet_place.MainAQuietPlace;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksAQuietPlace {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MainAQuietPlace.MODID);



    public static RegistryObject<Block> METEORITE = BLOCKS.register("meteorite", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(10.0f)));



    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
