package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.module.Module;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;
import com.maimai.tamagotchi.utils.MessageUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MainCommands implements CommandClass {

    private final ProgramCore core;

    public MainCommands(ProgramCore core) {
        this.core = core;
    }

    @Command(
            name = "help",
            usage = "/help"
    )
    public void executeHelpCommand() {
        MessageUtils.sendMessageListFromLang(core, "commons.help");
    }

    @Command(
            name = "exit",
            usage = "/exit"
    )
    public void executeExitCommand() {
        core.setEnabled(false);
        System.out.println("Bye!");
    }

    @Command(
            name = "inventory", usage = "/inventory")
    public void executeInventoryCommand(){
        Inventory inventory = core.getPlayer().getInventory();
        Arrays.asList(
                "Inventory size: " + inventory.getSize(),
                "",
                "List of items:"
        ).forEach(System.out::println);

        Set<Item> itemSet = new HashSet<>(inventory.getItems());

        for (Item item : itemSet){

            String amount = Integer.toString(Collections.frequency(inventory.getItems(), item));
            String value = Double.toString(item.getDefaultType().getValue());

            MessageUtils.sendMessageFromLang(core, "inventory.view", item.getDefaultType().getName(), amount, value);
        }
    }


    @Command(
            name = "stats", usage = "/stats")
    public void executeStatsCommand(){

        Player player = core.getPlayer();
        Tamagotchi tamagotchiMain = core.getPlayer().getTamagotchi();

        MessageUtils.sendMessageListFromLang(core, "stats.view",
                player.getName(),
                Integer.toString(player.getMoney().getValue()),
                tamagotchiMain.getType().getName(),
                tamagotchiMain.getName(),
                tamagotchiMain.getName(),
                Double.toString(tamagotchiMain.getHealth().getValue()),
                Double.toString(tamagotchiMain.getHunger().getValue()),
                Double.toString(tamagotchiMain.getThirst().getValue()),
                Double.toString(tamagotchiMain.getHappiness().getValue()),
                Double.toString(tamagotchiMain.getDirty().getValue())
        );
    }

}
