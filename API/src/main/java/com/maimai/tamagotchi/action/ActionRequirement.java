package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.item.Item;

@FunctionalInterface
public interface ActionRequirement<T extends Entity> {
    boolean requeriment(T t, Item item);
}
