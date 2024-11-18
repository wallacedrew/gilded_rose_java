package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrieUpdater extends Updater {
    private Item item;

    public AgedBrieUpdater(Item item) {
        this.item = item;
    }

    public void update() {
        age(item);
        upgrade(item);
        if (hasExpired(item)) upgrade(item);
    }
}
