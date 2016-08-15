package net.kikuchy.rxaktivityresult

import android.app.Activity
import android.content.Intent
import rx.Observable

/**
 * Result of another Activity.
 */
data class ActivityResult(val requestCode: Int, val resultCode: Int, val data: Intent?) {
    val isOk: Boolean
        get() = resultCode == Activity.RESULT_OK

    fun assertNotCanceled() {
        if (resultCode == Activity.RESULT_CANCELED)
            throw ActivityCanceledException(requestCode)
    }
}

/**
 * Filter [ActivityResult] that resultCode equals RESULT_OK.
 */
fun Observable<ActivityResult>.isOk() =
        this.filter { it.isOk }

/**
 * Rise [ActivityCanceledException] if Activity's result is RESULT_CANCELED or do nothing.
 */
fun Observable<ActivityResult>.assertNotCanceled() =
        this.doOnNext { it.assertNotCanceled() }

/**
 * Filter [ActivityResult] that requestCode equals given one.
 *
 * @param requestCode request code that used for [Activity.startActivityForResult]
 */
fun Observable<ActivityResult>.isRequestOf(requestCode: Int) =
        this.filter { it.requestCode == requestCode }