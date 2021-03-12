package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;

@FunctionalInterface
public interface ActionRequirement<T extends Entity> {
    boolean requeriment(T t);
}
