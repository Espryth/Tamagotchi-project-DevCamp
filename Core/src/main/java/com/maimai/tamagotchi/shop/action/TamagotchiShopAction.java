package com.maimai.tamagotchi.shop.action;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.ItemBuilder;
import com.maimai.tamagotchi.item.ItemType;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.utils.MessageUtils;

public class TamagotchiShopAction implements ShopAction {

    private ProgramCore core;

    public TamagotchiShopAction(ProgramCore core) {
        this.core = core;
    }

    @Override
    public void buyItem(Player player, ItemType itemType, DefaultType defaultType) {

        Statistic<Integer> money = player.getMoney();

        if (money.getValue() < defaultType.getCost()) {
            MessageUtils.sendMessageFromLang(core, "shop.haveNotMoney");
            return;
        }

        Item item = new ItemBuilder.Builder()
                .createExecutor((t,p) -> {
                })
                .setType(defaultType)
                .setItemType(itemType).build();

        player.getInventory().addItem(item);
        money.decrement(defaultType.getCost());
        MessageUtils.sendMessageFromLang(core, "shop.purchased", defaultType.getCost() + "$.");
    }

    @Override
    public void sellItem(Player player, int id) {

        DefaultType defaultType = player.getInventory().getItem(id).getDefaultType();

        player.getInventory().removeItem(id);
        player.getMoney().increase(defaultType.getCost());

        MessageUtils.sendMessageFromLang(core, "shop.purchased", defaultType.getCost() + "$.");
    }
}
