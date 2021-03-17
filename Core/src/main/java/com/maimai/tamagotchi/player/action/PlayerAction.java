package com.maimai.tamagotchi.player.action;

import com.maimai.tamagotchi.action.AbstractAction;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.ActionExecutor;
import com.maimai.tamagotchi.action.ActionRequirement;
import com.maimai.tamagotchi.builder.IBuilder;
import com.maimai.tamagotchi.player.Player;

public class PlayerAction extends AbstractAction<Player> {

    public PlayerAction(ActionExecutor<Player> actionExecutor, ActionRequirement<Player> actionRequirement) {
        super(actionExecutor, actionRequirement);
    }

    public static class Builder implements IBuilder<Action<Player>> {

        private ActionExecutor<Player> actionExecutor;

        public Builder createExecutor(ActionExecutor<Player> actionExecutor) {
            this.actionExecutor = actionExecutor;
            return this;
        }

        @Override
        public Action<Player> build() {
            return new PlayerAction(actionExecutor, null);
        }

    }
}
