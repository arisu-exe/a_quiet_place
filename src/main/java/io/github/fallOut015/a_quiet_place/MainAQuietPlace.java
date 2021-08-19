package io.github.fallOut015.a_quiet_place;

import io.github.fallOut015.a_quiet_place.client.renderer.entity.DeathAngelRenderer;
import io.github.fallOut015.a_quiet_place.world.WorldTypesAQuietPlace;
import io.github.fallOut015.a_quiet_place.world.entity.EntitiesAQuietPlace;
import io.github.fallOut015.a_quiet_place.world.entity.monster.death_angel.DeathAngel;
import io.github.fallOut015.a_quiet_place.world.item.ItemsAQuietPlace;
import io.github.fallOut015.a_quiet_place.world.level.block.BlocksAQuietPlace;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

@Mod(MainAQuietPlace.MODID)
public class MainAQuietPlace {
    public static final String MODID = "a_quiet_place";

    public MainAQuietPlace() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        MinecraftForge.EVENT_BUS.register(this);

        BlocksAQuietPlace.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemsAQuietPlace.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntitiesAQuietPlace.register(FMLJavaModLoadingContext.get().getModEventBus());
        WorldTypesAQuietPlace.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {
    }
    private void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
            event.put(EntitiesAQuietPlace.DEATH_ANGEL.get(), DeathAngel.createAttributes().build());
        }
        /*@SubscribeEvent
        public static void entityRenderersRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(EntitiesAQuietPlace.DEATH_ANGEL.get(), DeathAngelRenderer::new);
        }*/
    }

    @Mod.EventBusSubscriber
    public static class Events {
        @SubscribeEvent
        public static void playSound(final PlaySoundEvent event) {
            if(event.getSound() != null) {
                int random = new Random().nextInt(ForgeRegistries.SOUND_EVENTS.getValues().toArray(SoundEvent[]::new).length);
                SoundInstance sound = new SimpleSoundInstance(ForgeRegistries.SOUND_EVENTS.getValues().toArray(SoundEvent[]::new)[random], event.getSound().getSource(), 1.0f, 1.0f, new BlockPos(event.getSound().getX(), event.getSound().getY(), event.getSound().getZ()));
                event.setResultSound(sound);
            }
        }
    }
}