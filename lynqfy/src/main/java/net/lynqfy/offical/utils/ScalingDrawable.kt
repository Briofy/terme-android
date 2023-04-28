package net.lynqfy.offical.utils

import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable


/** The drawable that scales the contained drawable  */
class ScalingDrawable internal constructor(d: Drawable, scaleX: Float, scaleY: Float) :
    LayerDrawable(arrayOf(d)) {
    /** X scale  */
    var scaleX = 0f

    /** Y scale  */
    var scaleY = 0f

    init {
        setScale(scaleX, scaleY)
    }

    internal constructor(d: Drawable, scale: Float) : this(d, scale, scale) {}

    /** set the scales  */
    fun setScale(scaleX: Float, scaleY: Float) {
        this.scaleX = scaleX
        this.scaleY = scaleY
    }

    /** set the scale -- proportional scaling  */
    fun setScale(scale: Float) {
        setScale(scale, scale)
    }

    // The following is what I wrote this for!
    override fun getIntrinsicWidth(): Int {
        return (super.getIntrinsicWidth() * scaleX).toInt()
    }

    override fun getIntrinsicHeight(): Int {
        return (super.getIntrinsicHeight() * scaleY).toInt()
    }
}