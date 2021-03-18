package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.ItemType;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.scheduler.Scheduler;
import com.maimai.tamagotchi.scheduler.TamagotchiScheduler;
import com.maimai.tamagotchi.shop.ShopMain;

import java.util.List;

public interface ProgramCore {

    void initCore();

    boolean isEnabled();

    void setEnabled(boolean bol);

    EventRegister getEventRegister();

    Player getPlayer();

    void setPlayer(Player player);

    MongoDbManager getMongoManager();

    ShopMain getShop();

    Scheduler getScheduler();
}
