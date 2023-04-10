package net.lynqfy.offical.base

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

abstract class BaseWidget : FrameLayout {

    constructor(mContext: Context) : super(mContext) {
        init()
    }


    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr) {

    }

    constructor(mContext: Context, attr: AttributeSet?, defStyleAttr: Int) : super(
        mContext,
        attr,
        defStyleAttr
    ) {
        init(attr)
    }


    abstract fun init(attr: AttributeSet? = null, defStyleAttr: Int = 0)


}