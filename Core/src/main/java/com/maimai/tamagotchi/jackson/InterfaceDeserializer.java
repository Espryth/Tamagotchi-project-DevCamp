package com.maimai.tamagotchi.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.player.SimplePlayer;
import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class InterfaceDeserializer {

    public static SimpleModule getAbstractTypes() {

        SimpleModule module = new SimpleModule("InterfaceDeserializer", Version.unknownVersion());

        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver()
                .addMapping(Tamagotchi.class, AbstractTamagotchi.class)
                .addMapping(Player.class, SimplePlayer.class);

        module.setAbstractTypes(resolver);

        return module;
    }
}
