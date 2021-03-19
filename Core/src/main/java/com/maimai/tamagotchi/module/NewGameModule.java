package com.maimai.tamagotchi.module;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.player.SimplePlayer;
import com.maimai.tamagotchi.player.language.Language;
import com.maimai.tamagotchi.tamagotchi.*;
import com.maimai.tamagotchi.tamagotchi.impl.*;
import com.maimai.tamagotchi.utils.MessageUtils;

import java.util.*;

public class NewGameModule implements Module {

    private static final Map<String, TamagotchiType> TAMAGOTCHI_TYPE_ALIASES = new HashMap<>();
    private static final Map<String, Language> LANGUAGE_ALIASES = new HashMap<>();

    static {
        for (TamagotchiType tamagotchiType : TamagotchiType.values()) {

            TAMAGOTCHI_TYPE_ALIASES.put(tamagotchiType.toString().toLowerCase(), tamagotchiType);
            TAMAGOTCHI_TYPE_ALIASES.put(tamagotchiType.getName().toLowerCase(), tamagotchiType);

        }

        for(Language language : Language.values()) {

            LANGUAGE_ALIASES.put(language.toString().toLowerCase(), language);

            switch (language) {
                case ES:
                    LANGUAGE_ALIASES.put("español", language);
                    LANGUAGE_ALIASES.put("spanish", language);
                    break;
                case EN:
                    LANGUAGE_ALIASES.put("ingles", language);
                    LANGUAGE_ALIASES.put("english", language);
                    break;
            }

        }

    }

    private final ProgramCore core;
    private MongoDbManager mongoDbManager;

    public NewGameModule(ProgramCore core, MongoDbManager mongoDbManager) {
        this.core = core;
        this.mongoDbManager = mongoDbManager;
    }

    @Override
    public void start() {

        Scanner scanner = new Scanner(System.in);


        MessageUtils.sendMessage(
                "➟ To start choose your language",
                "",
                "↳ Español",
                "↳ English",
                ""
        );

        Language language = LANGUAGE_ALIASES.get(scanner.next().toLowerCase());

        while (language == null) {
            MessageUtils.sendMessage("That language doesn't exist!, please try again.");
            language = LANGUAGE_ALIASES.get(scanner.next());
        }

        MessageUtils.sendMessage("➟ What is your name?");
        String playerName = scanner.next();

        Set<Player> players = mongoDbManager.getPlayerRepository().findAllSync();

        if(!players.isEmpty()) {
            for(Player player : players) {
                while (player.getName().equals(playerName)) {
                    MessageUtils.sendMessage("That username is already taken! please try again.");
                    playerName = scanner.next();
                }
            }
        }

        MessageUtils.sendMessage("➟ Enter a password");
        String password = scanner.next();

        MessageUtils.sendMessage("➟ What do you want your tamagotchi to be called?");
        String tamagotchiName = scanner.next();

        MessageUtils.sendMessage(
                "➟ Choose your tamagotchi",
                "",
                "↳ Cat",
                "↳ Dog",
                "↳ Parrot",
                "↳ Hamster",
                "↳ Rabbit",
                ""
        );

        TamagotchiType tamagotchiType = TAMAGOTCHI_TYPE_ALIASES.get(scanner.next().toLowerCase());

        while (tamagotchiType == null) {
            MessageUtils.sendMessage("That type of tamagotchi doesn't exist! please try again.");
            tamagotchiType = TAMAGOTCHI_TYPE_ALIASES.get(scanner.next().toLowerCase());
        }

        Tamagotchi tamagotchi;

        switch (tamagotchiType) {
            case CAT:
                tamagotchi = new CatTamagotchi(tamagotchiName);
                break;
            case DOG:
                tamagotchi = new DogTamagotchi(tamagotchiName);
                break;
            case PARROT:
                tamagotchi = new ParrotTamagotchi(tamagotchiName);
                break;
            case HAMSTER:
                tamagotchi = new HamsterTamagotchi(tamagotchiName);
                break;
            case RABBIT:
                tamagotchi = new RabbitTamagotchi(tamagotchiName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tamagotchiType);
        }

        tamagotchi.registerDefaultActions(core);

        Player player = new SimplePlayer(playerName, password, tamagotchi, language);

        core.setPlayer(player);

        MessageUtils.sendMessageListFromLang(core, "commons.welcome", playerName);

    }
}
