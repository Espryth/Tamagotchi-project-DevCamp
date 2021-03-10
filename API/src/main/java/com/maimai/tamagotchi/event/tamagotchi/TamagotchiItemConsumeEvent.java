package com.maimai.tamagotchi.event.tamagotchi;

import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiItemConsumeEvent extends TamagotchiEvent{

    private final Item item;

    public TamagotchiItemConsumeEvent(Tamagotchi tamagotchi, Item item) {
        super(tamagotchi);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
