package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.*;

public class FoodItem extends AbstractItem {

    public FoodItem(DefaultType defaultType, ItemExecutor itemExecutor) {
        super(defaultType, ItemType.FOOD, itemExecutor);
    }

    public static class Builder extends AbstractItem.Builder {

        @Override
        public Item build() {
            return new FoodItem(getType(), getItemExecutor());
        }
    }
}
