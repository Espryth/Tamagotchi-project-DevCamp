package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.Nameable;

public interface Action<T extends Nameable> {

    ActionExecutor<T> getActionExecutor();

    interface Builder<T extends Nameable> {

        Builder<T> createExecutor(ActionExecutor<T> actionExecutor);

        Action<T> build();

    }

}
