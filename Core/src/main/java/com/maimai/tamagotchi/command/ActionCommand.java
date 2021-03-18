package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.annotation.OptArg;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.player.Player;

public class ActionCommand implements CommandClass {

    @Command(
            name = "action",
            usage = "/action [action] <item>"
    )
    public void executeActionCommand(Action<Player> action, @OptArg Item item){}

}
