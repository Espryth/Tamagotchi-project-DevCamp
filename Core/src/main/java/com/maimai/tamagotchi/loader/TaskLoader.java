package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TaskLoader implements Loader {

    private final ProgramCore core;
    private final Tamagotchi tamagotchi;

    public TaskLoader(ProgramCore core) {
        this.core = core;
        this.tamagotchi = core.getPlayer().getTamagotchi();
    }
    @Override
    public void load() {
        core.getScheduler().runTask(() -> tamagotchi.getHunger().decrement(10D),30L, 30L, TimeUnit.MINUTES);
        core.getScheduler().runTask(() -> {
            if(tamagotchi.isHunger()) {
                Arrays.asList(
                        "Your tamagotchi requires your attention!",
                        "Feed him"
                ).forEach(System.out::println);
            }
            if(tamagotchi.getHunger().getValue() <= 0D) {
                tamagotchi.getHealth().decrement(1D);
            }
        }, 5L, 20L, TimeUnit.SECONDS);
    }
}
