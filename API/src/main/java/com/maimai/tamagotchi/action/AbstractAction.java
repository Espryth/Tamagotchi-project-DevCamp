package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

public abstract class AbstractAction<T extends Entity> implements Action<T> {

    private final ActionHandler<T> actionHandler;

    public AbstractAction(ActionHandler<T> actionHandler) {
        this.actionHandler = actionHandler;
    }

    @Override
    public ActionHandler<T> getActionHandler() {
        return actionHandler;
    }

    public abstract static class Builder<T extends Entity> implements Action.Builder<T> {

        private ActionHandler<T> actionHandler;

        @Override
        public abstract Action<T> build();

        @Override
        public Action.Builder<T> createActionHandler(ActionHandler<T> actionHandler) {
            this.actionHandler = actionHandler;
            return this;
        }

        protected ActionHandler<T> getActionHandler() {
            return actionHandler;
        }

    }
}
