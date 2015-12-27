package com.luisramalho.weatherapp.domain.commands

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
interface Command<T> {
    fun execute(): T
}
