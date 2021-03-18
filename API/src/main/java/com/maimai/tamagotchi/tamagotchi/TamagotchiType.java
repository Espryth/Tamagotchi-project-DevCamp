package com.maimai.tamagotchi.tamagotchi;

public enum TamagotchiType {
    CAT("Cat"), DOG("Dog"), PARROT("Parrot"), HAMSTER("Hamster"), RABBIT("Rabbit");

    private final String name;

    TamagotchiType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
