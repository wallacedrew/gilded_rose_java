package com.gildedrose;

import com.gildedrose.updater.Updater;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (item.name.equals(ItemName.BACKSTAGE)) {
                new Updater().updateBackstage(item);
            }
            else if (item.name.equals(ItemName.AGED_BRIE)) {
                new Updater().updateAgedBrie(item);
            }
            else if (item.name.equals(ItemName.DEXTERITY)) {
                new Updater().updateItem(item);
            }
            else if (item.name.equals(ItemName.ELIXIR)) {
                new Updater().updateItem(item);
            }
            else if (item.name.equals(ItemName.CONJURED)) {
                new Updater().updateItem(item);
            }
            else if (item.name.equals(ItemName.SULFURAS)) {
                new Updater().updateSulfuras(item);
            }
        }
    }

}
