package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.loader.CommandLoader;
import com.maimai.tamagotchi.loader.ListenerLoader;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.module.Module;
import com.maimai.tamagotchi.player.Player;

public class TamagotchiCore implements ProgramCore {

    private boolean enabled;

    private MongoDbManager mongoDbManager;

    @Override
    public void initCore() {

        this.enabled = true;

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
        this.mongoDbManager = new MongoDbManager();
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
        return null;
    }

    @Override
    public CommandRegister getCommandRegister() {
        return null;
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public void setPlayer(Player player) {

    }


    @Override
    public MongoDbManager getMongoManager() {
        return mongoDbManager;
    }
}
