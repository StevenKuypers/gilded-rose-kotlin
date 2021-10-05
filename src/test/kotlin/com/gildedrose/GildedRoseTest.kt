package com.gildedrose

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `it should update values`() {
        val initialSellIn = 1
        val item1 = Item("A", initialSellIn, 1)
        val item2 = Item("B", initialSellIn, 1)
        val items = listOf(item1, item2)
        GildedRose(items).updateValues()

        assertThat(items.first().sellIn, equalTo(initialSellIn.minus(1)))
        assertThat(items.last().sellIn, equalTo(initialSellIn.minus(1)))
    }
}