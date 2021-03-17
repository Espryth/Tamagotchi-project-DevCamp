package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.command.HelpCommand;
import com.maimai.tamagotchi.command.SimpleCommandRegister;
import com.maimai.tamagotchi.command.part.PartHandler;
import com.maimai.tamagotchi.command.part.defaults.StringPart;
import com.maimai.tamagotchi.event.EventRegister;

import java.util.Scanner;

public class Main {

    private static EventRegister eventRegister;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PartHandler partHandler = new PartHandler();
        partHandler.installPart(new StringPart());

        CommandRegister commandRegister = new SimpleCommandRegister(partHandler, "/");

        commandRegister.registerCommand(new HelpCommand());

        boolean bol = true;

        while (true) {
            commandRegister.executeCommand(scanner.nextLine());
        }

    }

    public static EventRegister getEventRegister() {
        return eventRegister;
    }
}
