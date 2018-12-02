package eu.marcocattaneo.testappmockk

import eu.marcocattaneo.testappmockk.ui.main.Input
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe

class SampleUseCase(val ioScheduler: Scheduler, val uiSchedulers: Scheduler) {

    fun execute(params: Input) : Single<String> {
        return Single.create(SingleOnSubscribe<String> {

            it.onSuccess("ok")

        }).subscribeOn(this.ioScheduler).observeOn(this.uiSchedulers)
    }

}