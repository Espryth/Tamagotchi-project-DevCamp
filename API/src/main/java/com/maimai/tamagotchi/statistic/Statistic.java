package com.maimai.tamagotchi.statistic;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Statistic<T extends Number> {

    void increase(T value);

    void decrement(T value);

    @JsonProperty("value")
    T getValue();

    void setValue(T value);

}
