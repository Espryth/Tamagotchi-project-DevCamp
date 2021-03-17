package com.maimai.tamagotchi.event;

import com.maimai.tamagotchi.event.listener.Listener;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiHungryEvent;

public class HungryEventListener implements Listener {
    @EventHandler
    public void onHungryEvent(TamagotchiHungryEvent event){
        if (event.isHungry()){
            System.out.println("is hungry");
        }
    }
}


