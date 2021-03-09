package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

public interface Action<T extends Entity> {

    String getActionName();

    ActionHandler<T> getActionHandler();

    interface Builder<T extends Entity> {

        Builder<T> setName(String name);

        Builder<T> createActionHandler(ActionHandler<T> actionHandler);

        Action<T> build();

    }

}
