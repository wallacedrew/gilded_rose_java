package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemName;

public abstract class UpdaterFactory {

    public static Updater createUpdater(Item item) {
        Updater updater = null;
        if (item.name.equals(ItemName.BACKSTAGE)) {
            updater = new BackstageUpdater(item);
        }
        else if (item.name.equals(ItemName.AGED_BRIE)) {
            updater = new AgedBrieUpdater(item);
        }
        else if (item.name.equals(ItemName.DEXTERITY)) {
            updater = new DexterityUpdater(item);
        }
        else if (item.name.equals(ItemName.ELIXIR)) {
            updater = new ElixirUpdater(item);
        }
        else if (item.name.equals(ItemName.CONJURED)) {
            updater = new ConjureUpdater(item);
        }
        else if (item.name.equals(ItemName.SULFURAS)) {
            updater = new SulfurasUpdater(item);
        }
        return updater;
    }

}
