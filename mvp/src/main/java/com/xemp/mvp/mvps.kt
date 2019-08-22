package com.xemp.mvp

import android.view.View

/**
 *
 * @date: 2019-08-18 11:01
 * @author: jockin
 * Description: $Method$
 */

interface IMvpView<out Presenter:IMvpPresenter<IMvpView<Presenter>>>:ILifecycle{
    val presenter:Presenter
}
interface IMvpPresenter<out View:IMvpView<IMvpPresenter<View>>>:ILifecycle{
    val view:View
}