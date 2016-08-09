package net.kikuchy.rxaktivityresult

import rx.subjects.PublishSubject
import rx.subjects.Subject

/**
 * Created by hiroshi.kikuchi on 2016/08/09.
 */
class RxAKtivityResultDelegate(): RxAKtivityResult {
    override val activityResultObservable: Subject<ActivityResult, ActivityResult> = PublishSubject.create()
}