package com.maimai.tamagotchi;

import com.maimai.tamagotchi.file.JsonFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class TamagotchiMain {

    public static void main(String[] args) {
        JsonFile file = new JsonFile("lang_en");
        JSONArray companyList = (JSONArray) ((JSONObject) file.getJsonObject().get("commons")).get("welcomeBack");
        Iterator<JSONObject> iterator = companyList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        ProgramCore core = new TamagotchiCore();
        core.initCore();

    }

}
