package com.maimai.tamagotchi.tamagotchi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.statistic.Statistic;

public interface Tamagotchi extends Entity {

    @JsonProperty("isAlive")
    boolean isAlive();

    void setAlive(boolean alive);

    @JsonProperty("type")
    TamagotchiType getType();

    @JsonIgnore
    Manager<String, Action> getActionManager();

    @JsonProperty("hunger")
    Statistic<Double> getHunger();

    @JsonIgnore
    boolean isHunger();

    @JsonProperty("health")
    Statistic<Double> getHealth();

    @JsonProperty("thirst")
    Statistic<Double> getThirst();

    @JsonProperty("dirty")
    Statistic<Double> getDirty();

    @JsonProperty("happiness")
    Statistic<Double> getHappiness();

    @JsonProperty("fatigue")
    Statistic<Double> getFatigue();

    @JsonIgnore
    void registerDefaultActions(ProgramCore core);
}
