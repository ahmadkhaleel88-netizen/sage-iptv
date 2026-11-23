package com.ipvio.stream

/**
 * SageIPTV: lighter defaults for TVs with little memory (Mem tier 0 or 1, up to 3 GB).
 * Measured on a 1.8 GB Google TV (Android 11): 91 % janky frames while browsing Movies with full animations.
 * Only defaults: a value the user chose in Settings is always kept.
 */
object PerfDefaultsLogic {
    /** Animation level (Look.MOTION index): Off on small TVs, Normal otherwise. */
    fun motion(tier: Int): Int = if (tier <= 1) 0 else 2

    /** Seconds between home banner changes: 0 (no automatic change) on small TVs, 9 otherwise. */
    fun heroSec(tier: Int): Int = if (tier <= 1) 0 else 9
}
