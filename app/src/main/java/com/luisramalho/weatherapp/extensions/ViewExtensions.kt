package com.luisramalho.weatherapp.extensions

import android.content.Context
import android.view.View

/**
 * Created by Luís Ramalho on 25/12/15.
 * <info@luisramalho.com>
 */

val View.ctx: Context
    get() = context
