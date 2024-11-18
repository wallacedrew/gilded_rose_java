package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemName;

public abstract class Updater {

    public static Updater createUpdater(Item item) {
        Updater updater = null;
        if (item.name.equals(ItemName.BACKSTAGE)) {
            updater = new BackstageUpdater();
        }
        else if (item.name.equals(ItemName.AGED_BRIE)) {
            updater = new AgedBrieUpdater();
        }
        else if (item.name.equals(ItemName.DEXTERITY)) {
            updater = new DexterityUpdater();
        }
        else if (item.name.equals(ItemName.ELIXIR)) {
            updater = new ElixirUpdater();
        }
        else if (item.name.equals(ItemName.CONJURED)) {
            updater = new ConjureUpdater();
        }
        else if (item.name.equals(ItemName.SULFURAS)) {
            updater = new SulfurasUpdater();
        }
        return updater;
    }

    public abstract void update(Item item);

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
