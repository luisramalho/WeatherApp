package com.luisramalho.weatherapp

import android.util.Log
import java.net.URL

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
public class Request(val url: String) {

    public fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}
