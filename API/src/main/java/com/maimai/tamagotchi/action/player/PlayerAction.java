package com.maimai.tamagotchi.action.player;

import com.maimai.tamagotchi.action.AbstractAction;

import com.maimai.tamagotchi.action.ActionHandler;
import com.maimai.tamagotchi.player.Player;

public class PlayerAction extends AbstractAction<Player> {

    public PlayerAction(String name, ActionHandler<Player> actionHandler) {
        super(name, actionHandler);
    }

}
