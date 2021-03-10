package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

public abstract class AbstractAction<T extends Entity> implements Action<T> {

    private final ActionExecutor<T> actionExecutor;

    public AbstractAction(ActionExecutor<T> actionExecutor) {
        this.actionExecutor = actionExecutor;
    }

    @Override
    public ActionExecutor<T> getActionExecutor() {
        return actionExecutor;
    }

    public abstract static class Builder<T extends Entity> implements Action.Builder<T> {

        private ActionExecutor<T> actionExecutor;

        @Override
        public abstract Action<T> build();

        @Override
        public Action.Builder<T> createExecutor(ActionExecutor<T> actionExecutor) {
            this.actionExecutor = actionExecutor;
            return this;
        }

        protected ActionExecutor<T> getActionExecutor() {
            return actionExecutor;
        }

    }
}
