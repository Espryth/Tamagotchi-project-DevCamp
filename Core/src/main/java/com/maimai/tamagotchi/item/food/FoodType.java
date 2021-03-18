package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.DefaultType;

public enum FoodType implements DefaultType {
    SEED("Seed", 15, 10), //HAMSTER,PARROT
    APPLE("Apple", 10, 5), //HAMSTER,PARROT
    BERRIE("Berrie", 15, 10), //HAMSTER,PARROT
    MANGO("Mango", 30, 15), //HAMSTER,PARROT
    CARROT("Carrot", 15, 10), //HAMSTER,PARROT,RABBIT
    LETTUCE("Lettuce", 50, 25), //HAMSTER,PARROT,RABBIT
    FISH("Fish", 30, 15), //CAT,DOG
    BEEF("Beef", 50, 25), //CAT,DOG
    CHICKEN("Chicken", 15, 10); //CAT,DOG

    private final String name;
    private final double value;
    private final int cost;

    FoodType(String name, double value, int cost) {
        this.name = name;
        this.value = value;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
