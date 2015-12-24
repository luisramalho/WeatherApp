package com.luisramalho.weatherapp.i

/**
 * Created by Luís Ramalho on 24/12/15.
 * <info@luisramalho.com>
 */
public interface Command<T> {
    fun execute(): T
}
