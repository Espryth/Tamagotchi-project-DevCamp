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

    boolean isAlive();

    void setAlive(boolean alive);

    TamagotchiType getType();

    Manager<String, Action> getActionManager();

    Statistic<Double> getHunger();

    boolean isHunger();

    Statistic<Double> getHealth();

    Statistic<Double> getThirst();

    Statistic<Double> getDirty();

    Statistic<Double> getHappiness();

    Statistic<Double> getFatigue();

    void registerDefaultActions(ProgramCore core);
}
