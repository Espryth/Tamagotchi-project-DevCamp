package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.listener.GameEndListener;
import com.maimai.tamagotchi.listener.TamagotchiStatsChangeListener;
import com.maimai.tamagotchi.player.Player;

public class ListenerLoader implements Loader{

    private final MongoDbManager mongoDbManager;
    private final ProgramCore core;

    public ListenerLoader(ProgramCore core, MongoDbManager mongoDbManager){
        this.core = core;
        this.mongoDbManager = mongoDbManager;
    }

    @Override
    public void load() {
        EventRegister eventRegister = core.getEventRegister();
        eventRegister.registerEvents(
                new TamagotchiStatsChangeListener(),
                new GameEndListener(core, mongoDbManager)
        );

    }
}
