package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

public abstract class AbstractAction<T extends Entity> implements Action<T> {

    private final ActionExecutor<T> actionExecutor;

    private final ActionRequirement<T> actionRequirement;

    public AbstractAction(ActionExecutor<T> actionExecutor,
                          ActionRequirement<T> actionRequirement) {
        this.actionExecutor = actionExecutor;
        this.actionRequirement = actionRequirement;
    }

    @Override
    public ActionExecutor<T> getActionExecutor() {
        return actionExecutor;
    }

    @Override
    public ActionRequirement<T> getActionRequirement() {
        return actionRequirement;
    }
}
