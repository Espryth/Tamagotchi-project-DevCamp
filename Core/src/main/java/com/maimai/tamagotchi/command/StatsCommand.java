package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;
import com.maimai.tamagotchi.utils.MessageUtils;

public class StatsCommand implements CommandClass {

    private final ProgramCore core;

    public StatsCommand(ProgramCore core) {
        this.core = core;
    }

    @Command(
            name = "stats", usage = "/stats")
    public void executeStatsCommand(){

        Player player = core.getPlayer();
        Tamagotchi tamagotchiMain = core.getPlayer().getTamagotchi();

        MessageUtils.sendMessageListFromLang(core, "stats",
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
