package com.maimai.tamagotchi.item;

public abstract class AbstractItem implements Item {



    private final ItemExecutor itemExecutor;

    private final ItemType type;

    private final DefaultType defaultType;

    public AbstractItem(DefaultType defaultType,
                        ItemType type,
                        ItemExecutor itemExecutor) {

        this.defaultType = defaultType;
        this.type = type;
        this.itemExecutor = itemExecutor;
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
    public ItemExecutor getItemExecutor(){
        return itemExecutor;
    }

    public abstract static class Builder implements Item.Builder {

        private ItemExecutor itemExecutor;

        private DefaultType defaultType;

        @Override
        public abstract Item build();

        @Override
        public Builder createExecutor(ItemExecutor itemExecutor) {
            this.itemExecutor = itemExecutor;
            return this;
        }

        public Builder setType(DefaultType type) {
            this.defaultType = type;
            return this;
        }

        protected ItemExecutor getItemExecutor() {
            return itemExecutor;
        }

        protected DefaultType getType() {
            return defaultType;
        }
    }
}
