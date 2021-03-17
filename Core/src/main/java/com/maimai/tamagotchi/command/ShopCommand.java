package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.module.Module;

public class ShopCommand implements CommandClass {

    @Command(name = "shop", usage = "/shop [buy/sell] [item]")
    public void executeShopCommand(String args) {
    }
}
