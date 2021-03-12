package com.maimai.tamagotchi.item.bath;

import com.maimai.tamagotchi.item.DefaultType;

public enum BathType implements DefaultType {
    DOGSOAP("Shampoo de perro", 50), CATSOAP("Shampoo de gato", 50);

    private final String name;
    private final double value;

    BathType(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }
}
