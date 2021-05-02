package com.sobolevsky.kotlincodestyle.view.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.google.common.truth.Truth
import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractor
import com.sobolevsky.kotlincodestyle.models.WeatherItem
import com.sobolevsky.kotlincodestyle.models.view.WeatherItemView
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import io.mockk.verifySequence
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.lang.RuntimeException

class WeatherCityViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: WeatherCityViewModel
    private val interactor: WeatherCityInteractor = mockk()

    private val loadingStateObserver: Observer<Boolean> = spyk()
    private val errorStateObserver: Observer<Unit> = spyk()

    @Before
    fun setUp() {
        viewModel = WeatherCityViewModel()
        viewModel.weatherCityInteractor = interactor
        viewModel.isLoading.observeForever(loadingStateObserver)
        viewModel.serviceUnavailable.observeForever(errorStateObserver)
    }

    @Test
    fun `load weather success`() {
        viewModel.loadWeather()

        verifySequence {
            loadingStateObserver.onChanged(true)
            loadingStateObserver.onChanged(false)
        }
    }

    @Test
    fun `load weather error`() {
        coEvery { interactor.loadWeather() } throws RuntimeException()

        viewModel.loadWeather()

        verifySequence {
            loadingStateObserver.onChanged(true)
            errorStateObserver.onChanged(Unit)
            loadingStateObserver.onChanged(false)
        }
    }
}