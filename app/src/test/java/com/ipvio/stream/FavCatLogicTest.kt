package com.ipvio.stream

import org.junit.Assert.assertEquals
import org.junit.Test

class FavCatLogicTest {
    @Test fun keepsFavouriteOrderAndSkipsOtherAreas() {
        val items = listOf("s1", "s2", "s3")
        assertEquals(listOf("s3", "s1"), FavCatLogic.pick(listOf("s3", "m9", "s1"), items) { it })
    }

    @Test fun noFavouritesGivesAnEmptyCategory() {
        assertEquals(emptyList<String>(), FavCatLogic.pick(emptyList(), listOf("s1")) { it })
    }
}
