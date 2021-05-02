package com.sobolevsky.kotlincodestyle.di.components

import android.app.Application
import com.sobolevsky.kotlincodestyle.application.WeatherApplication
import com.sobolevsky.kotlincodestyle.di.modules.AppModule
import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractor
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        WeatherActivityModule::class
    ]
)
internal interface AppComponent : WeatherDataComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: WeatherApplication)

}