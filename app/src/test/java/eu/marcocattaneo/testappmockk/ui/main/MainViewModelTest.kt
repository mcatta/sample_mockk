package eu.marcocattaneo.testappmockk.ui.main

import android.arch.lifecycle.Observer
import eu.marcocattaneo.testappmockk.SampleUseCase
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.reactivex.Single
import org.hamcrest.CoreMatchers.any
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule



class MainViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @MockK
    lateinit var useCase: SampleUseCase

    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        this.viewModel = MainViewModel()
        this.viewModel.useCase = this.useCase
    }

    @Test
    fun testRun() {
        val observer = Observer<String> {}
        this.viewModel.liveData.observeForever(observer)

        every { useCase.execute(any()) } answers {Single.just("testone")}

        this.viewModel.run(mockk())

        assertNotNull(this.viewModel.liveData.value)
        assertEquals("testone", this.viewModel.liveData.value)
    }
}