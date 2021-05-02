package com.sobolevsky.kotlincodestyle.di.modules

import com.sobolevsky.kotlincodestyle.data.converters.WeatherResponseConverter
import com.sobolevsky.kotlincodestyle.data.repositories.WeatherCityRepositoryImpl
import com.sobolevsky.kotlincodestyle.data.service.WeatherService
import com.sobolevsky.kotlincodestyle.domain.converters.WeatherItemViewConverter
import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractor
import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractorImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
internal class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .client(
                OkHttpClient.Builder()
                    .followRedirects(false).build()
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }
}