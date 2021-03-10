package com.maimai.tamagotchi.database;

import com.maimai.tamagotchi.Provider;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDatabaseProvider implements Provider<MongoDatabase> {

    private MongoDatabase mongoDatabase;

    public MongoDatabaseProvider(MongoClient mongoClient,
                                 String dbname) {

        this.mongoDatabase = mongoClient.getDatabase(dbname);
    }

    @Override
    public MongoDatabase get() {
        return null;
    }
}
