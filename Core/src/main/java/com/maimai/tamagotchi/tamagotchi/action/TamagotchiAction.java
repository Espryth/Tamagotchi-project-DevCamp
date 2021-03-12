package com.maimai.tamagotchi.tamagotchi.action;

import com.maimai.tamagotchi.action.AbstractAction;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.ActionExecutor;
import com.maimai.tamagotchi.action.ActionRequirement;
import com.maimai.tamagotchi.builder.IBuilder;
import com.maimai.tamagotchi.player.Player;

public class TamagotchiAction extends AbstractAction<Player> {

    public TamagotchiAction(ActionExecutor<Player> actionExecutor,
                            ActionRequirement<Player> actionRequirement) {
        super(actionExecutor, actionRequirement);
    }

    public static class Builder implements IBuilder<Action<Player>> {

        private ActionExecutor<Player> actionExecutor;

        private ActionRequirement<Player> actionRequirement;

        public Builder createExecutor(ActionExecutor<Player> actionExecutor) {
            this.actionExecutor = actionExecutor;
            return this;
        }
        public Builder createRequirement(ActionRequirement<Player> actionRequirement) {
            this.actionRequirement = actionRequirement;
            return this;
        }

        @Override
        public Action<Player> build() {
            return new TamagotchiAction(actionExecutor, actionRequirement);
        }
    }

}
