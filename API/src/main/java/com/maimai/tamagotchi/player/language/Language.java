package com.maimai.tamagotchi.player.language;

public enum Language {
    ES("lang_es"),
    EN("lang_en");

    private final String fileName;

    Language(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
