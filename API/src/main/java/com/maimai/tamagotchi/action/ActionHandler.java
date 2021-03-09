package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

@FunctionalInterface
public interface ActionHandler<T extends Entity> {
    void execute(T t);
}
