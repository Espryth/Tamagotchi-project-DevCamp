package com.maimai.tamagotchi.event.tamagotchi;

import com.maimai.tamagotchi.event.Event;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiEvent extends Event {

    private final Tamagotchi tamagotchi;

    public TamagotchiEvent(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public Tamagotchi getTamagotchi() {
        return tamagotchi;
    }
}
