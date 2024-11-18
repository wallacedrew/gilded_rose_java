package com.gildedrose.updater;

import com.gildedrose.Item;

public class DexterityUpdater extends Updater {
    private Item item;

    public DexterityUpdater(Item item) {
        this.item = item;
    }

    public void update() {
        age(item);
        degrade(item);
        if (hasExpired(item)) degrade(item);
    }
}
