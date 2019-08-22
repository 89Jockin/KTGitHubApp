package com.xemp.github.data

import com.xemp.common.Preference
import com.xemp.github.AppContext

/**
 *
 * @date: 2019-08-15 11:12
 * @author: jockin
 * Description: $Method$
 */

object Settings{
    var username:String by Preference(AppContext,"username","")
    var password:String by Preference(AppContext,"password","")
}