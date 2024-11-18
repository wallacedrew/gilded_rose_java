package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (item.name.equals(ItemName.BACKSTAGE)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    if (item.sellIn < 11) upgrade(item);
                    if (item.sellIn < 6) upgrade(item);
                }

                if (item.sellIn < 0) {
                    item.quality = item.quality - item.quality;
                }
                item.sellIn = item.sellIn - 1;
            }
            else if (item.name.equals(ItemName.AGED_BRIE)) {
                item.sellIn = item.sellIn - 1;
                upgrade(item);
                if (item.sellIn < 0) upgrade(item);
            }
            else if (item.name.equals(ItemName.DEXTERITY)) {
                item.sellIn = item.sellIn - 1;
                degrade(item);
                if (item.sellIn < 0) degrade(item);
            }
            else if (item.name.equals(ItemName.ELIXIR)) {
                item.sellIn = item.sellIn - 1;
                degrade(item);
                if (item.sellIn < 0) degrade(item);
            }
            else if (item.name.equals(ItemName.CONJURED)) {
                item.sellIn = item.sellIn - 1;
                degrade(item);
                if (item.sellIn < 0) degrade(item);
            }
            else if (item.name.equals(ItemName.SULFURAS)) {
            }
        }
    }

    private static void upgrade(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static void degrade(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
