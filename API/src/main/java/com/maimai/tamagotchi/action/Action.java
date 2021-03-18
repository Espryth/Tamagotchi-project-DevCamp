package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

public interface Action {

    ActionExecutor getActionExecutor();

    ActionRequirement getActionRequirement();

}
