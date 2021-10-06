package com.gildedrose

import com.gildedrose.Strategy.Companion.getStrategy
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class StrategyTest {
    @Test
    fun `it should choose the correct strategy`() {
        assertThat(getStrategy("Aged Brie"), equalTo(AgedBrieStrategy))
        assertThat(getStrategy("Backstage passes ...whatever"), equalTo(BackStageStrategy))
        assertThat(getStrategy("Sulfuras, Hand of Ragnaros"), equalTo(SulfurasStrategy))
        assertThat(getStrategy("Conjured ...whatever"), equalTo(ConjuredStrategy))
        assertThat(getStrategy("Whatever"), equalTo(DefaultStrategy))
        assertThat(getStrategy("There is something about Aged Brie"), equalTo(DefaultStrategy))
        assertThat(getStrategy("There is something about Sulfuras, Hand of Ragnaros"), equalTo(DefaultStrategy))
    }
}