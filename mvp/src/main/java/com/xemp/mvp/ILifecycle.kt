package com.xemp.mvp

import android.content.res.Configuration
import android.os.Bundle
/**
 *
 * @date: 2019-08-18 11:12
 * @author: jockin
 * Description: $Method$
 */
interface ILifecycle {

    fun onCreate(savedInstanceState: Bundle?)

    fun onSaveInstanceState(outState: Bundle)

    fun onViewStateRestored(savedInstanceState: Bundle?)

    fun onConfigurationChanged(newConfig: Configuration)

    fun onDestroy()

    fun onStart()

    fun onStop()

    fun onResume()

    fun onPause()
}