package com.maimai.tamagotchi.command.part;

import com.maimai.tamagotchi.command.ArgumentPart;
import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.command.exception.ArgumentParseException;
import com.maimai.tamagotchi.player.Player;

public class PlayerPart implements ArgumentPart<Player> {

    private final Player player;

    public PlayerPart(Player player) {
        this.player = player;
    }

    @Override
    public Player parse(ArgumentStack argumentStack) {

        String argument = argumentStack.next();

        if(argument == null) {
            throw new ArgumentParseException("Error al parsear player");
        }

        return player;
    }
}
