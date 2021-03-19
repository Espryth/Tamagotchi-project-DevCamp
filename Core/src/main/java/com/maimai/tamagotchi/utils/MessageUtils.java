package com.maimai.tamagotchi.utils;

import com.maimai.tamagotchi.ProgramCore;

import java.util.Arrays;
import java.util.List;

public class MessageUtils {

    public static void sendMessage(ProgramCore core, String path) {
        core.getLanguageManager().find(core.getPlayer().getLanguage()).ifPresent(file -> {
            if(file.getString(path).isEmpty()) {
                System.out.println("An error occurred while trying to send the message " + path);
                return;
            }
            System.out.println(file.getString(path));
        });
    }

    public static void sendMessage(String message) {
        System.out.println(message);
    }

    public static void sendMessage(String... messages) {
        sendMessage(Arrays.asList(messages));
    }

    public static void sendMessage(List<String> messages) {
        messages.forEach(System.out::println);
    }


}
