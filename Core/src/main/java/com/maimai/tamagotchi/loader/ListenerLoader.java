package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.listener.TamagotchiStatsChangeListener;

public class ListenerLoader implements Loader{

    private final ProgramCore core;

    public ListenerLoader(ProgramCore core){
        this.core = core;
    }

    @Override
    public void load() {
        EventRegister eventRegister = core.getEventRegister();
        eventRegister.registerEvents(
                new TamagotchiStatsChangeListener()
        );

    }
}
