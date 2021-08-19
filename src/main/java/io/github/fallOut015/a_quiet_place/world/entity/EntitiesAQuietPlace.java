package io.github.fallOut015.a_quiet_place.world.entity;

import io.github.fallOut015.a_quiet_place.MainAQuietPlace;
import io.github.fallOut015.a_quiet_place.world.entity.monster.death_angel.DeathAngel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntitiesAQuietPlace {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MainAQuietPlace.MODID);



    public static RegistryObject<EntityType<DeathAngel>> DEATH_ANGEL = ENTITIES.register("death_angel", () -> EntityType.Builder.of(DeathAngel::new, MobCategory.MONSTER).canSpawnFarFromPlayer().fireImmune().sized(2.0f, 3.0f).build("death_angel"));



    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}