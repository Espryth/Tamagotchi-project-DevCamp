package com.maimai.tamagotchi.listener;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.event.EventHandler;
import com.maimai.tamagotchi.event.game.GameEndEvent;
import com.maimai.tamagotchi.event.listener.Listener;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.utils.MessageUtils;

public class GameEndListener implements Listener {

    private final Player player;

    private final ProgramCore core;

    public GameEndListener(ProgramCore core ) {
        this.core = core;
        this.player = core.getPlayer();;
    }

    @EventHandler
    public void onGameEnd(GameEndEvent event) {

        switch (event.getCause()) {

            case PLAYER_EXIT:
                MessageUtils.sendMessageFromLang(core, "commons.exit");
                break;

            case TAMAGOTCHI_DEAD:
                MessageUtils.sendMessageFromLang(core, "tamagotchi.death");
                break;
        }

        core.setEnabled(false);

    }
}
