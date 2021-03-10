package com.maimai.tamagotchi.database;

import com.maimai.tamagotchi.Model;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public interface ObjectRepository<T extends Model> {

    default CompletableFuture<Optional<T>> findOneAsync(String id) {
        return supplyAsync(() -> findOneSync(id));
    }

    Optional<T> findOneSync(String id);

    default CompletableFuture<Set<T>> findManyAsync(String... ids) {
        return supplyAsync(() -> findManySync(ids));
    }

    Set<T> findManySync(String... ids);

    default CompletableFuture<Set<T>> findAllAsync() {
        return supplyAsync(this::findAllSync);
    }

    Set<T> findAllSync();

    default CompletableFuture<?> saveAsync(T t) {
        return runAsync(() -> saveSync(t));
    }

    void saveSync(T t);

    default CompletableFuture<?> saveOrReplaceAsync(String id, T t) {
        return runAsync(() -> saveOrReplaceSync(id, t));
    }

    void saveOrReplaceSync(String id, T t);

    default CompletableFuture<?> replaceAsync(String id, T t) {
        return runAsync(() -> replaceSync(id, t));
    }

    void replaceSync(String id, T t);

    default CompletableFuture<?> deleteAsync(String id) {
        return runAsync(() -> deleteSync(id));
    }

    void deleteSync(String id);

}
