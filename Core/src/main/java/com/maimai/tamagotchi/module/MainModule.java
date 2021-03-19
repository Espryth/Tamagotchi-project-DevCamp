package com.maimai.tamagotchi.module;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.utils.MessageUtils;

import java.util.Scanner;

public class MainModule implements Module {

    private final ProgramCore core;

    public MainModule(ProgramCore core) {
        this.core = core;

    }

    @Override
    public void start() {
        
        Scanner scanner = new Scanner(System.in);

        MessageUtils.sendMessage(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
                "Welcome to MaiMai Tamagotchi!, choose a option",
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
                "",
                "1.- Start a new game",
                "2.- Load a previous game",
                "3.- Exit",
                ""
        );

        boolean choosing = true;

        while (choosing) {

            if(!scanner.hasNextInt()) {
                MessageUtils.sendMessage("That is not a option!");
                new MainModule(core).start();
                return;
            }

            int option = scanner.nextInt();


            switch (option) {
                case 1:
                    new NewGameModule(core).start();
                    break;
                case 2:
                    MessageUtils.sendMessage("Option in progress... :(");
                    new MainModule(core).start();
                    break;
                case 3:
                    core.setEnabled(false);
                    break;
                default:
                    MessageUtils.sendMessage("That is not a option!");
                    break;
            }
            choosing = false;
        }


    }
}
