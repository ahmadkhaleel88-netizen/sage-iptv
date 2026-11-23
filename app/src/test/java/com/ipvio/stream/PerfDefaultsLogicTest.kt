package com.ipvio.stream

import org.junit.Assert.assertEquals
import org.junit.Test

class PerfDefaultsLogicTest {
    @Test fun smallTvsGetNoAnimationsAndAStillBanner() {
        assertEquals(0, PerfDefaultsLogic.motion(0)); assertEquals(0, PerfDefaultsLogic.motion(1))
        assertEquals(0, PerfDefaultsLogic.heroSec(0)); assertEquals(0, PerfDefaultsLogic.heroSec(1))
    }

    @Test fun largeDevicesKeepTheOriginalDefaults() {
        assertEquals(2, PerfDefaultsLogic.motion(2))
        assertEquals(9, PerfDefaultsLogic.heroSec(2))
    }
}
