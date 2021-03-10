package com.maimai.tamagotchi.player.action;

import com.maimai.tamagotchi.action.AbstractAction;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.ActionExecutor;
import com.maimai.tamagotchi.player.Player;

public class PlayerAction extends AbstractAction<Player> {

    public PlayerAction(ActionExecutor<Player> actionExecutor) {
        super(actionExecutor);
    }

    public static class Builder extends AbstractAction.Builder<Player> {

        @Override
        public Action<Player> build() {
            return new PlayerAction(getActionExecutor());
        }

    }
}
