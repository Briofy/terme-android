package net.lynqfy.offical.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes


abstract class BaseWidget : FrameLayout {


    lateinit var mView: View


    constructor(mContext: Context) : super(mContext) {
        init(mContext)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr) {
        init(mContext, attr)
    }

    constructor(mContext: Context, attr: AttributeSet?, defStyleAttr: Int) : super(
        mContext,
        attr,
        defStyleAttr
    ) {
        init(mContext, attr)
    }


    open fun init(mContext: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0) {
      //  val binding = LayoutInflater.from(context).inflate(getLayoutId(),this,false);
        mView = LayoutInflater.from(mContext).inflate(getLayoutId(), this, false)

        addView(mView)
    }


}