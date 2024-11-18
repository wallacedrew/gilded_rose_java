package com.gildedrose.updater;

import com.gildedrose.Item;

public class ConjureUpdater extends Updater {
    private Item item;

    public ConjureUpdater(Item item) {
        this.item = item;
    }

    public void update() {
        age(item);
        decay();
        if (hasExpired(item)) {
            decay();
        }
    }

    private void decay() {
        degrade(item);
        degrade(item);
    }
}
