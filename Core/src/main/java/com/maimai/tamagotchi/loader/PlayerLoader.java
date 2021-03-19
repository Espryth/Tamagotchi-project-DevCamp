package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.utils.MessageUtils;

import java.util.Optional;

public class PlayerLoader implements Loader {

    private final ProgramCore core;
    private final MongoDbManager mongoDbManager;

    public PlayerLoader(ProgramCore core, MongoDbManager mongoDbManager) {
        this.core = core;
        this.mongoDbManager = mongoDbManager;
    }

    @Override
    public void load() {

        Optional<Player> optionalPlayer = mongoDbManager.getPlayerRepository().findAllSync().stream().findFirst();

        if(!optionalPlayer.isPresent()) {
            MessageUtils.sendMessage("A game was not found in the database!");
            new MainModule(core, mongoDbManager).start();
            return;
        }

        core.setPlayer(optionalPlayer.get());

        MessageUtils.sendMessage(

                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
                "Welcome back " + optionalPlayer.get().getName() + "!",
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

        );

    }

}
