package com.maimai.tamagotchi;

import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.event.SimpleEventRegister;
import com.maimai.tamagotchi.file.JsonFile;
import com.maimai.tamagotchi.loader.CommandLoader;
import com.maimai.tamagotchi.loader.ListenerLoader;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.loader.TaskLoader;
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

    private Scheduler scheduler;

    private EventRegister eventRegister;

    private Shop tamagotchiShop;

    private Manager<Language, JsonFile> languageManager;

    @Override
    public void initCore() {

        initObjects();

        initLanguages();
        this.enabled = true;
        this.scheduler = new TamagotchiScheduler();


        Module module = new MainModule(this);

        module.start();


        initLoaders(
                new ListenerLoader(this),
                new TaskLoader(this),
                new CommandLoader(this)

        );
    }

    private void initLoaders(Loader... loaders) {
        for (Loader loader : loaders) {
            loader.load();
        }
    }

    private void initObjects() {
        this.languageManager = new ManagerImpl<>();
        this.eventRegister = new SimpleEventRegister();
        this.tamagotchiShop = new TamagotchiShop(this);
    }

    private void initLanguages() {
        for(Language language : Language.values()) {
            JsonFile file = new JsonFile(language.getFileName());
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
    public Manager<Language, JsonFile> getLanguageManager() {
        return languageManager;
    }


    @Override
    public Scheduler getScheduler() {
        return scheduler;
    }


    @Override
    public Shop getShop() {
        return tamagotchiShop;
    }
}
