package com.gildedrose

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class AgedBrieStrategyTest {
    private val name = "test Aged Brie"

    @Test
    fun `it should decrease sellIn and increase quality`() {
        val item = Item(name, sellIn = 5, quality = 5)
        AgedBrieStrategy.setSellInAndQuality(item)
        assertThat(item.quality, equalTo(6))
        assertThat(item.sellIn, equalTo(4))
    }

    @Test
    fun `quality cannot be more than 50`() {
        val item = Item(name, sellIn = 5, quality = 50)
        AgedBrieStrategy.setSellInAndQuality(item)
        assertThat(item.quality, equalTo(50))
    }
}