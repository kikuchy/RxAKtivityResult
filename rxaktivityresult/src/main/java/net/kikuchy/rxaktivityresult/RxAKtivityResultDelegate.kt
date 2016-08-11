package net.kikuchy.rxaktivityresult

import rx.subjects.PublishSubject
import rx.subjects.Subject

/**
 * Default [RxAKtivityResult] implementation.
 */
class RxAKtivityResultDelegate(): RxAKtivityResult {
    override val activityResultObservable: Subject<ActivityResult, ActivityResult> = PublishSubject.create()
}