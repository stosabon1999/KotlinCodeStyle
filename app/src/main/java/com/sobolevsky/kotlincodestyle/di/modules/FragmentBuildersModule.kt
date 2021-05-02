package com.sobolevsky.kotlincodestyle.di.modules

import com.sobolevsky.kotlincodestyle.view.fragments.WeatherCityFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeWeatherCityFragment(): WeatherCityFragment
}