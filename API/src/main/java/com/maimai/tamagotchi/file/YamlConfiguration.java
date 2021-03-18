package com.maimai.tamagotchi.file;

import java.util.HashMap;
import java.util.List;

public class YamlConfiguration {

    private final HashMap<String, String> stringPath;
    private final HashMap<String, List<String>> listStringPath;

    public YamlConfiguration() {
        this.stringPath = new HashMap<>();
        this.listStringPath = new HashMap<>();
    }

    public String getString(String path) {
        return stringPath.get(path);
    }

    public void setString(String path, String text){
        if (stringPath.get(path) == null){
            stringPath.put(path, text);
            return;
        }

        stringPath.replace(path, text);
    }

    public void setStringList(String path, List<String> text){
        if (listStringPath.get(path) == null){
            listStringPath.put(path, text);
            return;
        }

        listStringPath.replace(path, text);
    }

    public List<String> getStringList(String path){
        return listStringPath.get(path);
    }

}
