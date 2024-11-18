package com.gildedrose.updater;

import com.gildedrose.Item;

public abstract class Updater {

    public Updater() {}

    public abstract void update();

    public boolean qualityNotMaxed(Item item) {
        return item.quality < 50;
    }

    public boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    public void age(Item item) {
        item.sellIn--;
    }

    public void upgrade(Item item) {
        if (qualityNotMaxed(item)) item.quality++;
    }

    public void degrade(Item item) {
        if (item.quality > 0) item.quality--;
    }
}
