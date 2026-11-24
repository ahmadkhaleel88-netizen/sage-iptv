package com.ipvio.stream

/**
 * SageIPTV: request TMDB images in the size a TV card needs, whatever size the link asks for.
 * Provider playlists often link posters as "original" (several MB each). Decoding those on a small TV
 * stalls the screen when a category fills with posters.
 */
object ImageSizeLogic {
    private val TMDB_SIZE = Regex("(image\\.tmdb\\.org/t/p/)(original|w\\d{3,4})/")

    /** Poster for a card: w342. Links that are not TMDB stay as they are. */
    fun poster(url: String): String = TMDB_SIZE.replace(url) { it.groupValues[1] + "w342/" }

    /** Wide scene image for a card: w780. */
    fun backdrop(url: String): String = TMDB_SIZE.replace(url) { it.groupValues[1] + "w780/" }

    /** Faint background of a category tile: w300 is enough under its dark gradient. */
    fun tileBackdrop(url: String): String = TMDB_SIZE.replace(url) { it.groupValues[1] + "w300/" }
}
