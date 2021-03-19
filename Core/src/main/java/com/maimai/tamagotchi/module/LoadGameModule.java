package com.maimai.tamagotchi.module;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.loader.PlayerLoader;

public class LoadGameModule implements Module {

    private final ProgramCore core;

    private final MongoDbManager mongoDbManager;

    public LoadGameModule(ProgramCore core, MongoDbManager mongoDbManager) {
        this.core = core;
        this.mongoDbManager = mongoDbManager;

    }

    @Override
    public void start() {

        Loader playerLoader = new PlayerLoader(core, mongoDbManager);
        playerLoader.load();

    }
}
