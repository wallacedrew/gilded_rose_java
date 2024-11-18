package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrieUpdater extends Updater {

    public void update(Item item) {
        age(item);
        upgrade(item);
        if (hasExpired(item)) upgrade(item);
    }
}
