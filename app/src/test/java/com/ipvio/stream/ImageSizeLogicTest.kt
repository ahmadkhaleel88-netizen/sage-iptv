package com.ipvio.stream

import org.junit.Assert.assertEquals
import org.junit.Test

class ImageSizeLogicTest {
    private val base = "https://image.tmdb.org/t/p/"

    @Test fun originalAndLargePostersBecomeCardSize() {
        assertEquals(base + "w342/a.jpg", ImageSizeLogic.poster(base + "original/a.jpg"))
        assertEquals(base + "w342/a.jpg", ImageSizeLogic.poster(base + "w500/a.jpg"))
        assertEquals(base + "w342/a.jpg", ImageSizeLogic.poster(base + "w1280/a.jpg"))
    }

    @Test fun backdropsBecomeCardAndTileSizes() {
        assertEquals(base + "w780/b.jpg", ImageSizeLogic.backdrop(base + "original/b.jpg"))
        assertEquals(base + "w300/b.jpg", ImageSizeLogic.tileBackdrop(base + "w1280/b.jpg"))
    }

    @Test fun otherLinksStayUntouched() {
        val u = "http://provider.example/images/12345.jpg"
        assertEquals(u, ImageSizeLogic.poster(u))
        assertEquals(u, ImageSizeLogic.backdrop(u))
    }
}
