package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.command.MainCommands;
import com.maimai.tamagotchi.command.ShopCommand;
import com.maimai.tamagotchi.command.SimpleCommandRegister;
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
        this.shop = shop;
    }

    @Override
    public void load() {

        Scanner input = new Scanner(System.in);

        PartHandler partHandler = new PartHandler();
        partHandler.installPart(new StringPart());
        partHandler.installPart(new ActionPart(core.getPlayer().getTamagotchi().getActionManager()));
        partHandler.installPart(new ItemPart(core.getPlayer()));

        CommandRegister commandRegister = new SimpleCommandRegister(partHandler, "/");
        commandRegister.registerCommand(
                new ShopCommand(core),
                new MainCommands(core)
        );

        while (core.isEnabled()) {
            commandRegister.executeCommand(input.nextLine());
        }

    }
}
