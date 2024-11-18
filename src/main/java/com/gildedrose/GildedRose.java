package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (item.name.equals(ItemName.AGED_BRIE)) {
                upgrade(item);
                item.sellIn--;
            }

            if (item.name.equals(ItemName.BACKSTAGE)) {
                upgrade(item);

                if (item.quality < 50) {
                    if (item.sellIn < 11) {
                        upgrade(item);
                    }

                    if (item.sellIn < 6) {
                        upgrade(item);
                    }
                }
                item.sellIn--;
            }

            if (item.name.equals(ItemName.DEXTERITY)) {
                updateItems(item);
                item.sellIn--;
            }

            if (item.name.equals(ItemName.ELIXIR)) {
                updateItems(item);
                item.sellIn--;
            }

            if (item.name.equals(ItemName.CONJURED)) {
                updateItems(item);
                item.sellIn--;
            }

            if (item.name.equals(ItemName.SULFURAS)) {
            }
        }
    }

    private static void updateItems(Item item) {
        if (item.sellIn < 0) {
            degrade(item);
        }
        degrade(item);
    }

    private static void upgrade(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private static void degrade(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
