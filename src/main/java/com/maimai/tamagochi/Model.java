package com.maimai.tamagochi;

import org.bson.types.ObjectId;

public interface Model {

    ObjectId getObjectId();

    void setObjectId(ObjectId id);
}
