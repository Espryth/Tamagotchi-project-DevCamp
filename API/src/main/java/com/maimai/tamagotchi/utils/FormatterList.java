package com.maimai.tamagotchi.utils;

import java.util.Arrays;
import java.util.List;

public class FormatterList {

    public static List<String> format(List<String> list, String... args) {

        StringBuilder stringBuilder = new StringBuilder();

        list.forEach(line -> stringBuilder.append(line).append(";"));

        String formatted = String.format(stringBuilder.toString(), args);

        return Arrays.asList(formatted.split(";"));
    }
}
