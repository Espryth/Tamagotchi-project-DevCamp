package com.maimai.tamagotchi.manager;

import com.maimai.tamagotchi.entity.Entity;
import org.bson.types.ObjectId;

public interface Manager<T extends Entity> {

    T find(ObjectId id);

    void save(ObjectId id, T value);
}
