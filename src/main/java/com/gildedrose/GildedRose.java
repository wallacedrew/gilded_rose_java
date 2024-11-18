package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (!item.name.equals(ItemName.AGED_BRIE)) {
                if (!item.name.equals(ItemName.BACKSTAGE)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(ItemName.SULFURAS)) {
                            item.quality = item.quality - 1;
                        }
                    }
                }
            }

            if (item.name.equals(ItemName.AGED_BRIE)) {

                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(ItemName.BACKSTAGE)) {
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
            }

            if (item.name.equals(ItemName.BACKSTAGE)) {

                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(ItemName.BACKSTAGE)) {
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
            }

            if (!item.name.equals(ItemName.SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {

                if (!item.name.equals(ItemName.AGED_BRIE)) {
                    if (!item.name.equals(ItemName.BACKSTAGE)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(ItemName.SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                    if (item.name.equals(ItemName.BACKSTAGE)) {
                        item.quality = item.quality - item.quality;
                    }
                }

                if (item.name.equals(ItemName.AGED_BRIE)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
