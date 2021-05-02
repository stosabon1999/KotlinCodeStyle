package com.sobolevsky.kotlincodestyle.di.components

import com.sobolevsky.kotlincodestyle.di.modules.FragmentBuildersModule
import com.sobolevsky.kotlincodestyle.view.activities.WeatherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WeatherActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )
    abstract fun contributeWeatherActivity(): WeatherActivity
}