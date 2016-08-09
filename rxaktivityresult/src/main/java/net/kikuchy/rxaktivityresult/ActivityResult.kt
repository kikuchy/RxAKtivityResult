package net.kikuchy.rxaktivityresult

import android.app.Activity
import android.content.Intent
import rx.Observable

/**
 * Result of another Activity.
 */
data class ActivityResult(val requestCode: Int, val resultCode: Int, val data: Intent)

/**
 * Filter [ActivityResult] that resultCode equals RESULT_OK.
 */
fun Observable<ActivityResult>.isOk() = this.filter { it.resultCode == Activity.RESULT_OK }

/**
 * Filter [ActivityResult] that requestCode equals given one.
 *
 * @param requestCode request code that used for [Activity.startActivityForResult]
 */
fun Observable<ActivityResult>.isRequestOf(requestCode: Int) = this.filter { it.requestCode == requestCode }