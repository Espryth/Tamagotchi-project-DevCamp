package com.maimai.tamagotchi.item;

import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

@FunctionalInterface
public interface ItemHandler {
    void consume(Tamagotchi tamagotchi, Player player);
}
