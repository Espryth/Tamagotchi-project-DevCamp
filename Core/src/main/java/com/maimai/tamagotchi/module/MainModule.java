package com.maimai.tamagotchi.module;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.loader.PlayerLoader;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.player.SimplePlayer;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.tamagotchi.impl.CatTamagotchi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainModule implements Module{

    private final ProgramCore core;

    private static final Map<String, TamagotchiType> TAMAGOTCHI_TYPE_ALIASES = new HashMap<>();

    static {
        for (TamagotchiType tamagotchiType : TamagotchiType.values()) {

            TAMAGOTCHI_TYPE_ALIASES.put(tamagotchiType.toString().toLowerCase(), tamagotchiType);
            TAMAGOTCHI_TYPE_ALIASES.put(tamagotchiType.getName().toLowerCase(), tamagotchiType);

        }
    }


    public MainModule(ProgramCore core) {
        this.core = core;
    }

    @Override
    public void start() {
        
        Scanner scanner = new Scanner(System.in);
        
        Arrays.asList(
                "Welcome to MaiMai Tamagotchi, if",
                "you wanna start a new game, enter true",
                "else if you wanna load a previous game",
                "enter false"
        ).forEach(System.out::println);

        if(scanner.nextBoolean()) {

            System.out.println("Enter your name");
            String playerName = scanner.next();
            
            System.out.println("Enter the name of your tamagotchi");
            String tamagotchiName = scanner.next();
            
            System.out.println("What kind of tamagotchi do you want?");
            TamagotchiType tamagotchiType = TAMAGOTCHI_TYPE_ALIASES.get(scanner.next());
            
            while (tamagotchiType == null) {
                Arrays.asList(
                        "That kind of tamagotchi doesn't exist!",
                        "please try again."
                ).forEach(System.out::println);

                tamagotchiType = TAMAGOTCHI_TYPE_ALIASES.get(scanner.next());
            }
            
            Tamagotchi tamagotchi;

            switch (tamagotchiType) {
                case CAT:
                    tamagotchi = new CatTamagotchi("a", tamagotchiName);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + tamagotchiType);
            }

            Player player = new SimplePlayer(playerName, tamagotchi);
            core.setPlayer(player);

            Arrays.asList(

                    "Welcome " + player.getName() + "!",
                    "to start use / help"

            ).forEach(System.out::println);

            
        } else {
            Loader playerLoader = new PlayerLoader(core);
            playerLoader.load();
        }

    }
}
