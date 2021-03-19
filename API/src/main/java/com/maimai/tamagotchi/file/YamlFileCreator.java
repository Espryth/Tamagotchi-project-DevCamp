package com.maimai.tamagotchi.file;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class YamlFileCreator {

    private File file;

    private YamlConfiguration yamlConfiguration;

    public YamlFileCreator(String fileName) {
        try {
            URL resource = getClass().getClassLoader().getResource(fileName + ".yml");
            this.file = new File(resource.toURI());
            if(!file.exists()) {
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            this.yamlConfiguration = new YamlConfiguration();
            loadConfig();
        } catch (IOException | URISyntaxException exception) {
            exception.printStackTrace();
        }
    }

    public void loadConfig() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.lines().collect(Collectors.toList()).forEach(lines -> {
                //yamlConfiguration.setString(lines.split(":")[0], lines.split(":")[1]);
            });
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String getString(String path) {
        return yamlConfiguration.getString(path);
    }

    public List<String> getStringList(String path) {
        return yamlConfiguration.getStringList(path);
    }
}