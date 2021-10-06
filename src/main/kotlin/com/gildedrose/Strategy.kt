package com.gildedrose

interface Strategy {
    fun updateValues(item: Item) {
        item.sellIn -= 1
    }

    companion object {
        fun getStrategy(name: String): Strategy {
            with(name) {
                return when {
                    contentEquals("Aged Brie") -> AgedBrieStrategy
                    contentEquals("Sulfuras, Hand of Ragnaros") -> SulfurasStrategy
                    startsWith("Backstage passes") -> BackStageStrategy
                    startsWith("Conjured") -> ConjuredStrategy
                    else -> DefaultStrategy
                }
            }
        }
    }
}

object AgedBrieStrategy : Strategy {
    override fun updateValues(item: Item) {
        super.updateValues(item)
        item.quality = increaseQuality(item, ALTERATION)
    }
}

object BackStageStrategy : Strategy {
    override fun updateValues(item: Item) {
        super.updateValues(item)
        when {
            item.sellIn > 10 -> item.quality = increaseQuality(item, ALTERATION)
            item.sellIn in 6..10 -> item.quality = increaseQuality(item, ALTERATION * 2)
            item.sellIn in 0..5 -> item.quality = increaseQuality(item, ALTERATION * 3)
            else -> item.quality = 0
        }
    }
}

object SulfurasStrategy : Strategy {
    override fun updateValues(item: Item) {
        super.updateValues(item)
        item.quality = 80
    }
}

object ConjuredStrategy : Strategy {
    override fun updateValues(item: Item) {
        super.updateValues(item)
        val qualityDrop = if (item.sellIn < 0) EXTRA_ALTERATION * 2 else ALTERATION  * 2
        item.quality = decreaseQuality(item, qualityDrop)
    }
}

object DefaultStrategy : Strategy {
    override fun updateValues(item: Item) {
        super.updateValues(item)
        val qualityDrop = if (item.sellIn < 0) EXTRA_ALTERATION else ALTERATION
        item.quality = decreaseQuality(item, qualityDrop)
    }
}

private fun decreaseQuality(item: Item, qualityDecrease: Int) =
    maxOf(item.quality.minus(qualityDecrease), MINIMUM_QUALITY)

private fun increaseQuality(item: Item, qualityIncrease: Int) =
    minOf(item.quality.plus(qualityIncrease), MAXIMUM_QUALITY)

private const val MAXIMUM_QUALITY = 50
private const val MINIMUM_QUALITY = 0
private const val ALTERATION = 1
private const val EXTRA_ALTERATION = ALTERATION * 2