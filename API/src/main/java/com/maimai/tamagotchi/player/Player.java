package com.maimai.tamagotchi.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public interface Player extends Entity {

    @JsonProperty("tamagotchi")
    Tamagotchi getTamagotchi();

    @JsonProperty("inventory")
    Inventory getInventory();

    @JsonIgnore
    Manager<String, Action<Player>> getActionManager();

    @JsonProperty("money")
    Statistic<Integer> getMoney();

}
