package com.maimai.tamagotchi.tamagotchi.action;

import com.maimai.tamagotchi.action.AbstractAction;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.ActionHandler;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiAction extends AbstractAction<Tamagotchi> {

    public TamagotchiAction(ActionHandler<Tamagotchi> actionHandler) {
        super(actionHandler);
    }

    public static class Builder extends AbstractAction.Builder<Tamagotchi> {

        @Override
        public Action<Tamagotchi> build() {
            return new TamagotchiAction(getActionHandler());
        }
    }

}
