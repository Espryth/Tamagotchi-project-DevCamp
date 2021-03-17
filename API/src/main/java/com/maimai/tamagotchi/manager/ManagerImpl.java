package com.maimai.tamagotchi.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ManagerImpl<K, V> implements Manager<K, V> {

    private final Map<K, V> cache;

    public ManagerImpl() {
        this.cache = new ConcurrentHashMap<>();
    }

    @Override
    public Map<K, V> getCache() {
        return cache;
    }
}
