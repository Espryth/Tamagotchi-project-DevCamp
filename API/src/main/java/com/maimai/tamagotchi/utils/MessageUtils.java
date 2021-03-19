package com.maimai.tamagotchi.utils;

import com.maimai.tamagotchi.ProgramCore;

import java.util.Arrays;
import java.util.List;

public class MessageUtils {

    public static void sendMessageFromLang(ProgramCore core, String path, String... replacements) {
        core.getLanguageManager().find(core.getPlayer().getLanguage()).ifPresent(file -> {
            //if(file.getString(path).isEmpty()) {
              //  sendMessage("An error occurred while trying to send the message " + path);
                //return;
            //}

            //String str = file.getString(path);

            //sendMessage(String.format(str, replacements));

        });
    }

    public static void sendMessageListFromLang(ProgramCore core, String path, String... replacements) {
        core.getLanguageManager().find(core.getPlayer().getLanguage()).ifPresent(file -> {
            if(file.getString(path).isEmpty()) {
                sendMessage("An error occurred while trying to send the message " + path);
                return;
            }

            List<String> list = file.getStringList(path);

            sendMessage(FormatterList.format(list, replacements));
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
