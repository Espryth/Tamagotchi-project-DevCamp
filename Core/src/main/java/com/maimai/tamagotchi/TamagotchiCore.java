package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.event.SimpleEventRegister;
import com.maimai.tamagotchi.loader.CommandLoader;
import com.maimai.tamagotchi.loader.ListenerLoader;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.module.Module;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.scheduler.Scheduler;
import com.maimai.tamagotchi.scheduler.TamagotchiScheduler;

public class TamagotchiCore implements ProgramCore {

    private boolean enabled;

    private Player player;

    private MongoDbManager mongoDbManager;
    private Scheduler scheduler;

    private EventRegister eventRegister;

    @Override
    public void initCore() {

        initObjects();

        this.enabled = true;
        this.scheduler = new TamagotchiScheduler();
        Module module = new MainModule(this);

        module.start();

        initLoaders(
                new ListenerLoader(this),
                new CommandLoader(this)
        );
    }

    private void initLoaders(Loader... loaders) {
        for (Loader loader : loaders) {
            loader.load();
        }
    }

    private void initObjects() {
        //this.mongoDbManager = new MongoDbManager();
        this.eventRegister = new SimpleEventRegister();
    }





    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean bol) {
        this.enabled = bol;
    }

    @Override
    public EventRegister getEventRegister() {
        return eventRegister;
    }

    @Override
    public CommandRegister getCommandRegister() {
        return null;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }


    @Override
    public MongoDbManager getMongoManager() {
        return mongoDbManager;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }
}
