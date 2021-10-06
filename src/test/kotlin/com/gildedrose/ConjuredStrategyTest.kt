package com.gildedrose

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class ConjuredStrategyTest {
    private val name = "test Conjured strategy"

    @Test
    fun `it should decrease quality by 2 and decrease sellIn`() {
        val item = Item(name, sellIn = 1, quality = 5)
        ConjuredStrategy.updateValues(item)
        assertThat(item.quality, equalTo(3))
        assertThat(item.sellIn, equalTo(0))
    }

    @Test
    fun `it should decrease quality by 4 when sellIn less than zero`() {
        val item = Item(name, sellIn = 0, quality = 5)
        ConjuredStrategy.updateValues(item)
        assertThat(item.quality, equalTo(1))
    }

    @Test
    fun `it should not decrease quality when at zero`() {
        val item = Item(name, sellIn = 10, quality = 0)
        ConjuredStrategy.updateValues(item)
        assertThat(item.quality, equalTo(0))
    }
}