package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.Nameable;

@FunctionalInterface
public interface ActionExecutor<T extends Nameable> {
    void execute(T t);
}
