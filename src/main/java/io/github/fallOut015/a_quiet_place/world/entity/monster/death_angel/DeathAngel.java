package io.github.fallOut015.a_quiet_place.world.entity.monster.death_angel;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;

import javax.annotation.Nullable;

public class DeathAngel extends Monster implements VibrationListener.VibrationListenerConfig {
    private int leaveTimer;
    private static final EntityDataAccessor<Integer> TASK;

    static {
        TASK = SynchedEntityData.defineId(DeathAngel.class, EntityDataSerializers.INT);
    }

    public DeathAngel(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.leaveTimer = 0;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 1024.0D).add(Attributes.MOVEMENT_SPEED, (double)0.5F).add(Attributes.ATTACK_DAMAGE, 20.0D).add(Attributes.ARMOR, 20.0D);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(TASK, 0);
        super.defineSynchedData();
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putInt("TASK", this.entityData.get(TASK).intValue());
        super.addAdditionalSaveData(tag);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        this.entityData.set(TASK, Integer.valueOf(tag.getInt("TASK")));
        super.readAdditionalSaveData(tag);
    }

    public void stalk() {
        this.entityData.set(TASK, Integer.valueOf(0));
    }
    public void investigate() {
        this.entityData.set(TASK, Integer.valueOf(1));
    }
    public void silence() {
        this.entityData.set(TASK, Integer.valueOf(2));
    }
    public boolean isStalking() {
        return this.entityData.get(TASK).intValue() == 0;
    }
    public boolean isInvestigating() {
        return this.entityData.get(TASK).intValue() == 1;
    }
    public boolean isSilencing() {
        return this.entityData.get(TASK).intValue() == 2;
    }

    @Override
    public boolean shouldListen(Level level, GameEventListener gameEventListener, BlockPos blockPos, GameEvent gameEvent, @Nullable Entity entity) {
        return true;
    }
    @Override
    public void onSignalReceive(Level level, GameEventListener gameEventListener, GameEvent gameEvent, int i) {
        if(this.isStalking()) {
            this.investigate();
        } else if(this.isInvestigating()) {
            this.silence();
        }
    }
}