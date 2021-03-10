package com.maimai.tamagotchi.item;

import com.maimai.tamagotchi.Nameable;

public interface Item {

    ItemHandler getItemHandler();

    ItemType getType();

    interface Builder {

        Builder createItemHandler(ItemHandler itemHandler);

        Item build();

    }

}
