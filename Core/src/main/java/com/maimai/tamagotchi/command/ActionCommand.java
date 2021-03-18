package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.annotation.OptArg;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.player.Player;

public class ActionCommand implements CommandClass {

    private final Player player;

    public ActionCommand(Player player) {
        this.player = player;
    }

    @Command(
            name = "action",
            usage = "/action [action] <item>"
    )
    public void executeActionCommand(Action action, @OptArg Item item) {

        if(action.getActionRequirement().requeriment(player, item)) {
            action.getActionExecutor().execute(player, item);
        }

    }

}
