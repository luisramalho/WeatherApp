package com.luisramalho.weatherapp.domain.commands

import com.luisramalho.weatherapp.domain.mappers.ForecastDataMapper
import com.luisramalho.weatherapp.data.server.ForecastRequest
import com.luisramalho.weatherapp.domain.model.ForecastList

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
class RequestForecastCommand(private val id: Long) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val request = ForecastRequest(id)
        return ForecastDataMapper().convertFromDataModel(id, request.execute())
    }
}
