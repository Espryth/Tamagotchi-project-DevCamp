package com.maimai.tamagotchi;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.command.CommandClass;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.player.Player;

public class TestCommand implements CommandClass {

    private final Player player;

    public TestCommand(Player player) {
       this.player = player;
    }

    @Command(name = "poto", usage = "/poto")
    public void onPoto(String a, Action<Player> action) {
        action.getActionExecutor().execute(player);
    }
}
