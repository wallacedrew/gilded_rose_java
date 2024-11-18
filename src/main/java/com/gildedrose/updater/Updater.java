package com.gildedrose.updater;

import com.gildedrose.Item;

public abstract class Updater {

    public Updater() {}

    public abstract void update();

    protected boolean qualityNotMaxed(Item item) {
        return item.quality < 50;
    }

    protected boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    protected void age(Item item) {
        item.sellIn--;
    }

    protected void upgrade(Item item) {
        if (qualityNotMaxed(item)) item.quality++;
    }

    protected void degrade(Item item) {
        if (item.quality > 0) item.quality--;
    }
}
