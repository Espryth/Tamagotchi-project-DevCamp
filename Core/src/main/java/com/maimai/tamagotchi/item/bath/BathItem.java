package com.maimai.tamagotchi.item.bath;

import com.maimai.tamagotchi.builder.IBuilder;
import com.maimai.tamagotchi.item.*;

public class BathItem extends AbstractItem {

    public BathItem(DefaultType defaultType, ItemExecutor itemExecutor) {
        super(defaultType, ItemType.BATH, itemExecutor);
    }

    public static class Builder implements IBuilder<Item> {

        private ItemExecutor itemExecutor;
        private DefaultType defaultType;

        public BathItem.Builder createExecutor(ItemExecutor itemExecutor) {
            this.itemExecutor = itemExecutor;
            return this;
        }

        public BathItem.Builder setType(DefaultType type) {
            this.defaultType = type;
            return this;
        }

        @Override
        public Item build() {
            return new BathItem(defaultType, itemExecutor);
        }
    }
}


