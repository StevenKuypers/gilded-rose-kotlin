package com.gildedrose

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class SulfurasStrategyTest {
    @Test
    fun `it should set quality to 80 and decrease sellIn`() {
        val item = Item("Sulfuras, Hand of Ragnaros", sellIn = 0, quality = 80)
        SulfurasStrategy.updateValues(item)
        assertThat(item.quality, equalTo(80))
        assertThat(item.sellIn, equalTo(-1))
    }
}