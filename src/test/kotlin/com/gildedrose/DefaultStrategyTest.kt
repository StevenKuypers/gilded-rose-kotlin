package com.gildedrose

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class DefaultStrategyTest {
    private val name = "test Default strategy"

    @Test
    fun `it should decrease sellIn and decrease quality`() {
        val item = Item(name, sellIn = 1, quality = 5)
        DefaultStrategy.setSellInAndQuality(item)
        assertThat(item.quality, equalTo(4))
        assertThat(item.sellIn, equalTo(0))
    }

    @Test
    fun `it should decrease quality by 2 when sellIn less than zero`() {
        val item = Item(name, sellIn = 0, quality = 5)
        DefaultStrategy.setSellInAndQuality(item)
        assertThat(item.quality, equalTo(3))
    }

    @Test
    fun `it should not decrease quality when at zero`() {
        val item = Item(name, sellIn = -2, quality = 0)
        DefaultStrategy.setSellInAndQuality(item)
        assertThat(item.quality, equalTo(0))
    }
}