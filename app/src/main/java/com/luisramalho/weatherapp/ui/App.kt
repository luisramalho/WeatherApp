package com.luisramalho.weatherapp.ui

import android.app.Application
import com.luisramalho.weatherapp.extensions.DelegatesExt

/**
 * Created by Luís Ramalho on 26/12/15.
 * <info@luisramalho.com>
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
