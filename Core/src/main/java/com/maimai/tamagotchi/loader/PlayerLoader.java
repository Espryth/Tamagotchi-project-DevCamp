package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.player.action.PlayerAction;

public class PlayerLoader implements Loader {

    private final Manager<Player> playerManager;
    private final MongoDbManager mongoDbManager;

    public PlayerLoader(Manager<Player> playerManager,
                        MongoDbManager mongoDbManager) {

        this.playerManager = playerManager;
        this.mongoDbManager = mongoDbManager;
    }

    @Override
    public void load() {
        mongoDbManager.getPlayerRepository().findAllSync().forEach(player -> {

            registerDefaultActions(player);
            playerManager.insert(player.getId(), player);

        });
    }

    private void registerDefaultActions(Player player) {

        registerAction("test", player, new PlayerAction.Builder()
                .createExecutor(p -> {

                })
                .build()
        );

    }

    private void registerAction(String name, Player player,  Action<Player> action) {
        player.getActionManager().insert(name, action);
    }

}
