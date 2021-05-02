package com.sobolevsky.kotlincodestyle.domain.interactor

import com.google.common.truth.Truth
import com.sobolevsky.kotlincodestyle.data.repositories.WeatherCityRepositoryImpl
import com.sobolevsky.kotlincodestyle.data.service.WeatherService
import com.sobolevsky.kotlincodestyle.domain.repositories.WeatherCityRepository
import com.sobolevsky.kotlincodestyle.models.OneWayConverter
import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem
import com.sobolevsky.kotlincodestyle.models.view.WeatherItemView
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class WeatherCityInteractorImplTest {

    private val repository: WeatherCityRepository = mockk(relaxed = true)
    private val converter: OneWayConverter<WeatherDomainItem, List<WeatherItemView>> = mockk(relaxed = true)
    private val domainItem: WeatherDomainItem = mockk()
    private val expectedValue: List<WeatherItemView> = mockk()

    private lateinit var interactor: WeatherCityInteractor

    @Before
    fun setUp() {
        interactor = WeatherCityInteractorImpl(repository, converter)
        coEvery { repository.loadWeather() } returns domainItem
        every { converter.convert(domainItem) } returns expectedValue
    }

    @Test
    fun `test load weather`() {
        val result = runBlocking {
            interactor.loadWeather()
        }
        Truth.assertThat(result).isEqualTo(expectedValue)
    }
}