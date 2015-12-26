package com.luisramalho.weatherapp.ui.adapters

import com.luisramalho.weatherapp.R
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.luisramalho.weatherapp.domain.model.Forecast
import com.luisramalho.weatherapp.domain.model.ForecastList
import com.luisramalho.weatherapp.extensions.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.onClick
import kotlinx.android.synthetic.item_forecast.view.*

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
class ForecastListAdapter(
        val weekForecast: ForecastList,
        val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            ViewHolder {
        val layout = R.layout.item_forecast;
        val view = parent.ctx.layoutInflater.inflate(layout, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.onClick { itemClick(forecast) }
            }
        }
    }
}
