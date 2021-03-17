package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.player.Player;

public class ActionCommand implements CommandClass {

    private final Player player;

    public ActionCommand(Player player) {
        this.player = player;
    }

    @Command(name = "action", usage = "/action [action]")
    public void executeActionCommand(Action<Player> action) {
        action.getActionExecutor().execute(player);
    }
}
