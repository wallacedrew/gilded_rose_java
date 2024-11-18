package com.gildedrose.updater;

import com.gildedrose.Item;

public class ConjureUpdater extends Updater {

    public void update(Item item) {
        age(item);
        degrade(item);
        if (hasExpired(item)) degrade(item);
    }
}
