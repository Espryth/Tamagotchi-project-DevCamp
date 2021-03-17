package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.module.Module;
import com.maimai.tamagotchi.player.Player;

import java.util.Optional;

public class PlayerLoader implements Loader {

    private final ProgramCore core;
    private final MongoDbManager mongoDbManager;

    public PlayerLoader(ProgramCore core) {
        this.core = core;
        this.mongoDbManager = core.getMongoManager();
    }

    @Override
    public void load() {

        Optional<Player> optionalPlayer = mongoDbManager.getPlayerRepository().findAllSync().stream().findFirst();

        if(!optionalPlayer.isPresent()) {
            System.out.println("A game was not found in the database!");
            Module module = new MainModule(core);
            module.start();
            return;
        }

        core.setPlayer(optionalPlayer.get());

        System.out.println("Welcome again " + optionalPlayer.get().getName() + "!");

    }

}
