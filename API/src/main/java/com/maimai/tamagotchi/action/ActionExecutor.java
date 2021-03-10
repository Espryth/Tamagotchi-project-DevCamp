package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

@FunctionalInterface
public interface ActionExecutor<T extends Entity> {
    void execute(T t);
}
