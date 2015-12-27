package com.luisramalho.weatherapp.domain.mappers

import com.luisramalho.weatherapp.domain.model.ForecastList
import com.luisramalho.weatherapp.data.server.ResponseClasses.ForecastResult
import com.luisramalho.weatherapp.data.server.ResponseClasses.Forecast
import com.luisramalho.weatherapp.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
class ForecastDataMapper {
    fun convertFromDataModel(id: Long, forecast: ForecastResult) : ForecastList
            = with(forecast) {
        return ForecastList(
                id,
                city.name,
                city.country,
                convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast
            = with(forecast) {
        return ModelForecast(
                dt * 1000,
                weather[0].description,
                temp.max.toInt(),
                temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) =
            "http://openweathermap.org/img/w/$iconCode.png"
}
