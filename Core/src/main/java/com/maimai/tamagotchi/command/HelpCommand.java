package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;

import java.util.Arrays;

public class HelpCommand implements CommandClass {

    @Command(name = "help", usage = "/help")
    public void executeHelpCommand() {
        Arrays.asList(
                "a",
                "b"
        ).forEach(System.out::println);
    }
}
