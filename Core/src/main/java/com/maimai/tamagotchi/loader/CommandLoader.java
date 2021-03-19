package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.*;
import com.maimai.tamagotchi.command.part.PartHandler;
import com.maimai.tamagotchi.command.part.defaults.ActionPart;
import com.maimai.tamagotchi.command.part.defaults.ItemPart;
import com.maimai.tamagotchi.command.part.defaults.StringPart;
import com.maimai.tamagotchi.shop.Shop;
import com.maimai.tamagotchi.shop.TamagotchiShop;

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
        partHandler.installPart(new ActionPart(core.getPlayer().getTamagotchi().getActionManager()));
        partHandler.installPart(new ItemPart(core.getPlayer()));

        CommandRegister commandRegister = new SimpleCommandRegister(core, partHandler, "/");
        commandRegister.registerCommand(
                new ShopCommand(core),
                new MainCommands(core),
                new ActionCommand(core)
        );

        while (core.isEnabled()) {
            commandRegister.executeCommand(input.nextLine());
        }

    }
}
