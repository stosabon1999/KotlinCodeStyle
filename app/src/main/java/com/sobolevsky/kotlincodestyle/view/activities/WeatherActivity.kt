package com.sobolevsky.kotlincodestyle.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sobolevsky.kotlincodestyle.R
import com.sobolevsky.kotlincodestyle.view.fragments.WeatherCityFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class WeatherActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, WeatherCityFragment.newInstance())
            .commit()
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

}