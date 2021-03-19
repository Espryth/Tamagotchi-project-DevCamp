package com.maimai.tamagotchi.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maimai.tamagotchi.Model;
import com.maimai.tamagotchi.entity.Entity;

import java.util.UUID;

public class Test implements Entity {


    private final String name;

    public Test(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

}
