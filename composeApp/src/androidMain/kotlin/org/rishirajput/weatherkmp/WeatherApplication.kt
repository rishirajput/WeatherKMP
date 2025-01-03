package org.rishirajput.weatherkmp

import android.app.Application
import org.rishirajput.weatherkmp.di.initKoin

class WeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
