package com.gildedrose

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class BackStageStrategyTest {
    private val name = "test Backstage strategy"

    @Test
    fun `it should decrease sellIn and increase quality`() {
        val item = Item(name, sellIn = 12, quality = 20)
        BackStageStrategy.setSellInAndQuality(item)
        assertThat(item.sellIn, equalTo(11))
        assertThat(item.quality, equalTo(21))
    }

    @Test
    fun `it should increase quality with 2 when sellIn days more than 5 and less than or equal 10`() {
        val item1 = Item(name, sellIn = 11, quality = 10)
        BackStageStrategy.setSellInAndQuality(item1)
        assertThat(item1.quality, equalTo(12))

        val item2 = Item(name, sellIn = 7, quality = 10)
        BackStageStrategy.setSellInAndQuality(item2)
        assertThat(item2.quality, equalTo(12))
    }

    @Test
    fun `it should increase quality with 3 when sellIn days more than 0 and less than or equal 5`() {
        val item1 = Item(name, sellIn = 6, quality = 10)
        BackStageStrategy.setSellInAndQuality(item1)
        assertThat(item1.quality, equalTo(13))

        val item2 = Item(name, sellIn = 1, quality = 10)
        BackStageStrategy.setSellInAndQuality(item2)
        assertThat(item2.quality, equalTo(13))
    }

    @Test
    fun `it should set quality to zero after the concert`() {
        val item = Item(name, sellIn = 0, quality = 10)
        BackStageStrategy.setSellInAndQuality(item)
        assertThat(item.quality, equalTo(0))
    }

    @Test
    fun `quality cannot be more than 50`() {
        val item = Item(name, sellIn = 5, quality = 50)
        BackStageStrategy.setSellInAndQuality(item)
        assertThat(item.quality, equalTo(50))
    }
}