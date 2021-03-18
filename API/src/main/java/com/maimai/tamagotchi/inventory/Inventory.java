package com.maimai.tamagotchi.inventory;

import com.maimai.tamagotchi.item.Item;

import java.util.List;

public interface Inventory {

    Item getItem(int index);

    int getSize();

    void setItem(int index, Item item);

    void addItem(Item item);

    void addItems(Item... items);

    void removeItem(int index);

    void removeItems(int... index);

    List<Item> getItems();
}
