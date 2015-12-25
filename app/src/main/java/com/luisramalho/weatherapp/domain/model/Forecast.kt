package com.luisramalho.weatherapp.domain.model

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
data class ForecastList(val id: Long,
                        val city: String,
                        val country: String,
                        val dailyForecast: List<Forecast>) {

    operator fun get(position: Int): Forecast = dailyForecast[position]

    fun size() = dailyForecast.size
}

data class Forecast(val id: Long,
                    val date: String,
                    val description: String,
                    val high: Int,
                    val low: Int,
                    val iconUrl: String)
