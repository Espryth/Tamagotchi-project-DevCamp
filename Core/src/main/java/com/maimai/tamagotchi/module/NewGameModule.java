package com.maimai.tamagotchi.module;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.player.SimplePlayer;
import com.maimai.tamagotchi.player.language.Language;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.tamagotchi.impl.*;
import com.maimai.tamagotchi.utils.MessageUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public NewGameModule(ProgramCore core) {
        this.core = core;
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
                tamagotchi = new CatTamagotchi(core, tamagotchiName);
                break;
            case DOG:
                tamagotchi = new DogTamagotchi(core, tamagotchiName);
                break;
            case PARROT:
                tamagotchi = new ParrotTamagotchi(core, tamagotchiName);
                break;
            case HAMSTER:
                tamagotchi = new HamsterTamagotchi(core, tamagotchiName);
                break;
            case RABBIT:
                tamagotchi = new RabbitTamagotchi(core, tamagotchiName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tamagotchiType);
        }

        Player player = new SimplePlayer(playerName, tamagotchi, language);

        core.setPlayer(player);

        MessageUtils.sendMessageListFromLang(core, "commons.welcome", player.getName());

    }
}
