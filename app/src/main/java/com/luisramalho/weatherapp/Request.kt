package com.luisramalho.weatherapp

import com.google.gson.Gson
import com.luisramalho.weatherapp.data.ResponseClasses.ForecastResult
import java.net.URL

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
public class Request(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    public fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}
