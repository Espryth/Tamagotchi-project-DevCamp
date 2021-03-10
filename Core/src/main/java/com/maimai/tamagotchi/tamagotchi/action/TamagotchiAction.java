package com.maimai.tamagotchi.tamagotchi.action;

import com.maimai.tamagotchi.action.AbstractAction;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.ActionExecutor;
import com.maimai.tamagotchi.builder.IBuilder;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiAction extends AbstractAction<Tamagotchi> {

    public TamagotchiAction(ActionExecutor<Tamagotchi> actionExecutor) {
        super(actionExecutor);
    }

    public static class Builder implements IBuilder<Action<Tamagotchi>> {

        private ActionExecutor<Tamagotchi> actionExecutor;

        public Builder createExecutor(ActionExecutor<Tamagotchi> actionExecutor) {
            this.actionExecutor = actionExecutor;
            return this;
        }

        @Override
        public Action<Tamagotchi> build() {
            return new TamagotchiAction(actionExecutor);
        }
    }

}
