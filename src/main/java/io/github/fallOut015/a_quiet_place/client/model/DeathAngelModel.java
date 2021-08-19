package io.github.fallOut015.a_quiet_place.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class DeathAngelModel<T extends LivingEntity> extends HumanoidModel<T> {
    public DeathAngelModel(ModelPart modelPart) {
        super(modelPart);
    }
}