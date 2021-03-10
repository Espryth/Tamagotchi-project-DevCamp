package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.Nameable;

@FunctionalInterface
public interface ActionHandler<T extends Nameable> {
    void execute(T t);
}
