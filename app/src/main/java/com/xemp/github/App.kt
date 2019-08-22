package com.xemp.github

import android.app.Application
import android.content.Context
import android.content.ContextWrapper

/**
 *
 * @date: 2019-08-15 11:31
 * @author: jockin
 * Description: $Method$
 */

private lateinit var INSTANCE:Application

class App:Application(){

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

object AppContext:ContextWrapper(INSTANCE)