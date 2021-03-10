package com.maimai.tamagotchi.item;

public interface Item {

    ItemHandler getItemHandler();

    ItemType getType();

    DefaultType getDefaultType();

    interface Builder {

        Builder createItemHandler(ItemHandler itemHandler);

        Builder setType(DefaultType type);

        Item build();

    }

}
