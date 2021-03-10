package com.maimai.tamagotchi.manager;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface Manager<T> {

    Map<String, T> getCache();

    default Optional<T> find(String key) {
        return Optional.ofNullable(getCache().get(key));
    }

    default void insert(String key, T t) {
        getCache().put(key, t);
    }

    default Collection<T> values() {
        return getCache().values();
    }

}
