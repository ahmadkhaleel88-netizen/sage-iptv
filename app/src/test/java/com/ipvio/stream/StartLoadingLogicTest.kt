package com.ipvio.stream

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StartLoadingLogicTest {
    @Test fun coldStartWithSavedPlaylistShowsLoadingNotEmptyScreen() {
        assertTrue(AddFlowLogic.showsLoading(loading = false, everFinished = false, hasLists = true))
    }

    @Test fun afterFirstLoadAnEmptyListIsReallyEmpty() {
        assertFalse(AddFlowLogic.showsLoading(loading = false, everFinished = true, hasLists = true))
    }

    @Test fun noSavedPlaylistNeverWaits() {
        assertFalse(AddFlowLogic.showsLoading(loading = false, everFinished = false, hasLists = false))
    }

    @Test fun aRunningLoadAlwaysShowsLoading() {
        assertTrue(AddFlowLogic.showsLoading(loading = true, everFinished = true, hasLists = true))
    }

    @Test fun aFirstLoadThatNeverStartsStopsWaitingAfterTheLimit() {
        assertFalse(AddFlowLogic.showsLoading(false, false, true, AddFlowLogic.WAIT_FIRST_LOAD_MS))
        assertTrue(AddFlowLogic.showsLoading(false, false, true, AddFlowLogic.WAIT_FIRST_LOAD_MS - 1))
    }
}
