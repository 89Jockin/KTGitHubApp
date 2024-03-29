package com.xemp.mvp.impl

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import com.xemp.mvp.IMvpPresenter
import com.xemp.mvp.IMvpView
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

/**
 *
 * @date: 2019-08-20 11:06
 * @author: jockin
 * Description: $Method$
 */
abstract class BaseFragment<out P:BasePresenter<BaseFragment<P>>> : Fragment(),IMvpView<P>{

    override val presenter: P

    init {
        presenter = createPresenterKt()
        presenter.view = this
    }

   private fun  createPresenterKt():P {
        sequence {
            var thisClass:KClass<*> = this@BaseFragment::class
            while (true){
                yield(thisClass.supertypes)
                thisClass = thisClass.supertypes.firstOrNull()?.jvmErasure?:break
            }
        }.flatMap{
            it.flatMap{ it.arguments}.asSequence()
        }.first{
            it.type?.jvmErasure?.isSubclassOf(IMvpPresenter::class)?:false
        }.let{
            return it.type!!.jvmErasure.primaryConstructor!!.call() as P
        }
    }
    private fun createPresenter():P{
        sequence<Type> {
            var thisClass:Class<*> = this@BaseFragment.javaClass
            while (true){
                yield(thisClass.genericSuperclass)
                thisClass = thisClass.superclass?:break
            }
        }.filter {
            it is ParameterizedType
        }.flatMap {
            (it as  ParameterizedType).actualTypeArguments.asSequence()
        }.first{
            it is Class<*>&&IMvpPresenter::class.java.isAssignableFrom(it)
        }.let {
            return (it as Class<P>).newInstance()
        }
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        presenter.onConfigurationChanged(newConfig)
    }


}

class MainFragment: BaseFragment<MainPresenter>()
class MainPresenter:BasePresenter<MainFragment>()