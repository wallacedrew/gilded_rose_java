package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemName;

public class UpdaterFactory {

    public static Updater createUpdater(Item item) {
        if (item.name.equals(ItemName.BACKSTAGE)) {
            return new BackstageUpdater(item);
        }
        else if (item.name.equals(ItemName.AGED_BRIE)) {
            return new AgedBrieUpdater(item);
        }
        else if (item.name.equals(ItemName.DEXTERITY)) {
            return new DexterityUpdater(item);
        }
        else if (item.name.equals(ItemName.ELIXIR)) {
            return new ElixirUpdater(item);
        }
        else if (item.name.equals(ItemName.CONJURED)) {
            return new ConjureUpdater(item);
        }
        else if (item.name.equals(ItemName.SULFURAS)) {
            return new SulfurasUpdater(item);
        }
        else {
            throw new RuntimeException("unknown item name");
        }
    }

}
