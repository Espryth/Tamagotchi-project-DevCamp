package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.action.tamagotchi.TamagotchiAction;
import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public abstract class AbstractAction<T extends Entity> implements Action<T> {

    private final String name;

    private final ActionHandler<T> actionHandler;

    public AbstractAction(String name, ActionHandler<T> actionHandler) {
        this.name = name;
        this.actionHandler = actionHandler;
    }

    @Override
    public String getActionName() {
        return name;
    }

    @Override
    public ActionHandler<T> getActionHandler() {
        return actionHandler;
    }

    public static class Builder implements Action.Builder<Tamagotchi> {

        private String name;

        private ActionHandler<Tamagotchi> actionHandler;

        @Override
        public Action.Builder<Tamagotchi> setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Action.Builder<Tamagotchi> createActionHandler(ActionHandler<Tamagotchi> actionHandler) {
            this.actionHandler = actionHandler;
            return this;
        }

        @Override
        public Action<Tamagotchi> build() {
            return new TamagotchiAction(name, actionHandler);
        }
    }
}
