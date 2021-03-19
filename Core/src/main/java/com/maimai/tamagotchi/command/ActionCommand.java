package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.annotation.OptArg;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.utils.MessageUtils;

public class ActionCommand implements CommandClass {

    private final ProgramCore core;

    public ActionCommand(ProgramCore core) {
        this.core = core;
    }

    @Command(
            name = "action",
            usage = "/action [action] <item>"
    )
    public void executeActionCommand(@OptArg Action action, @OptArg Item item) {
        Player player = core.getPlayer();

        if(action == null) {
            MessageUtils.sendMessageListFromLang(core,"actions.help");
            return;
        }

        if(action.getActionRequirement().requeriment(player, item)) {
            action.getActionExecutor().execute(player, item);
        }

    }

}
