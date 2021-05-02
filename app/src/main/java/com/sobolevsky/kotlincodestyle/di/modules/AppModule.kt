package com.sobolevsky.kotlincodestyle.di.modules

import dagger.Module

@Module(includes = [
    ViewModelModule::class,
    NetworkModule::class,
    WeatherDataModule::class
])
internal class AppModule {

}