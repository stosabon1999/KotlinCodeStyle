package com.sobolevsky.kotlincodestyle.di.modules

import com.sobolevsky.kotlincodestyle.data.converters.WeatherResponseConverter
import com.sobolevsky.kotlincodestyle.data.repositories.WeatherCityRepositoryImpl
import com.sobolevsky.kotlincodestyle.data.service.WeatherService
import com.sobolevsky.kotlincodestyle.domain.converters.WeatherItemViewConverter
import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractor
import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractorImpl
import dagger.Module
import dagger.Provides

@Module
internal class WeatherDataModule {

    @Provides
    fun provideInteractor(service: WeatherService): WeatherCityInteractor {
        return WeatherCityInteractorImpl(
            WeatherCityRepositoryImpl(service, WeatherResponseConverter()),
            WeatherItemViewConverter()
        )
    }
}