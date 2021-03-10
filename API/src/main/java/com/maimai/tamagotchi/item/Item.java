package com.maimai.tamagotchi.item;

public interface Item {

    ItemExecutor getItemExecutor();

    ItemType getType();

    DefaultType getDefaultType();

    interface Builder {

        Builder createExecutor(ItemExecutor itemExecutor);

        Builder setType(DefaultType type);

        Item build();

    }

}
