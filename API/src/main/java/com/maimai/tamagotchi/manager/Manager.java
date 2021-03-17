package com.maimai.tamagotchi.manager;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface Manager<K, V> {

    Map<K, V> getCache();

    default Optional<V> find(K key) {
        return Optional.ofNullable(getCache().get(key));
    }

    default void insert(K key, V value) {
        getCache().put(key, value);
    }

    default Collection<V> values() {
        return getCache().values();
    }

}
