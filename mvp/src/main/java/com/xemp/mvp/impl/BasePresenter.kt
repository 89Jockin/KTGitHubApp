package com.xemp.mvp.impl

import android.content.res.Configuration
import android.os.Bundle
import com.xemp.mvp.IMvpPresenter
import com.xemp.mvp.IMvpView

/**
 *
 * @date: 2019-08-18 11:18
 * @author: jockin
 * Description: $Method$
 */

abstract class BasePresenter<out V:IMvpView<BasePresenter<V>>>:IMvpPresenter<V> {

    override lateinit var  view: @UnsafeVariance V

    override fun onCreate(savedInstanceState: Bundle?) = Unit

    override fun onSaveInstanceState(outState: Bundle) = Unit

    override fun onViewStateRestored(savedInstanceState: Bundle?) = Unit

    override fun onConfigurationChanged(newConfig: Configuration) = Unit

    override fun onDestroy() = Unit

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onResume() = Unit

    override fun onPause() = Unit
}