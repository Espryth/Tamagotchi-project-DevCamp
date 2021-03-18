package com.maimai.tamagotchi.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public interface Player extends Entity {

    @JsonProperty("tamagotchi")
    Tamagotchi getTamagotchi();

    @JsonProperty("inventory")
    Inventory getInventory();

    @JsonProperty("money")
    Statistic<Integer> getMoney();

}
