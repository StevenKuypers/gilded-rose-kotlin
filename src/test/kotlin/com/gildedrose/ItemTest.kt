package com.gildedrose

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class ItemTest {

    @Test
    fun `test toString()`() {
        val item = Item("a name", 1, 2)
        assertThat(item.toString(), equalTo("a name, 1, 2"))
    }
}