package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.player.Player;

public class PlayerLoader implements Loader {

    private final Manager<String, Player> playerManager;
    private final MongoDbManager mongoDbManager;

    public PlayerLoader(Manager<String, Player> playerManager,
                        MongoDbManager mongoDbManager) {

        this.playerManager = playerManager;
        this.mongoDbManager = mongoDbManager;
    }

    @Override
    public void load() {
        mongoDbManager.getPlayerRepository().findAllSync().forEach(player -> {

            playerManager.insert(player.getId(), player);

        });
    }

}
