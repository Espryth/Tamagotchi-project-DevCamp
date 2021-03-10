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

}
