package net.terme.offical.dropdown

import android.graphics.drawable.Drawable
import android.view.View

data class TermeDropItem(
    val id: Long = View.generateViewId().toLong(), // Id for send action back
    val text: String,
    val icon: Drawable? = null ,
//    var isSelected : Boolean = false,
//    var isEmptyItem : Boolean = false
)
