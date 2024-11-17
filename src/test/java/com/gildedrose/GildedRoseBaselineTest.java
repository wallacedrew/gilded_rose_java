package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseBaselineTest {

    String expectedResult = "OMGHAI!\n" +
            "-------- day 0 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 10, 20\n" +
            "Aged Brie, 2, 0\n" +
            "Elixir of the Mongoose, 5, 7\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
            "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
            "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
            "Conjured Mana Cake, 3, 6\n" +
            "\n" +
            "-------- day 1 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 9, 19\n" +
            "Aged Brie, 1, 1\n" +
            "Elixir of the Mongoose, 4, 6\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
            "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
            "Conjured Mana Cake, 2, 5\n\n";

    @Test
    public void run_store_for_two_days() {
        String[] args = new String[]{};
        assertEquals(expectedResult, TexttestFixture.runGildedRose(args));
    }

}
