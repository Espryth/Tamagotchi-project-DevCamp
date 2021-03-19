package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.event.game.GameEndCause;
import com.maimai.tamagotchi.event.game.GameEndEvent;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.Item;
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
        core.getEventRegister().callEvent(new GameEndEvent(GameEndCause.PLAYER_EXIT));
    }


}
