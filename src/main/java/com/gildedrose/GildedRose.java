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
                updateBackstage(item);
            }
            else if (item.name.equals(ItemName.AGED_BRIE)) {
                updateAgedBrie(item);
            }
            else if (item.name.equals(ItemName.DEXTERITY)) {
                updateItem(item);
            }
            else if (item.name.equals(ItemName.ELIXIR)) {
                updateItem(item);
            }
            else if (item.name.equals(ItemName.CONJURED)) {
                updateItem(item);
            }
            else if (item.name.equals(ItemName.SULFURAS)) {
                updateSulfuras(item);
            }
        }
    }

    private static void updateAgedBrie(Item item) {
        age(item);
        upgrade(item);
        if (hasExpired(item)) upgrade(item);
    }

    private static void updateBackstage(Item item) {
        upgrade(item);
        if (qualityNotMaxed(item)) {
            if (item.sellIn < 11) upgrade(item);
            if (item.sellIn < 6) upgrade(item);
        }
        if (hasExpired(item)) item.quality = 0;
        age(item);
    }

    private static void updateItem(Item item) {
        age(item);
        degrade(item);
        if (hasExpired(item)) degrade(item);
    }

    private static void updateSulfuras(Item item) {
    }

    private static boolean qualityNotMaxed(Item item) {
        return item.quality < 50;
    }

    private static boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private static void age(Item item) {
        item.sellIn--;
    }

    private static void upgrade(Item item) {
        if (qualityNotMaxed(item)) item.quality++;
    }

    private static void degrade(Item item) {
        if (item.quality > 0) item.quality--;
    }
}
