package com.maimai.tamagotchi.command.part.defaults;

import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.command.part.ArgumentPart;
import com.maimai.tamagotchi.player.Player;

import java.lang.reflect.Type;

public class PlayerPart implements ArgumentPart<Player> {
    @Override
    public Player parse(ArgumentStack argumentStack) {
        return null;
    }

    @Override
    public Type getType() {
        return Player.class;
    }
}
