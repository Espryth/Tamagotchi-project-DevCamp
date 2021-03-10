package com.maimai.tamagotchi.item;

public abstract class AbstractItem implements Item {



    private final ItemHandler itemHandler;

    private final ItemType type;

    private final DefaultType defaultType;

    public AbstractItem(DefaultType defaultType,
                        ItemType type,
                        ItemHandler itemHandler) {

        this.defaultType = defaultType;
        this.type = type;
        this.itemHandler = itemHandler;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public DefaultType getDefaultType() {
        return defaultType;
    }

    @Override
    public ItemHandler getItemHandler(){
        return itemHandler;
    }

    public abstract static class Builder implements Item.Builder {

        private ItemHandler itemHandler;

        private DefaultType defaultType;

        @Override
        public abstract Item build();

        @Override
        public Builder createItemHandler(ItemHandler itemHandler) {
            this.itemHandler = itemHandler;
            return this;
        }

        public Builder setType(DefaultType type) {
            this.defaultType = type;
            return this;
        }

        protected ItemHandler getItemHandler() {
            return itemHandler;
        }

        protected DefaultType getType() {
            return defaultType;
        }
    }
}
