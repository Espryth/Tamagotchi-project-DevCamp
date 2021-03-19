package com.maimai.tamagotchi;

import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.event.SimpleEventRegister;
import com.maimai.tamagotchi.file.YamlFileCreator;
import com.maimai.tamagotchi.loader.CommandLoader;
import com.maimai.tamagotchi.loader.ListenerLoader;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.manager.ManagerImpl;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.module.Module;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.player.language.Language;
import com.maimai.tamagotchi.scheduler.Scheduler;
import com.maimai.tamagotchi.scheduler.TamagotchiScheduler;
import com.maimai.tamagotchi.shop.Shop;
import com.maimai.tamagotchi.shop.TamagotchiShop;

public class TamagotchiCore implements ProgramCore {

    private boolean enabled;

    private Player player;

    private MongoDbManager mongoDbManager;
    private Scheduler scheduler;

    private EventRegister eventRegister;

    private Shop shop;

    private Manager<Language, YamlFileCreator> languageManager;

    @Override
    public void initCore() {

        initObjects();

        this.enabled = true;
        this.scheduler = new TamagotchiScheduler();

        Module module = new MainModule(this, mongoDbManager);

        module.start();

        initLanguages();

        initLoaders(
                new ListenerLoader(this),
                new TamagotchiShop(),
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
        this.languageManager = new ManagerImpl<>();
        this.eventRegister = new SimpleEventRegister();
        this.shop = new TamagotchiShop();
    }

    private void initLanguages() {
        for(Language language : Language.values()) {
            YamlFileCreator file = new YamlFileCreator(language.getFileName());
            languageManager.insert(language, file);
        }
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
    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Manager<Language, YamlFileCreator> getLanguageManager() {
        return languageManager;
    }


    @Override
    public Scheduler getScheduler() {
        return scheduler;
    }


    @Override
    public Shop getShop() {
        return shop;
    }
}
