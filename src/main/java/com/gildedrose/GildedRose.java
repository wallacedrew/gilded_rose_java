package com.gildedrose;

import com.gildedrose.updater.*;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::update);
    }

    private void update(Item item) {
        UpdaterFactory.createUpdater(item).update();
    }
}
