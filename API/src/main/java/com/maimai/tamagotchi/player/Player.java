package com.maimai.tamagotchi.player;

import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.player.inventory.Inventory;
import com.maimai.tamagotchi.statistic.impl.IntegerStatistic;
import com.maimai.tamagotchi.action.PlayerAction;

import java.util.List;

public interface Player extends Entity {

    Inventory getInventory();

    void setInventory(Inventory inventory);

    List<PlayerAction> getActions();

    void setActions(List<PlayerAction> actions);

    IntegerStatistic getMoney();

    void setMoney(IntegerStatistic money);


}
