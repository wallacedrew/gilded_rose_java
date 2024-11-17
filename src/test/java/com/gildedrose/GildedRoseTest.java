package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_returnsNameOfFirstItem() {
        GildedRose app = createGildedRose("foo", 0, 0);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void updateQuality_updateAgedBrie() {
        GildedRose app = createGildedRose("Aged Brie", 2, 0);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void updateQuality_updateDexterity() {
        Item expectedItem = new Item("+5 Dexterity Vest", 9, 19);

        GildedRose app = createGildedRose("+5 Dexterity Vest", 10, 20);
        app.updateQuality();

        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    private static GildedRose createGildedRose(String foo, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(foo, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        return app;
    }

}
