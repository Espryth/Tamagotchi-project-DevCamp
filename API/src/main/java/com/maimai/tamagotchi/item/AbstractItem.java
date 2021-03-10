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

}
