package com.luisramalho.weatherapp.extensions

/**
 * Created by Luís Ramalho on 27/12/15.
 * <info@luisramalho.com>
 */
fun <K, V : Any> MutableMap<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()
