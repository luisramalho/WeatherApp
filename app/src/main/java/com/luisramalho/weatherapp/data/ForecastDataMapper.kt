package com.luisramalho.weatherapp.data

import com.luisramalho.weatherapp.domain.model.ForecastList
import com.luisramalho.weatherapp.data.ResponseClasses.ForecastResult
import com.luisramalho.weatherapp.data.ResponseClasses.Forecast
import com.luisramalho.weatherapp.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(
                forecast.city.id,
                forecast.city.name,
                forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
                forecast.dt,
                convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) =
            "http://openweathermap.org/img/w/$iconCode.png"

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date * 1000)
    }
}
