package com.maimai.tamagotchi;

import com.maimai.tamagotchi.file.YamlFileCreator;

public class TamagotchiMain {

    public static void main(String[] args) {

        YamlFileCreator fileCreator = new YamlFileCreator("poto");
        System.out.println(fileCreator.getString("asd"));

        ProgramCore core = new TamagotchiCore();
        core.initCore();

    }

}
