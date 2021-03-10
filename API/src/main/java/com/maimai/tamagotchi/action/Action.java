package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.Nameable;

public interface Action<T extends Nameable> {

    ActionHandler<T> getActionHandler();

    interface Builder<T extends Nameable> {

        Builder<T> createActionHandler(ActionHandler<T> actionHandler);

        Action<T> build();

    }

}
