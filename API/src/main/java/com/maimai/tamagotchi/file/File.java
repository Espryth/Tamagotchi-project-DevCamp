package com.maimai.tamagotchi.file;

import java.util.List;

public interface File {

    String getString(String path);

    List<String> getStringList(String path);
}
