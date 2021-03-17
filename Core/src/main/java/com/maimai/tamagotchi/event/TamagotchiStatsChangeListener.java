package com.maimai.tamagotchi.event;

import com.maimai.tamagotchi.event.listener.Listener;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;

public class TamagotchiStatsChangeListener implements Listener {
    @EventHandler
    public void onTamagotchiStatsChange(TamagotchiStatsChangeEvent event){
        if (event.statsIsZero()){
            event.getTamagotchi().getHealth().decrement(20D);
        }else{
            event.getTamagotchi().getHealth().decrement(30D);
        }
    }
}


