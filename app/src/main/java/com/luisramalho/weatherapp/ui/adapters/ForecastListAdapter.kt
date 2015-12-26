package com.luisramalho.weatherapp.ui.adapters

import com.luisramalho.weatherapp.R
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.luisramalho.weatherapp.domain.model.Forecast
import com.luisramalho.weatherapp.domain.model.ForecastList
import com.luisramalho.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.onClick

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

        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.onClick { itemClick(forecast) }
            }
        }
    }
}
