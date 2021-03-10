package com.maimai.tamagotchi;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Nameable extends Model {

    @JsonProperty("name")
    String getName();

}
