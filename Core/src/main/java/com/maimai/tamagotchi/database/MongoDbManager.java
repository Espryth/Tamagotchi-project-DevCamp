package com.maimai.tamagotchi.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.Provider;
import com.maimai.tamagotchi.database.repository.ObjectRepositoryProvider;
import com.maimai.tamagotchi.file.JsonFile;
import com.maimai.tamagotchi.jackson.ObjectMapperProvider;
import com.maimai.tamagotchi.player.Player;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDbManager {

    private final Provider<MongoDatabase> mongoDatabaseProvider;
    private final Provider<ObjectMapper> objectMapperProvider;

    private Provider<ObjectRepository<Player>> playerRepositoryProvider;
    //private Provider<ObjectRepository<Test>> testRepository;

    public MongoDbManager(JsonFile config) {

        Provider<MongoClient> mongoClientProvider = new MongoClientProvider(config.getString("database.uri"));
        this.mongoDatabaseProvider = new MongoDatabaseProvider(mongoClientProvider.get(), config.getString("database.name"));
        this.objectMapperProvider = new ObjectMapperProvider();

        initRepositories();
    }

    private void initRepositories() {
        this.playerRepositoryProvider = new ObjectRepositoryProvider<>(
                mongoDatabaseProvider.get(),
                "players",
                Player.class,
                objectMapperProvider.get()
        );

    }

    public ObjectRepository<Player> getPlayerRepository() {
        return playerRepositoryProvider.get();
    }
}
