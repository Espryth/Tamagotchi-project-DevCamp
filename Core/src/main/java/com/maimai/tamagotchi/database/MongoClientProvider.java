package com.maimai.tamagotchi.database;

import com.maimai.tamagotchi.Provider;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoClientProvider implements Provider<MongoClient> {

    private final MongoClient mongoClient;

    public MongoClientProvider(String uri) {
        mongoClient = MongoClients.create(
                MongoClientSettings
                        .builder()
                        .applyConnectionString(new ConnectionString(uri))
                        .build()
        );
    }

    @Override
    public MongoClient get() {
        return mongoClient;
    }
}
