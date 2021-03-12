package com.maimai.tamagotchi.item.toy;

import com.maimai.tamagotchi.builder.IBuilder;
import com.maimai.tamagotchi.item.*;

public class ToyItem extends AbstractItem {

    public ToyItem(DefaultType defaultType, ItemExecutor itemExecutor) {
        super(defaultType, ItemType.TOY, itemExecutor);
    }

    public static class Builder implements IBuilder<Item> {

        private ItemExecutor itemExecutor;
        private DefaultType defaultType;

        public ToyItem.Builder createExecutor(ItemExecutor itemExecutor) {
            this.itemExecutor = itemExecutor;
            return this;
        }

        public ToyItem.Builder setType(DefaultType type) {
            this.defaultType = type;
            return this;
        }

        @Override
        public Item build() {
            return new ToyItem(defaultType, itemExecutor);
        }
    }
}


