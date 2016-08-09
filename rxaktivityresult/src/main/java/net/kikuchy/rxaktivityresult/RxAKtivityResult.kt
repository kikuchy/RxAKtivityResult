package net.kikuchy.rxaktivityresult

import android.content.Intent
import rx.subjects.Subject

/**
 * Give ability to handle another Activity's result as rx.Observable stream for Activity/Fragment.
 */
interface RxAKtivityResult {
    /**
     * This Subject fire event when Activity's result arrives.
     */
    val activityResultObservable: Subject<ActivityResult, ActivityResult>

    /**
     * Call this method from implement class's same name method.
     */
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        activityResultObservable.onNext(ActivityResult(requestCode, resultCode, data))
    }
}