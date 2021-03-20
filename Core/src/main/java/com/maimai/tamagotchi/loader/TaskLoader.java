package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.event.game.GameEndCause;
import com.maimai.tamagotchi.event.game.GameEndEvent;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;
import com.maimai.tamagotchi.utils.MessageUtils;

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
                MessageUtils.sendMessageFromLang(core, "tamagotchi.isHungry");
            }
            if(tamagotchi.getHunger().getValue() <= 0D) {
                tamagotchi.getHealth().decrement(1D);
            }
        }, 5L, 20L, TimeUnit.SECONDS);
        core.getScheduler().runTask(() -> {
            if(tamagotchi.getHealth().getValue() <= 0D) {
                tamagotchi.setAlive(false);
                MessageUtils.sendMessageFromLang(core, "tamagotchi.death");
                core.getEventRegister().callEvent(new GameEndEvent(GameEndCause.TAMAGOTCHI_DEAD));
            }
        }, 0L, 1L, TimeUnit.SECONDS);
    }
}
