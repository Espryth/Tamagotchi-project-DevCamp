package com.maimai.tamagotchi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maimai.tamagotchi.Model;

public interface Entity {

    @JsonProperty("name")
    String getName();

}
