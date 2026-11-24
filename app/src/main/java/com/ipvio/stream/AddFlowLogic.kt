package com.ipvio.stream

/**
 * Rules around the add-playlist screen and the empty list state (without Android, testable).
 */
object AddFlowLogic {
    /** SageIPTV: the home shows its loading skeleton (not "No channels yet") while a load runs, or before the first
     *  load since app start has ended when a playlist is saved. */
    fun showsLoading(loading: Boolean, everFinished: Boolean, hasLists: Boolean): Boolean =
        loading || (!everFinished && hasLists)

    /**
     * Closing the add screen reloads the saved playlist only if nothing was ever shown (e.g. a resumed add was cancelled).
     * A list that is empty only because of the playlist mode (Live only / VOD only) must not trigger a reload.
     */
    fun shouldReloadAfterAddClosed(wasAdding: Boolean, adding: Boolean, channelsEmpty: Boolean, loading: Boolean, hasShownList: Boolean): Boolean =
        wasAdding && !adding && channelsEmpty && !loading && !hasShownList

    /** The settings tab keeps showing the settings (instead of the empty-list screen) as long as playlists exist. */
    fun keepsSettingsPage(tab: Int, hasPlaylists: Boolean): Boolean = tab == MenuLogic.SETTINGS && hasPlaylists
}
