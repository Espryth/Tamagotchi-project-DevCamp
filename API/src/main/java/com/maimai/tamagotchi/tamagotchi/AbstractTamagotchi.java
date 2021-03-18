package com.maimai.tamagotchi.tamagotchi;

import com.maimai.tamagotchi.action.Action;

import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.manager.ManagerImpl;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.statistic.impl.DoubleStatistic;

import java.beans.ConstructorProperties;
import java.util.UUID;

public abstract class AbstractTamagotchi implements Tamagotchi {

    private final String id;
    private final String name;
    private final TamagotchiType type;
    private boolean alive;

    private final Statistic<Double> hunger;
    private final Statistic<Double> health;
    private final Statistic<Double> thirst;
    private final Statistic<Double> dirty;
    private final Statistic<Double> happiness;

    private final Manager<String, Action<Player>> actionManager;
    private final Statistic<Double> fatigue;

    @ConstructorProperties({
            "name",
            "type"
    })
    public AbstractTamagotchi(String name,
                              TamagotchiType type) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.alive = true;

        this.hunger = new DoubleStatistic();
        this.health = new DoubleStatistic();
        this.thirst = new DoubleStatistic();
        this.dirty = new DoubleStatistic();
        this.happiness = new DoubleStatistic();
        this.fatigue = new DoubleStatistic();

        this.actionManager = new ManagerImpl<>();
        
        registerActions();
        registerDefaultActions();
    }

    public abstract void registerActions();

    protected void registerAction(String name, Action<Player> action) {
        getActionManager().insert(name, action);
    }

    private void registerDefaultActions() {

    }


    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public TamagotchiType getType() {
        return type;
    }

    @Override
    public Manager<String, Action<Player>> getActionManager() {
        return actionManager;
    }

    @Override
    public Statistic<Double> getHunger() {
        return hunger;
    }

    @Override
    public Statistic<Double> getHealth() {
        return health;
    }

    @Override
    public Statistic<Double> getThirst() {
        return thirst;
    }

    @Override
    public Statistic<Double> getDirty() {
        return dirty;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public Statistic<Double> getHappiness() {
        return happiness;
    }

    @Override
    public Statistic<Double> getFatigue() {
        return fatigue;
    }

    @Override
    public boolean isFatigue() {
        return fatigue.getValue() >= 90;
    }
}
