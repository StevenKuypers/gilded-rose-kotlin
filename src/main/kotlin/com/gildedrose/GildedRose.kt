package com.gildedrose

import com.gildedrose.Strategy.Companion.getStrategy

class GildedRose(
    private val items: List<Item>) {

    fun updateValues() {
        items.forEach {
            getStrategy(it.name).updateValues(it)
        }
    }
}