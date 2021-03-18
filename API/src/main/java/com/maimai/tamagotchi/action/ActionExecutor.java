package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.player.Player;

@FunctionalInterface
public interface ActionExecutor {
    void execute(Player player, Item item);
}
