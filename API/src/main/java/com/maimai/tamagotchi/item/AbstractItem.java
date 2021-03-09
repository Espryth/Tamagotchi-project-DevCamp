package com.maimai.tamagotchi.item;

public abstract class AbstractItem implements Item {

    private final ItemHandler itemHandler;

    private final ItemType type;

    public AbstractItem(ItemType type, ItemHandler itemHandler) {
        this.type = type;
        this.itemHandler = itemHandler;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public ItemHandler getItemHandler(){
        return itemHandler;
    }

    public abstract static class Builder implements Item.Builder {

        private ItemHandler itemHandler;

        @Override
        public abstract Item build();

        @Override
        public Builder createItemHandler(ItemHandler itemHandler) {
            this.itemHandler = itemHandler;
            return this;
        }

        protected ItemHandler getItemHandler() {
            return itemHandler;
        }

    }
}
