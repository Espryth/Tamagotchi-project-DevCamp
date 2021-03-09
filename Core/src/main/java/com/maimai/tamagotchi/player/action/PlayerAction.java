package com.maimai.tamagotchi.player.action;

import com.maimai.tamagotchi.action.AbstractAction;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.ActionHandler;
import com.maimai.tamagotchi.player.Player;

public class PlayerAction extends AbstractAction<Player> {

    public PlayerAction(ActionHandler<Player> actionHandler) {
        super(actionHandler);
    }

    public static class Builder extends AbstractAction.Builder<Player> {

        @Override
        public Action<Player> build() {
            return new PlayerAction(getActionHandler());
        }

    }
}
