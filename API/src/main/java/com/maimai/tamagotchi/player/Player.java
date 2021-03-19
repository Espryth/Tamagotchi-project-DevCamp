package com.maimai.tamagotchi.player;

import com.maimai.tamagotchi.Model;
import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.player.language.Language;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public interface Player extends Entity, Model {

    Tamagotchi getTamagotchi();

    Inventory getInventory();

    Statistic<Double> getMoney();

    Language getLanguage();

}
