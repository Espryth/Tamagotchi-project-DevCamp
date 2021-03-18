package com.maimai.tamagotchi.tamagotchi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.statistic.Statistic;


public interface Tamagotchi extends Entity {

    @JsonProperty("isAlive")
    boolean isAlive();

    void setAlive(boolean alive);

    @JsonProperty("type")
    TamagotchiType getType();

    @JsonIgnore
    Manager<String, Action<Player>> getActionManager();

    @JsonProperty("hunger")
    Statistic<Double> getHunger();

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

    @JsonProperty("isFatigue")
    boolean isFatigue();
}
