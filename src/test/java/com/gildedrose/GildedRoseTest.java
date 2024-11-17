package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_returnsNameOfFirstItem() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app1 = new GildedRose(items);
        GildedRose app = app1;
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void updateQuality_updateAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose app1 = new GildedRose(items);
        GildedRose app = app1;
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void updateQuality_updateDexterity() {
        Item expectedItem = new Item("+5 Dexterity Vest", 9, 19);
        Item originalItem = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose app = setupGildedRose(originalItem);

        app.updateQuality();

        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    private static GildedRose setupGildedRose(Item item) {
        Item[] items = new Item[]{new Item(item.name, item.sellIn, item.quality)};
        GildedRose app = new GildedRose(items);
        return app;
    }

}
