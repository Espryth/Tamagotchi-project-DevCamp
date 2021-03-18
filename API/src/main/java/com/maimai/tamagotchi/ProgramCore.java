package com.maimai.tamagotchi;

import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.scheduler.Scheduler;

public interface ProgramCore {

    void initCore();

    boolean isEnabled();

    void setEnabled(boolean bol);

    EventRegister getEventRegister();

    Player getPlayer();

    void setPlayer(Player player);

    Scheduler getScheduler();
}
