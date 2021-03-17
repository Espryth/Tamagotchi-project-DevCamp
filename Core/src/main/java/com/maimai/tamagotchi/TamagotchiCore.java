package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.loader.CommandLoader;
import com.maimai.tamagotchi.loader.Loader;

public class TamagotchiCore implements ProgramCore {

    private boolean enabled;

    @Override
    public void initCore() {

        this.enabled = true;

        initLoaders(
                new CommandLoader(this)
        );

    }

    private void initLoaders(Loader... loaders) {
        for (Loader loader : loaders) {
            loader.load();
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
        return null;
    }

    @Override
    public CommandRegister getCommandRegister() {
        return null;
    }
}
