package com.maimai.tamagotchi;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Model {

    @JsonProperty("_id")
    String getId();

}
