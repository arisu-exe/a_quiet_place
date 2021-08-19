package io.github.fallOut015.a_quiet_place.world.item;

import io.github.fallOut015.a_quiet_place.MainAQuietPlace;
import io.github.fallOut015.a_quiet_place.world.entity.EntitiesAQuietPlace;
import io.github.fallOut015.a_quiet_place.world.level.block.BlocksAQuietPlace;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsAQuietPlace {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainAQuietPlace.MODID);



    public static RegistryObject<Item> METEORITE = ITEMS.register("meteorite", () -> new BlockItem(BlocksAQuietPlace.METEORITE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static RegistryObject<Item> DEATH_ANGEL_SPAWN_EGG = ITEMS.register("death_angel_spawn_egg", () -> new SpawnEggItemAQuietPlace(EntitiesAQuietPlace.DEATH_ANGEL::get, 13086008, 10230296, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));



    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
