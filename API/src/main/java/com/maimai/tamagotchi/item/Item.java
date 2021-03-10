package com.maimai.tamagotchi.item;

public interface Item {

    ItemExecutor getItemExecutor();

    ItemType getType();

    DefaultType getDefaultType();

}
