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
                upgrade(item);

                if (qualityNotMaxed(item)) {
                    if (item.sellIn < 11) upgrade(item);
                    if (item.sellIn < 6) upgrade(item);
                }

                if (hasExpired(item)) item.quality = 0;
                age(item);
            }
            else if (item.name.equals(ItemName.AGED_BRIE)) {
                age(item);
                upgrade(item);
                if (hasExpired(item)) upgrade(item);
            }
            else if (item.name.equals(ItemName.DEXTERITY)) {
                age(item);
                degrade(item);
                if (hasExpired(item)) degrade(item);
            }
            else if (item.name.equals(ItemName.ELIXIR)) {
                age(item);
                degrade(item);
                if (hasExpired(item)) degrade(item);
            }
            else if (item.name.equals(ItemName.CONJURED)) {
                age(item);
                degrade(item);
                if (hasExpired(item)) degrade(item);
            }
            else if (item.name.equals(ItemName.SULFURAS)) {
            }
        }
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
