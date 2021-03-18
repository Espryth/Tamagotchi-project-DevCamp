package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.builder.IBuilder;

public class SimpleAction implements Action{

    private final ActionExecutor actionExecutor;

    private final ActionRequirement actionRequirement;

    public SimpleAction(ActionExecutor actionExecutor,
                        ActionRequirement actionRequirement) {
        this.actionExecutor = actionExecutor;
        this.actionRequirement = actionRequirement;
    }

    @Override
    public ActionExecutor getActionExecutor() {
        return actionExecutor;
    }

    @Override
    public ActionRequirement getActionRequirement() {
        return actionRequirement;
    }

    public static class Builder implements IBuilder<Action> {

        private ActionExecutor actionExecutor;

        private ActionRequirement actionRequirement;

        public Builder createExecutor(ActionExecutor actionExecutor) {
            this.actionExecutor = actionExecutor;
            return this;
        }
        public Builder createRequirement(ActionRequirement actionRequirement) {
            this.actionRequirement = actionRequirement;
            return this;
        }

        @Override
        public Action build() {
            return new SimpleAction(actionExecutor, actionRequirement);
        }
    }
}
