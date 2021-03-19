package com.maimai.tamagotchi;

import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.database.Test;
import com.maimai.tamagotchi.file.JsonFile;
import com.maimai.tamagotchi.player.Player;

import java.util.Optional;

public class TamagotchiMain {

    public static void main(String[] args) {

        JsonFile file = new JsonFile("config");

        MongoDbManager mongoDbManager = new MongoDbManager(file);

        Optional<Player> player = mongoDbManager.getPlayerRepository().findOneSync("04a593b3-0bf4-44ab-8d6b-6bcfad903e3b");

        player.ifPresent(value -> System.out.println(value.getName()));

        //ProgramCore core = new TamagotchiCore();
        //core.initCore();
    }
}
