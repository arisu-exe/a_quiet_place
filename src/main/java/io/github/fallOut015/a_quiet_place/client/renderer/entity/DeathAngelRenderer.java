package io.github.fallOut015.a_quiet_place.client.renderer.entity;

import io.github.fallOut015.a_quiet_place.MainAQuietPlace;
import io.github.fallOut015.a_quiet_place.client.model.DeathAngelModel;
import io.github.fallOut015.a_quiet_place.client.model.geom.ModelLayersAQuietPlace;
import io.github.fallOut015.a_quiet_place.world.entity.monster.death_angel.DeathAngel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeathAngelRenderer extends MobRenderer<DeathAngel, DeathAngelModel<DeathAngel>> {
    private static final ResourceLocation DEATH_ANGEL_LOCATION = new ResourceLocation(MainAQuietPlace.MODID, "textures/entity/death_angel/death_angel.png");

    public DeathAngelRenderer(EntityRendererProvider.Context context) {
        super(context, new DeathAngelModel<>(context.bakeLayer(ModelLayersAQuietPlace.DEATH_ANGEL)), 2.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(DeathAngel deathAngel) {
        return DEATH_ANGEL_LOCATION;
    }
}