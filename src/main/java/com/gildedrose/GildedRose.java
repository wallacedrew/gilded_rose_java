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

            if (item.name.equals(ItemName.BACKSTAGE)) {
                new BackstageUpdater().update(item);
            }
            else if (item.name.equals(ItemName.AGED_BRIE)) {
                new AgedBrieUpdater().update(item);
            }
            else if (item.name.equals(ItemName.DEXTERITY)) {
                new DexterityUpdater().update(item);
            }
            else if (item.name.equals(ItemName.ELIXIR)) {
                new ElixirUpdater().update(item);
            }
            else if (item.name.equals(ItemName.CONJURED)) {
                new ConjureUpdater().update(item);
            }
            else if (item.name.equals(ItemName.SULFURAS)) {
                new SulfurasUpdater().update(item);
            }
        }
    }

}
