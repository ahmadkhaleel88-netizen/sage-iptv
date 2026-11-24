package com.ipvio.stream

/** SageIPTV: the favourites category of Movies or Series, in the order of the favourites list (newest first). */
object FavCatLogic {
    fun <T> pick(favIds: List<String>, items: List<T>, id: (T) -> String): List<T> {
        val byId = HashMap<String, T>(items.size * 2)
        for (i in items) byId.putIfAbsent(id(i), i)
        return favIds.mapNotNull { byId[it] }
    }
}
