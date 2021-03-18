package com.maimai.tamagotchi.action;

public interface Action {

    ActionExecutor getActionExecutor();

    ActionRequirement getActionRequirement();

}
