package net.kikuchy.rxaktivityresult

/**
 * Express that some Activity returns `RESULT_CANCELED` .
 */
class ActivityCanceledException(val requestCode: Int) :
        RuntimeException("Activity (Request code = $requestCode) is canceled.") {
}