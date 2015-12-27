package com.luisramalho.weatherapp.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.luisramalho.weatherapp.R
import com.luisramalho.weatherapp.domain.commands.RequestForecastCommand
import com.luisramalho.weatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.activity_main.*
import org.jetbrains.anko.toast

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)

        async() {
            val result = RequestForecastCommand(658226).execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) {
                    toast(it.description)
                }
            }
        }
    }
}
