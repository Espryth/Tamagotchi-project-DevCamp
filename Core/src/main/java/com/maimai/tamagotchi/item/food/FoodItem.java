package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.builder.IBuilder;
import com.maimai.tamagotchi.item.*;

public class FoodItem extends AbstractItem {

    public FoodItem(DefaultType defaultType, ItemExecutor itemExecutor) {
        super(defaultType, ItemType.FOOD, itemExecutor);
    }

    public static class Builder implements IBuilder<Item> {

        private ItemExecutor itemExecutor;
        private DefaultType defaultType;

        public Builder createExecutor(ItemExecutor itemExecutor) {
            this.itemExecutor = itemExecutor;
            return this;
        }

        public Builder setType(DefaultType type) {
            this.defaultType = type;
            return this;
        }
        
        @Override
        public Item build() {
            return new FoodItem(defaultType, itemExecutor);
        }
    }
}
