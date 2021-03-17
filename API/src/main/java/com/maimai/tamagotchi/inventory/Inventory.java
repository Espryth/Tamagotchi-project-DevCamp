package com.maimai.tamagotchi.inventory;

import com.maimai.tamagotchi.item.Item;

public interface Inventory {

    Item getItem(int index);

    void setItem(int index, Item item);

    void addItems(Item... items);

    void removeItem(int index);

    void removeItems(int... index);
}
