package com.maimai.tamagotchi.event.tamagotchi;

import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiHungryEvent extends TamagotchiEvent {

    public TamagotchiHungryEvent(Tamagotchi tamagotchi) {
        super(tamagotchi);
    }
    public boolean isHungry(){
        return getTamagotchi().getHunger().getValue() == 0;
    }
}