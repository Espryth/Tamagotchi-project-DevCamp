package com.maimai.tamagochi.database;

import com.maimai.tamagochi.Provider;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoClientProvider implements Provider<MongoClient> {

    private final MongoClient mongoClient;

    public MongoClientProvider(String uri) {
        this.mongoClient = MongoClients.create(uri);
    }

    @Override
    public MongoClient get() {
        return mongoClient;
    }
}
