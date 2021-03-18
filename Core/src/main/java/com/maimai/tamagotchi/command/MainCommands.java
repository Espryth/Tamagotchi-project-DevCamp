package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.module.Module;
import com.maimai.tamagotchi.player.Player;

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
            name = "open",
            usage = "/open [module]"
    )
    public void executeOpenCommand(Module module) {
        module.start();
    }

}
