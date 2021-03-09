package com.maimai.tamagotchi.action;

import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.entity.Entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionManager<T extends Entity> implements Manager<Action<T>> {

    private final Map<String, Action<T>> actionCache;

    public ActionManager() {
        this.actionCache = new ConcurrentHashMap<>();
    }

    @Override
    public Map<String, Action<T>> getCache() {
        return actionCache;
    }
}
