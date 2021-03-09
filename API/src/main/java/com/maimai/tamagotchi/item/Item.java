package com.maimai.tamagotchi.item;

public interface Item {

    ItemHandler getItemHandler();

    ItemType getType();

    interface Builder {

        Builder createItemHandler(ItemHandler itemHandler);

        Item build();

    }

}
