package com.xemp.common

import org.junit.Test

/**
 *
 * @date: 2019-08-15 16:58
 * @author: jockin
 * Description: $Method$
 */

class InfoPros:AbsProperties("info.properties"){
    var name:String by prop
    var email:String by prop
    var age:Int by prop
    var student:Boolean by prop
    var point:Float by prop
}
class PropertiesTest {
    @Test
    fun testProp(){
        InfoPros().let {
            println(it.name)
            println(it.email)
            println(it.age)
            println(it.student)
            println(it.point)

            it.name = "kotlin"
            it.email="11@qq.com"
            it.age =2
            it.point = 3.1f

            println(it.name)
            println(it.email)
        }
    }
}
