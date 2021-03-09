package com.maimai.tamagotchi.tamagotchi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.statistic.impl.DoubleStatistic;


public interface Tamagotchi extends Entity {

    @JsonProperty("isAlive")
    boolean isAlive();

    void setAlive(boolean alive);

    @JsonProperty("type")
    TamagotchiType getType();

    @JsonIgnore
    Manager<Action<Tamagotchi>> getActionManager();

    @JsonProperty("hunger")
    Statistic<Double> getHunger();

    @JsonProperty("health")
    Statistic<Double> getHealth();

    @JsonProperty("thirst")
    Statistic<Double> getThirst();

    @JsonProperty("dirty")
    Statistic<Double> getDirty();
}
