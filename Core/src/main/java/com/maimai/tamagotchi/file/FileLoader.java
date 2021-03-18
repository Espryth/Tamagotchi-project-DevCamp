package com.maimai.tamagotchi.file;

public class FileLoader {

    private FileManager fileManager;


    public FileLoader() throws Exception {
        FileManager file = new FileManager("nose.txt");
    }
}
