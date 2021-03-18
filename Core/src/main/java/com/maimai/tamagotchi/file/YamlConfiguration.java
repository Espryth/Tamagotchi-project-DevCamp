package com.maimai.tamagotchi.file;

import com.sun.javafx.binding.StringFormatter;

import java.util.HashMap;
import java.util.List;

public class YamlConfiguration implements File {

    private final HashMap<String, String> stringPath = new HashMap<>();
    private final HashMap<String, List<String>> listStringPath = new HashMap<>();

    private String fileName;

    public YamlConfiguration(String fileName) {
        this.fileName = fileName;
    }


    @Override
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


    @Override
    public List<String> getStringList(String path){
        return listStringPath.get(path);
    }


}
