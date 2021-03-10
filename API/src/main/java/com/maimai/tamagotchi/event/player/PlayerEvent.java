package com.maimai.tamagotchi.event.player;

import com.maimai.tamagotchi.event.Event;
import com.maimai.tamagotchi.player.Player;

public class PlayerEvent extends Event {

    private final Player player;

    public PlayerEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
