package net.lynqfy.offical.model

import android.graphics.drawable.Drawable

sealed interface Item {
    var logo : Drawable
    var name : String
    var badge : Badge?
}