package com.maimai.tamagotchi.database.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maimai.tamagotchi.Model;
import com.maimai.tamagotchi.Provider;
import com.maimai.tamagotchi.database.ObjectRepository;
import com.mongodb.client.MongoDatabase;

public class ObjectRepositoryProvider<T extends Model> implements Provider<ObjectRepository<T>> {

    private final ObjectRepository<T> objectRepository;

    public ObjectRepositoryProvider(MongoDatabase mongoDatabase,
                                    String collectionName,
                                    Class<T> clazz,
                                    ObjectMapper objectMapper) {

        this.objectRepository = new MongoObjectRepository<>(
                mongoDatabase,
                collectionName,
                clazz,
                objectMapper
        );
    }

    @Override
    public ObjectRepository<T> get() {
        return objectRepository;
    }
}
