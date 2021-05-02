package com.sobolevsky.kotlincodestyle.di.modules

import dagger.Module

/**
 * Главный модуль.
 *
 * @author Соболевский Станислав
 */
@Module(includes = [
    ViewModelModule::class,
    NetworkModule::class,
    WeatherDataModule::class
])
internal class AppModule {

}