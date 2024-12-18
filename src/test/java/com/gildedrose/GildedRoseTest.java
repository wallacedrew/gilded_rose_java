package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_updateAgedBrie() {
        Item originalItem = new Item(ItemName.AGED_BRIE, 2, 0);
        Item expectedItem = expectedUpdate(originalItem.name, 1, 1);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateDexterity() {
        Item originalItem = new Item(ItemName.DEXTERITY, 10, 20);
        Item expectedItem = expectedUpdate(originalItem.name, 9, 19);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateElixir() {
        Item originalItem = new Item(ItemName.ELIXIR, 5, 7);
        Item expectedItem = expectedUpdate(originalItem.name, 4, 6);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateSulfuras() {
        Item originalItem = new Item(ItemName.SULFURAS, -1, 80);
        Item expectedItem = expectedUpdate(originalItem.name, -1, 80);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateBackstage() {
        Item originalItem = new Item(ItemName.BACKSTAGE, 5, 49);
        Item expectedItem = expectedUpdate(originalItem.name, 4, 50);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateConjured() {
        Item originalItem = new Item(ItemName.CONJURED, 3, 6);
        Item expectedItem = expectedUpdate(originalItem.name, 2, 4);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateConjured_for_four_days() {
        Item originalItem = new Item(ItemName.CONJURED, 3, 6);
        Item expectedItem = expectedUpdate(originalItem.name, -1, 0);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_conjured_quality_degrades_twice_as_fast_once_expired() {
        Item originalItem = new Item(ItemName.CONJURED, -1, 8);
        Item expectedItem = expectedUpdate(originalItem.name, -2, 4);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_conjured_quality_not_negative() {
        Item originalItem = new Item(ItemName.CONJURED, 0, 1);
        Item expectedItem = expectedUpdate(originalItem.name, -4, 0);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateAgedBrie_for_four_days() {
        Item originalItem = new Item(ItemName.AGED_BRIE, 2, 0);
        Item expectedItem = expectedUpdate(originalItem.name, -2, 6);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateAgedBrie_for_four_days_upgrades_with_age() {
        Item originalItem = new Item(ItemName.AGED_BRIE, -1, 6);
        Item expectedItem = expectedUpdate(originalItem.name, -2, 8);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateDexterity_for_four_days() {
        Item originalItem = new Item(ItemName.DEXTERITY, 10, 20);
        Item expectedItem = expectedUpdate(originalItem.name, 6, 16);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateElixir_for_four_days() {
        Item originalItem = new Item(ItemName.ELIXIR, 5, 7);
        Item expectedItem = expectedUpdate(originalItem.name, 1, 3);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateSulfuras_for_four_days() {
        Item originalItem = new Item(ItemName.SULFURAS, -1, 80);
        Item expectedItem = expectedUpdate(originalItem.name, -1, 80);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateBackstage_for_four_days() {
        Item originalItem = new Item(ItemName.BACKSTAGE, 5, 49);
        Item expectedItem = expectedUpdate(originalItem.name, 1, 50);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_updateBackstage_upgrades_with_age() {
        Item originalItem = new Item(ItemName.BACKSTAGE, -1, 6);
        Item expectedItem = expectedUpdate(originalItem.name, -2, 0);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_backstage_lo_grade_for_four_days() {
        Item originalItem = new Item(ItemName.BACKSTAGE, 1, 1);
        Item expectedItem = expectedUpdate(originalItem.name, -3, 0);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_backstage_upgrades_by_2_when_10_days_or_less() {
        Item originalItem = new Item(ItemName.BACKSTAGE, 10, 1);
        Item expectedItem = expectedUpdate(originalItem.name, 6, 9);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_backstage_upgrades_by_3_when_5_days_or_less() {
        Item originalItem = new Item(ItemName.BACKSTAGE, 5, 1);
        Item expectedItem = expectedUpdate(originalItem.name, 1, 13);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_backstage_degrades_to_zero_after_concert() {
        Item originalItem = new Item(ItemName.BACKSTAGE, -1, 1);
        Item expectedItem = expectedUpdate(originalItem.name, -5, 0);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_elixir_quality_degrades_twice_as_fast_once_expired() {
        Item originalItem = new Item(ItemName.ELIXIR, -1, 8);
        Item expectedItem = expectedUpdate(originalItem.name, -2, 6);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_dexterity_quality_degrades_twice_as_fast_once_expired() {
        Item originalItem = new Item(ItemName.DEXTERITY, -1, 8);
        Item expectedItem = expectedUpdate(originalItem.name, -2, 6);
        validate(expectedItem, originalItem);
    }

    @Test
    void updateQuality_elixir_quality_not_negative() {
        Item originalItem = new Item(ItemName.ELIXIR, 0, 1);
        Item expectedItem = expectedUpdate(originalItem.name, -4, 0);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_dexterity_quality_not_negative() {
        Item originalItem = new Item(ItemName.DEXTERITY, 0, 1);
        Item expectedItem = expectedUpdate(originalItem.name, -4, 0);
        validateMultiple(expectedItem, originalItem);
    }

    @Test
    void updateQuality_sulfuras_is_never_sells_or_degrades() {
        Item originalItem = new Item(ItemName.SULFURAS, 7, 7);
        Item expectedItem = expectedUpdate(originalItem.name, 7, 7);
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