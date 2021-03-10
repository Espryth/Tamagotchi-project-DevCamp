package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.DefaultType;

public enum FoodType implements DefaultType {
    APPLE("Manzana", 10);

    private String name;
    private double value;

    FoodType(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
