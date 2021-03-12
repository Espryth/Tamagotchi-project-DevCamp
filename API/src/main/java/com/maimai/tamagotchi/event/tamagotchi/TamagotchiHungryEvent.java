package com.maimai.tamagotchi.event.tamagotchi;

import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiHungryEvent extends TamagotchiEvent{

    private boolean hungry;

    public TamagotchiHungryEvent(Tamagotchi tamagotchi){
        super(tamagotchi);
        if (tamagotchi.getHunger().getValue() == 0){
            this.hungry = true;
        }
    }

    public boolean isHungry(){
        return hungry;
    }
}
