package com.luisramalho.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.luisramalho.weatherapp.domain.model.ForecastList

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
public class ForecastListAdapter(val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        ViewHolder? {
        return ForecastListAdapter.ViewHolder(TextView(parent.getContext()))
    }

    override fun onBindViewHolder(holder: ForecastListAdapter.ViewHolder,
                                  position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount():Int = weekForecast.dailyForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
