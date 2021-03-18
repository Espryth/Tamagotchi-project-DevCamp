package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.module.Module;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

import java.util.Arrays;

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
        Arrays.asList(
                "Tamagotchi help commands:",
                "/exit",
                "/inventory",
                "/stats",
                "/open [module]",
                "/shop help",
                "/action [action] <item>"
        ).forEach(System.out::println);
    }

    @Command(
            name = "exit",
            usage = "/exit"
    )
    public void executeExistCommand() {
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
        for (Item item : inventory.getItems()){
            System.out.println("- " + item.getDefaultType().getName() + " - Value:" + item.getDefaultType().getValue());
        }
    }


    @Command(
            name = "stats", usage = "/stats")
    public void executeStatsCommand(){

        Player player = core.getPlayer();
        Tamagotchi tamagotchiMain = core.getPlayer().getTamagotchi();

        Arrays.asList(
                "Stats:",
                "",
                "Player:",
                "- Name: " + player.getName(),
                "- Money: " + player.getMoney().getValue(),
                "",
                "Tamagochi:",
                "- Type: " + tamagotchiMain.getType().getName(),
                "- Name: " + tamagotchiMain.getName(),
                "",
                "Status of " + tamagotchiMain.getName() + ":",
                "- Health points: " + tamagotchiMain.getHealth().getValue(),
                "- Hunger points: " + tamagotchiMain.getHunger().getValue(),
                "- Thirst points: " + tamagotchiMain.getThirst().getValue(),
                "- Happiness points: " + tamagotchiMain.getHappiness().getValue(),
                "- Dirty points: " + tamagotchiMain.getDirty().getValue()
        ).forEach(System.out::println);
    }

    @Command(
            name = "open",
            usage = "/open [module]"
    )
    public void executeOpenCommand(Module module) {
        module.start();
    }

}
