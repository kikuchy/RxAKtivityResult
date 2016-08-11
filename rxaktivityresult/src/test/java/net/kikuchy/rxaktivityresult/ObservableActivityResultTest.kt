package net.kikuchy.rxaktivityresult

import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import rx.observers.TestSubscriber
import rx.subjects.PublishSubject

@RunWith(AndroidJUnit4::class)
class ObservableActivityResultTest {
    lateinit var resultPatterns: Triple<ActivityResult, ActivityResult, ActivityResult>
    lateinit var source: PublishSubject<ActivityResult>
    lateinit var subscriber: TestSubscriber<ActivityResult>

    @Before
    fun setUp() {
        resultPatterns = TestUtils.makeTestResultPatterns()
        source = PublishSubject.create<ActivityResult>()
        subscriber = TestSubscriber<ActivityResult>()
    }

    @Test
    fun testFilterResultOk() {
        source.
                isOk().
                subscribe(subscriber)

        val (ok, fail1, fail2) = resultPatterns
        source.apply {
            onNext(ok)
            onNext(fail1)
            onNext(fail2)
        }

        subscriber.assertValueCount(1)
        subscriber.assertValue(ok)
    }

    @Test
    fun testCanceledCallsOnError() {
        source.
                assertNotCanceled().
                subscribe(subscriber)

        val (ok1, fail, ok2) = resultPatterns
        source.apply {
            onNext(ok1)
            onNext(ok2)
        }

        subscriber.assertNoErrors()

        source.onNext(fail)

        subscriber.assertError(ActivityCanceledException::class.java)
    }

    @Test
    fun testFilterRequestCode() {
        val (ok, fail1, fail2) = TestUtils.makeTestRequestPatterns()

        source.
                isRequestOf(ok.requestCode).
                subscribe(subscriber)
        source.apply {
            onNext(ok)
            onNext(fail1)
            onNext(fail2)
        }

        subscriber.assertValueCount(1)
        subscriber.assertValue(ok)
    }
}