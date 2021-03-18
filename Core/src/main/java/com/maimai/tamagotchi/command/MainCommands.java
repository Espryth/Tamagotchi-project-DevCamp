package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.TamagotchiMain;
import com.maimai.tamagotchi.action.Action;
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
                "I am a help list",
                "!"
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
            name = "action",
            usage = "/action [action name]"
    )
    public void executeActionCommand(Action<Player> action) {
        if(!action.getActionRequirement().requeriment(core.getPlayer())) {
            System.out.println("Can't execute this action!");
            return;
        }
        action.getActionExecutor().execute(core.getPlayer());
    }

    @Command(
            name = "inventory", usage = "")
    public void executeInventoryCommand(){
        Inventory inventory = core.getPlayer().getInventory();

        System.out.println("Inventory size: " + inventory.getSize());
        System.out.println("");
        System.out.println("List of items:");
        for (Item item : inventory.getItems()){
            System.out.println("- " + item.getDefaultType().getName() + " - Value:" + item.getDefaultType().getValue());
        }
    }


    @Command(
            name = "stats", usage = "")
    public void executeStatsCommand(){

        Player player = core.getPlayer();
        Tamagotchi tamagotchiMain = core.getPlayer().getTamagotchi();

        System.out.println("Stats:");
        System.out.println("");
        System.out.println("Player:");
        System.out.println("- Name: " + player.getName());
        System.out.println("- Money: " + player.getMoney().getValue());
        System.out.println();
        System.out.println("Tamagochi:");
        System.out.println("- Type: " + tamagotchiMain.getType().getName());
        System.out.println("- Name: " + tamagotchiMain.getName());
        System.out.println("");
        System.out.println("Status of " + tamagotchiMain.getName() + ":");
        System.out.println("- Hunger points: " + tamagotchiMain.getHunger().getValue());
        System.out.println("- Thirst points: " + tamagotchiMain.getThirst().getValue());
        System.out.println("- Health points: " + tamagotchiMain.getHealth().getValue());
        System.out.println("- Dirty points: " + tamagotchiMain.getDirty().getValue());
        System.out.println("- Happiness points: " + tamagotchiMain.getHappiness().getValue());
    }

    @Command(
            name = "open",
            usage = "/open [module]"
    )
    public void executeOpenCommand(Module module) {
        module.start();
    }

}
