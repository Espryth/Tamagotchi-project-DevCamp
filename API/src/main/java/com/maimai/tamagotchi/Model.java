package com.maimai.tamagotchi;

import org.bson.types.ObjectId;

public interface Model {

    ObjectId getId();

    void setId(ObjectId id);

}
