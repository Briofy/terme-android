package net.terme.offical.model

import android.graphics.drawable.Drawable

data class UserInfo(
    val name: String,
    val dic: String,
    var avatar: Drawable? = null
)
