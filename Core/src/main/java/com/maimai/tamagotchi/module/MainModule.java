package com.maimai.tamagotchi.module;

import com.maimai.tamagotchi.scheduler.TamagotchiScheduler;

public class MainModule implements Module {

    private TamagotchiScheduler scheduler;

    @Override
    public void start() {
       this.scheduler = new TamagotchiScheduler();
    }

    public TamagotchiScheduler getScheduler() {
        return scheduler;
    }
}