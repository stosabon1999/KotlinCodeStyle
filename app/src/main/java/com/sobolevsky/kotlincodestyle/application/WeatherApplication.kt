package com.sobolevsky.kotlincodestyle.application

import android.app.Activity
import android.app.Application
import com.sobolevsky.kotlincodestyle.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Application. Инициализация даггер графа.
 *
 * @author Соболевский Станислав
 */
class WeatherApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}

