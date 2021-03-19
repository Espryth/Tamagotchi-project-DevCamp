package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.module.NewGameModule;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.utils.MessageUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class PlayerLoader implements Loader {

    private final ProgramCore core;
    private final MongoDbManager mongoDbManager;

    public PlayerLoader(ProgramCore core, MongoDbManager mongoDbManager) {
        this.core = core;
        this.mongoDbManager = mongoDbManager;
    }

    @Override
    public void load() {

        Set<Player> players = mongoDbManager.getPlayerRepository().findAllSync();

        if (players.isEmpty()) {
            MessageUtils.sendMessage("A game was not found in the database!");
            new MainModule(core, mongoDbManager).start();
            return;
        }

        Scanner scanner = new Scanner(System.in);

        boolean bol = true;

        while (bol) {
            MessageUtils.sendMessage("➟ Enter your username");
            String username = scanner.next();

            MessageUtils.sendMessage("➟ Enter your password");
            String password = scanner.next();

            for (Player player : mongoDbManager.getPlayerRepository().findAllSync()) {

                if (player.getPassword().equals(password) && player.getName().equals(username)) {
                    player.getTamagotchi().registerDefaultActions(core);
                    core.setPlayer(player);
                    MessageUtils.sendMessageListFromLang(core, "commons.welcomeBack", player.getName());
                    return;
                }
            }
            MessageUtils.sendMessage("➟ Incorrect username or password, want to try again?");
            bol = scanner.nextBoolean();
        }

        new MainModule(core, mongoDbManager).start();
    }
}
