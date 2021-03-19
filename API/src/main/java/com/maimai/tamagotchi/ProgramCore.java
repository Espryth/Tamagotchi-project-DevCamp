package com.maimai.tamagotchi;

import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.file.JsonFile;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.player.language.Language;
import com.maimai.tamagotchi.scheduler.Scheduler;
import com.maimai.tamagotchi.shop.Shop;

public interface ProgramCore {

    void initCore();

    boolean isEnabled();

    void setEnabled(boolean bol);

    EventRegister getEventRegister();

    Player getPlayer();

    void setPlayer(Player player);

    Manager<Language, JsonFile> getLanguageManager();

    Shop getShop();

    Scheduler getScheduler();
}
