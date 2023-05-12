package net.terme.offical.model

import android.graphics.drawable.Drawable

data class EcommerceInfo(
    var name : String ,
    var image: Drawable?=null,
    var cast : Double  = 599.0,
    var rating: Float = 4.5f
)
