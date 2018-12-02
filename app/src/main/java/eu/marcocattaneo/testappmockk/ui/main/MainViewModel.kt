package eu.marcocattaneo.testappmockk.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import eu.marcocattaneo.testappmockk.SampleUseCase

class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<String>()

    var useCase: SampleUseCase? = null
        get

    fun run(input: Input) {
        useCase?.execute(input)?.subscribe({
            this.liveData.value = it
        },{

        })
    }

}
