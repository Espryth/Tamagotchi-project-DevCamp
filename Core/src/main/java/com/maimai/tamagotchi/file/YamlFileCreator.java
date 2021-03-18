package com.maimai.tamagotchi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class YamlFileCreator {

    private final String fileName;

    private File file;

    private YamlConfiguration yamlConfiguration;

    public YamlFileCreator(String fileName) {
        this.fileName = fileName;
        createFile();
    }

    public void createFile() {
        try {
            URL resource = getClass().getClassLoader().getResource(fileName + ".yml");

            file = new File(resource.toURI());
            file.createNewFile();

            yamlConfiguration = new YamlConfiguration();
            loadPaths();
        } catch (IOException | URISyntaxException exception) {
            exception.printStackTrace();
        }
    }

    public void loadPaths() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            for (String lines : bufferedReader.lines().collect(Collectors.toList())) {
                yamlConfiguration.setString(lines.split(":")[0], lines.split(":")[1]);
            }
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
