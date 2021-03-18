package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.player.Player;

@FunctionalInterface
public interface ActionRequirement {
    boolean requeriment(Player player, Item item);
}
