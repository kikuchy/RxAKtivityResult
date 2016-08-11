package net.kikuchy.rxaktivityresult

import android.app.Activity
import android.content.Intent
import android.support.test.runner.AndroidJUnit4
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ActivityResultTest {
    lateinit var resultPatterns: Triple<ActivityResult, ActivityResult, ActivityResult>

    @Before
    fun setUp() {
        resultPatterns = TestUtils.makeTestResultPatterns()
    }

    @Test
    fun isOk() {
        val (ok, fail1, fail2) = resultPatterns
        assertTrue(ok.isOk)
        assertFalse(fail1.isOk)
        assertFalse(fail2.isOk)
    }

    @Test
    fun assertNotCanceledRisesException() {
        val (ok1, fail, ok2) = resultPatterns
        ok1.assertNotCanceled()
        ok2.assertNotCanceled()
        try {
            fail.assertNotCanceled()
        } catch (e: ActivityCanceledException) {
            assertEquals(fail.requestCode, e.requestCode)
        }
    }
}