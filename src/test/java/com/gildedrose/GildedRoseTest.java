package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_updateAgedBrie() {
        Item originalItem = new Item("Aged Brie", 2, 0);
        Item expectedItem = expectedUpdate(originalItem.name, 1, 1);
        GildedRose app = setupGildedRose(originalItem);

        app.updateQuality();

        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    @Test
    void updateQuality_updateDexterity() {
        Item originalItem = new Item("+5 Dexterity Vest", 10, 20);
        Item expectedItem = expectedUpdate(originalItem.name, 9, 19);
        GildedRose app = setupGildedRose(originalItem);

        app.updateQuality();

        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    @Test
    void updateQuality_updateElixir() {
        Item originalItem = new Item("Elixir of the Mongoose", 5, 7);
        Item expectedItem = expectedUpdate(originalItem.name, 4, 6);
        GildedRose app = setupGildedRose(originalItem);

        app.updateQuality();

        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    @Test
    void updateQuality_updateSulfuras() {
        Item originalItem = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Item expectedItem = expectedUpdate(originalItem.name, -1, 80);
        GildedRose app = setupGildedRose(originalItem);

        app.updateQuality();

        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    @Test
    void updateQuality_updateBackstage() {
        Item originalItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Item expectedItem = expectedUpdate(originalItem.name, 4, 50);
        GildedRose app = setupGildedRose(originalItem);

        app.updateQuality();

        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    private static Item expectedUpdate(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    private static GildedRose setupGildedRose(Item item) {
        Item[] items = new Item[]{new Item(item.name, item.sellIn, item.quality)};
        GildedRose app = new GildedRose(items);
        return app;
    }

}
