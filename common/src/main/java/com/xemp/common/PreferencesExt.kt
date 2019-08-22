package com.xemp.common

import android.content.Context
import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @date: 2019-08-15 10:16
 * @author: jockin
 * Description: $Method$
 */

class Preference<T>(val context: Context, val name: String, val default: T, val prefName: String = "default") :
    ReadWriteProperty<Any?, T> {

    private val prefs by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T =
        getPreference(name)


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun getPreference(key: String): T {
      return  when (default) {
            is Long -> prefs.getLong(key, default)
            is Int -> prefs.getInt(key, default)
            is Boolean -> prefs.getBoolean(key, default)
            is String -> prefs.getString(key, default)
            else -> throw IllegalArgumentException("PreferencesError-get")
        } as T
    }


    private fun putPreference(key: String, value: T) {
        with(prefs.edit()) {
            when (value) {
                is Long -> putLong(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
                else -> throw IllegalArgumentException("PreferencesError-set")
            }
        }.apply()
    }


}