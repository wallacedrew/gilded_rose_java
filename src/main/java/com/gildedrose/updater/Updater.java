package com.gildedrose.updater;

import com.gildedrose.Item;

public class Updater {

//    public abstract void update(Item item);

    public void updateAgedBrie(Item item) {
        age(item);
        upgrade(item);
        if (hasExpired(item)) upgrade(item);
    }

    public void updateBackstage(Item item) {
        upgrade(item);
        if (qualityNotMaxed(item)) {
            if (item.sellIn < 11) upgrade(item);
            if (item.sellIn < 6) upgrade(item);
        }
        if (hasExpired(item)) item.quality = 0;
        age(item);
    }

    public void updateItem(Item item) {
        age(item);
        degrade(item);
        if (hasExpired(item)) degrade(item);
    }

    public void updateSulfuras(Item item) {
    }

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
