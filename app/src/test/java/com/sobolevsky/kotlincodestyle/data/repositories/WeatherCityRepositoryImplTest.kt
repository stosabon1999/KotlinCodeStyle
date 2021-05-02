package com.sobolevsky.kotlincodestyle.data.repositories

import com.google.common.truth.Truth
import com.sobolevsky.kotlincodestyle.data.service.WeatherService
import com.sobolevsky.kotlincodestyle.domain.repositories.WeatherCityRepository
import com.sobolevsky.kotlincodestyle.models.OneWayConverter
import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class WeatherCityRepositoryImplTest {

    private val service: WeatherService = mockk(relaxed = true)
    private val converter: OneWayConverter<WeatherCityResponse, WeatherDomainItem> = mockk(relaxed = true)
    private val response: WeatherCityResponse = mockk()
    private val domainItem: WeatherDomainItem = mockk()

    private lateinit var repository: WeatherCityRepository

    @Before
    fun setUp() {
        repository = WeatherCityRepositoryImpl(service, converter)
        coEvery { service.getWeather() } returns response
        every { converter.convert(response) } returns domainItem
    }

    @Test
    fun `test load weather`() {
        val result = runBlocking {
            repository.loadWeather()
        }
        Truth.assertThat(result).isEqualTo(domainItem)
    }
}