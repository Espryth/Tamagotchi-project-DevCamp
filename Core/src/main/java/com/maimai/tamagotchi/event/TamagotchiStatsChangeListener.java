package com.maimai.tamagotchi.event;

import com.maimai.tamagotchi.event.listener.Listener;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiStatsChangeListener implements Listener {
    @EventHandler
    public void onTamagotchiStatsChange(TamagotchiStatsChangeEvent event) {

        Tamagotchi tamagotchi = event.getTamagotchi();
        if (tamagotchi.getHappiness().getValue() == 0 && tamagotchi.getHunger().getValue() == 0 &&
                tamagotchi.getThirst().getValue() == 0){
            event.getTamagotchi().getHealth().decrement(40D);
        }else if (tamagotchi.getHappiness().getValue() == 0 && tamagotchi.getHunger().getValue() == 0 ||
                tamagotchi.getHappiness().getValue() == 0 && tamagotchi.getThirst().getValue() == 0  ){
            event.getTamagotchi().getHealth().decrement(30D);
        }else  if (tamagotchi.getThirst().getValue() == 0 || tamagotchi.getHunger().getValue() == 0) {
            tamagotchi.getHealth().decrement(20D);
        }
    }
}
