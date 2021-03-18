package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.entity.Entity;
import com.maimai.tamagotchi.item.Item;

@FunctionalInterface
public interface ActionExecutor<T extends Entity> {
    void execute(T t, Item item);
}
