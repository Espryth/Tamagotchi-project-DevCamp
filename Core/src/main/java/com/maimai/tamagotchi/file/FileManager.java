package com.maimai.tamagotchi.file;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileManager {

    private String fileName;

    private File file;
    private YamlConfiguration yamlConfiguration;

    public FileManager(String fileName) throws Exception {
        this.fileName = fileName;
        setupFile();
    }

    public void setupFile() throws Exception {
        URL resource = getClass().getClassLoader().getResource(fileName + ".yml");

        file = new File(resource.toURI());
        file.createNewFile();

        yamlConfiguration = new YamlConfiguration(fileName);
        reloadYaml();
    }

    public void reloadYaml() throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        for (String lines : bufferedReader.lines().collect(Collectors.toList())) {
            yamlConfiguration.setString(lines.split(":")[0], lines.split(":")[1]);
        }

    }

    public YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }
}
