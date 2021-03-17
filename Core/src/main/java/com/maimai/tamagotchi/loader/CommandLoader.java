package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.*;
import com.maimai.tamagotchi.command.part.PartHandler;
import com.maimai.tamagotchi.command.part.defaults.StringPart;

import java.util.Scanner;

public class CommandLoader implements Loader{

    private final ProgramCore core;

    public CommandLoader(ProgramCore core) {
        this.core = core;
    }

    @Override
    public void load() {

        Scanner input = new Scanner(System.in);

        PartHandler partHandler = new PartHandler();
        partHandler.installPart(new StringPart());

        CommandRegister commandRegister = new SimpleCommandRegister(partHandler, "/");
        commandRegister.registerCommand(
                new HelpCommand(),
                new OpenCommand(),
                new ShopCommand(),
                new ExitCommand(core)
        );

        while (core.isEnabled()) {
            commandRegister.executeCommand(input.nextLine());
        }

    }
}
