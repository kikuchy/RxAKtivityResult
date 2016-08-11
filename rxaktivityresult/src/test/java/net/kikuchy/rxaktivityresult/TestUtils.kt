package net.kikuchy.rxaktivityresult

import android.app.Activity
import android.content.Intent

object TestUtils {
    fun makeTestResultPatterns() =
            Triple(
                    ActivityResult(1234, Activity.RESULT_OK, Intent()),
                    ActivityResult(1234, Activity.RESULT_CANCELED, Intent()),
                    ActivityResult(1234, Activity.RESULT_FIRST_USER, Intent())
            )

    fun makeTestRequestPatterns() =
            Triple(
                    ActivityResult(1234, Activity.RESULT_OK, Intent()),
                    ActivityResult(5678, Activity.RESULT_OK, Intent()),
                    ActivityResult(9012, Activity.RESULT_OK, Intent())
            )
}