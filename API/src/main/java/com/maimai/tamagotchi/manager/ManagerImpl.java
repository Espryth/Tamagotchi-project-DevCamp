package com.maimai.tamagotchi.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ManagerImpl<T> implements Manager<T> {

    private final Map<String, T> cache;

    public ManagerImpl() {
        this.cache = new ConcurrentHashMap<>();
    }

    @Override
    public Map<String, T> getCache() {
        return cache;
    }

}
