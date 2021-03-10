package com.maimai.tamagotchi.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.Nameable;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.player.inventory.Inventory;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public interface Player extends Nameable {

    @JsonProperty("tamagotchi")
    Tamagotchi getTamagotchi();

    @JsonProperty("inventory")
    Inventory getInventory();

    @JsonIgnore
    Manager<Action<Tamagotchi>> getActionManager();

    @JsonProperty("money")
    Statistic<Integer> getMoney();

}
