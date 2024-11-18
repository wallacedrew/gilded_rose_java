package com.gildedrose;

import com.gildedrose.updater.*;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            Updater updater = createUpdater(item);
            updater.update(item);
        }
    }

    private static Updater createUpdater(Item item) {
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

}
