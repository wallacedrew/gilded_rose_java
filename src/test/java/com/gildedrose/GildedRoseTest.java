package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_updateAgedBrie() {
        Item originalItem = new Item("Aged Brie", 2, 0);
        Item expectedItem = expectedUpdate(originalItem.name, 1, 1);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateDexterity() {
        Item originalItem = new Item("+5 Dexterity Vest", 10, 20);
        Item expectedItem = expectedUpdate(originalItem.name, 9, 19);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateElixir() {
        Item originalItem = new Item("Elixir of the Mongoose", 5, 7);
        Item expectedItem = expectedUpdate(originalItem.name, 4, 6);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateSulfuras() {
        Item originalItem = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Item expectedItem = expectedUpdate(originalItem.name, -1, 80);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateBackstage() {
        Item originalItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Item expectedItem = expectedUpdate(originalItem.name, 4, 50);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateConjured() {
        Item originalItem = new Item("Conjured Mana Cake", 3, 6);
        Item expectedItem = expectedUpdate(originalItem.name, 2, 5);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateAgedBrie_for_four_days() {
        Item originalItem = new Item("Aged Brie", 2, 0);
        Item expectedItem = expectedUpdate(originalItem.name, -2, 4);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateDexterity_for_four_days() {
        Item originalItem = new Item("+5 Dexterity Vest", 10, 20);
        Item expectedItem = expectedUpdate(originalItem.name, 6, 16);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateElixir_for_four_days() {
        Item originalItem = new Item("Elixir of the Mongoose", 5, 7);
        Item expectedItem = expectedUpdate(originalItem.name, 1, 3);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateSulfuras_for_four_days() {
        Item originalItem = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Item expectedItem = expectedUpdate(originalItem.name, -1, 80);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateBackstage_for_four_days() {
        Item originalItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Item expectedItem = expectedUpdate(originalItem.name, 1, 50);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateBackstage_lo_grade_for_four_days() {
        Item originalItem = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1);
        Item expectedItem = expectedUpdate(originalItem.name, -3, 13);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateConjured_for_four_days() {
        Item originalItem = new Item("Conjured Mana Cake", 3, 6);
        Item expectedItem = expectedUpdate(originalItem.name, -1, 2);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_quality_degrades_twice_as_fast_once_expired() {
        Item originalItem = new Item("Conjured Mana Cake", -1, 6);
        Item expectedItem = expectedUpdate(originalItem.name, -2, 4);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_quality_not_negative() {
        Item originalItem = new Item("Conjured Mana Cake", -1, 6);
        Item expectedItem = expectedUpdate(originalItem.name, -5, 0);
        validateMultiple(expectedItem, originalItem);
    }

    private static void validate(Item expectedItem, Item originalItem) {
        GildedRose app = setupGildedRose(originalItem);
        app.updateQuality();
        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    private static void validateMultiple(Item expectedItem, Item originalItem) {
        GildedRose app = setupGildedRose(originalItem);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    private static Item expectedUpdate(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    private static GildedRose setupGildedRose(Item item) {
        Item[] items = new Item[]{new Item(item.name, item.sellIn, item.quality)};
        return new GildedRose(items);
    }

}
