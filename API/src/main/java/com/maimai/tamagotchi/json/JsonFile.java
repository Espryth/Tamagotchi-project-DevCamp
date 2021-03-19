package com.maimai.tamagotchi.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class JsonFile {

    private File file;
    private String name;
    private JSONParser jsonParser;
    private Object object;
    private JSONArray jsonArray;

    public JsonFile(String name) {
        this.name = name;
        try {
            URL resource = getClass().getClassLoader().getResource(name + ".json");
            this.file = new File(resource.toURI());
            if (!file.exists()) {
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            this.jsonParser = new JSONParser();
        } catch (IOException | URISyntaxException exception) {
            exception.printStackTrace();
        }
    }

    public void readJson() {
        try (FileReader reader = new FileReader(name+".json")) {
            this.object = jsonParser.parse(reader);
            this.jsonArray = (JSONArray) object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }
}