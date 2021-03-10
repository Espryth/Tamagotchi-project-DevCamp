package com.maimai.tamagotchi.player;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.player.inventory.Inventory;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class SimplePlayer implements Player {
    @Override
    public Tamagotchi getTamagotchi() {
        return null;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    @Override
    public Manager<Action<Tamagotchi>> getActionManager() {
        return null;
    }

    @Override
    public Statistic<Integer> getMoney() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
