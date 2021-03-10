package com.maimai.tamagotchi.database.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maimai.tamagotchi.Model;
import com.maimai.tamagotchi.database.ObjectRepository;
import com.mongodb.client.MongoDatabase;
import org.bson.UuidRepresentation;
import org.mongojack.JacksonMongoCollection;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.mongodb.client.model.Filters.eq;

public class MongoObjectRepository<T extends Model> implements ObjectRepository<T> {

    private final JacksonMongoCollection<T> mongoCollection;

    public MongoObjectRepository(MongoDatabase mongoDatabase,
                                 String collectionName,
                                 Class<T> clazz,
                                 ObjectMapper objectMapper) {

        mongoCollection = JacksonMongoCollection
                .builder()
                .withObjectMapper(objectMapper)
                .build(mongoDatabase.getCollection(
                        collectionName, clazz),
                        clazz,
                        UuidRepresentation.STANDARD
                );
    }


    @Override
    public Optional<T> findOneSync(String id) {
        return Optional.ofNullable(mongoCollection.find(eq("_id", id)).first());
    }

    @Override
    public Set<T> findManySync(String... ids) {

        Set<T> set = new HashSet<>();

        for(String id : ids) {

            Optional<T> optional = findOneSync(id);
            optional.ifPresent(set::add);

        }

        return set;
    }

    @Override
    public Set<T> findAllSync() {
        return mongoCollection.find().into(new HashSet<>());
    }

    @Override
    public void saveSync(T t) {
        mongoCollection.insertOne(t);
    }

    @Override
    public void saveOrReplaceSync(String id, T t) {
        mongoCollection.findOneAndReplace(eq("_id", id), t);
    }

    @Override
    public void replaceSync(String id, T t) {
        mongoCollection.replaceOne(eq("_id", id), t);
    }

    @Override
    public void deleteSync(String id) {
        mongoCollection.deleteOne(eq("_id", id));
    }
}
