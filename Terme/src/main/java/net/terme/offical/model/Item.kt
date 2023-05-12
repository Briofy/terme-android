package net.terme.offical.model

import android.graphics.drawable.Drawable

data class Item(
    var logo: Drawable? = null,
    var name: String = "",
    var badge: Badge? = null
)
