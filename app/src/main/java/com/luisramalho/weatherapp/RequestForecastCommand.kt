package com.luisramalho.weatherapp

import com.luisramalho.weatherapp.data.ForecastDataMapper
import com.luisramalho.weatherapp.domain.model.ForecastList
import com.luisramalho.weatherapp.i.Command

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest
                .execute())

    }
}
