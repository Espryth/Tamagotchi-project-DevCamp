package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.AbstractItem;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.ItemHandler;
import com.maimai.tamagotchi.item.ItemType;

public class FoodItem extends AbstractItem {

    private final FoodType foodType;

    public FoodItem(FoodType foodType, ItemHandler itemHandler) {
        super(ItemType.FOOD, itemHandler);
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public static class Builder extends AbstractItem.Builder {

        private FoodType foodType;

        public Builder setFoodType(FoodType foodType) {
            this.foodType = foodType;
            return this;
        }

        @Override
        public Item build() {
            return new FoodItem(foodType, getItemHandler());
        }
    }
}
