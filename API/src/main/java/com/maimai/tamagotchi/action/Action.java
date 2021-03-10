package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

public interface Action<T extends Entity> {

    ActionExecutor<T> getActionExecutor();

    interface Builder<T extends Entity> {

        Builder<T> createExecutor(ActionExecutor<T> actionExecutor);

        Action<T> build();

    }

}
