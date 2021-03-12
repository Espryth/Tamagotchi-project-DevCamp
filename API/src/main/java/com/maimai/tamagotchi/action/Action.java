package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

public interface Action<T extends Entity> {

    ActionExecutor<T> getActionExecutor();

    ActionRequirement<T> getActionRequirement();

}
