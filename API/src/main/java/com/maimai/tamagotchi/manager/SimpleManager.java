package com.maimai.tamagotchi.manager;


import com.maimai.tamagotchi.entity.Entity;
import org.bson.types.ObjectId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleManager<T extends Entity> implements Manager<T> {

    private final Map<ObjectId, T> cache;

    public SimpleManager() {
        this.cache = new ConcurrentHashMap<>();
    }

    @Override
    public T find(ObjectId id) {
        return cache.get(id);
    }

    @Override
    public void save(ObjectId id, T value) {
        this.cache.put(id, value);
    }
}
