package com.maimai.tamagotchi.event.tamagotchi;

import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiStatsChangeEvent extends TamagotchiEvent {

    public TamagotchiStatsChangeEvent(Tamagotchi tamagotchi) {
        super(tamagotchi);

    }
}