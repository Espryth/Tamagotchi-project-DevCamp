package com.maimai.tamagotchi.module;

import com.maimai.tamagotchi.command.OpenCommand;
import com.maimai.tamagotchi.command.SimpleCommandRegister;
import com.maimai.tamagotchi.command.part.PartHandler;
import com.maimai.tamagotchi.loader.CommandLoader;

import java.util.Scanner;

public class MainModule implements Module {

    private Scanner scanner;

    private CommandLoader commandLoader;
    private SimpleCommandRegister simpleCommandRegister;

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        commandLoader = new CommandLoader();
        simpleCommandRegister = commandLoader.getCommandRegister();
        loopCommand();
    }

    private void loopCommand(){
        String text = scanner.nextLine();

        simpleCommandRegister.executeCommand(text);
        if (text.equalsIgnoreCase("-end")){
            return;
        }

        loopCommand();
    }
}