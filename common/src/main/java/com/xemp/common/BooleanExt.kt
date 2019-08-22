package com.xemp.common

/**
 *
 * @date: 2019-08-14 09:43
 * @author: jockin
 * Description: $Method$
 */


sealed class BooleanExt<out T>

object Otherwise : BooleanExt<Nothing>()
class WithData<T>(val data: T) : BooleanExt<T>()

inline fun <T> Boolean.yes(block: () -> T) =
    when {
        this -> {
            WithData(block())
        }
        else -> Otherwise
    }


inline fun <T> BooleanExt<T>.otherwise(block: () -> T): T =
    when (this) {
        is Otherwise -> block()
        is WithData -> this.data
    }

inline fun <T>Boolean.no(block: () -> T) =
    when {
        !this ->{
            WithData(block())
        }
        else-> Otherwise
    }


