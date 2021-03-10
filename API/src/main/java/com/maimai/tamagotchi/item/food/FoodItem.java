package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.*;

public class FoodItem extends AbstractItem {

    public FoodItem(DefaultType defaultType, ItemHandler itemHandler) {
        super(defaultType, ItemType.FOOD, itemHandler);
    }

    public static class Builder extends AbstractItem.Builder {

        @Override
        public Item build() {
            return new FoodItem(getType(), getItemHandler());
        }
    }
}
