package com.gildedrose.updater;

import com.gildedrose.Item;

public class BackstageUpdater extends Updater {

    public void update(Item item) {
        upgrade(item);
        if (qualityNotMaxed(item)) {
            if (item.sellIn < 11) upgrade(item);
            if (item.sellIn < 6) upgrade(item);
        }
        if (hasExpired(item)) item.quality = 0;
        age(item);
    }
}
