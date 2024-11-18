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
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.name.equals(ItemName.BACKSTAGE)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

            if (item.name.equals(ItemName.DEXTERITY)) {
                updateItems(item);
            }

            if (item.name.equals(ItemName.ELIXIR)) {
                updateItems(item);
            }

            if (item.name.equals(ItemName.CONJURED)) {
                updateItems(item);
            }

            if (!item.name.equals(ItemName.SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

        }
    }

    private static void updateItems(Item item) {
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
