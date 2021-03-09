package com.maimai.tamagotchi.tamagotchi;

import com.maimai.tamagotchi.Manager;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.ActionManager;
import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.action.tamagotchi.TamagotchiAction;
import com.maimai.tamagotchi.statistic.impl.DoubleStatistic;

import java.util.List;

public interface Tamagotchi extends Entity {

    boolean isAlive();

    void setAlive(boolean alive);

    TamagotchiType getType();

    void setType(TamagotchiType type);



    List<Action<Tamagotchi>> getActions();

    void setActions(List<TamagotchiAction> actions);

    DoubleStatistic getHunger();

    void setHunger(DoubleStatistic hunger);

    DoubleStatistic getHealth();

    void setHealth(DoubleStatistic health);

    DoubleStatistic getThirst();

    void setThirst(DoubleStatistic thirst);

    DoubleStatistic getDirty();

    void setDirty(DoubleStatistic dirty);
}
