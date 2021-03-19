package com.maimai.tamagotchi.file;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class JsonFile {

    private File file;
    private String name;
    private JSONParser jsonParser;
    private Object object;
    private JSONObject jsonObject;

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
            readJson();
        } catch (IOException | URISyntaxException exception) {
            exception.printStackTrace();
        }
    }

    public void readJson() {
        try {
            this.object = jsonParser.parse( new FileReader(file));
            this.jsonObject = (JSONObject)object;
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }

    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public String getString(String path) {
        return JsonPath.read(getJsonObject(), path);
    }

    public List<String> getStringList(String path) {
        return JsonPath.read(getJsonObject(), path);
    }
}