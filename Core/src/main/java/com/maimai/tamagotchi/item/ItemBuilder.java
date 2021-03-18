package com.maimai.tamagotchi.item;

import com.maimai.tamagotchi.builder.IBuilder;
import com.maimai.tamagotchi.item.bath.BathItem;

public class ItemBuilder extends AbstractItem {


    public ItemBuilder(DefaultType defaultType, ItemType itemType,  ItemExecutor itemExecutor) {
        super(defaultType, itemType, itemExecutor);
    }

    public static class Builder implements IBuilder<Item> {

        private ItemExecutor itemExecutor;
        private DefaultType defaultType;
        private ItemType itemType;

        public ItemBuilder.Builder setItemType(ItemType itemType){
            this.itemType = itemType;
            return this;
        }

        public ItemBuilder.Builder createExecutor(ItemExecutor itemExecutor) {
            this.itemExecutor = itemExecutor;
            return this;
        }

        public ItemBuilder.Builder setType(DefaultType type) {
            this.defaultType = type;
            return this;
        }

        @Override
        public Item build() {
            return new ItemBuilder(defaultType, itemType, itemExecutor);
        }
    }
}
