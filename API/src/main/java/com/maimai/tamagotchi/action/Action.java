package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

public interface Action<T extends Entity> {

    ActionHandler<T> getActionHandler();

    interface Builder<T extends Entity> {

        Builder<T> createActionHandler(ActionHandler<T> actionHandler);

        Action<T> build();

    }

}
