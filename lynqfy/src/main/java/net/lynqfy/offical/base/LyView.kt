package net.lynqfy.offical.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes


abstract class LyView : FrameLayout {


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

    abstract fun getMainView(): View
    var onClickListener: OnClickListener? = null
        set(value) {
            if (value != null)
                getMainView().setOnClickListener {
                    value.onButtonClick(getMainView())
                }
            else
                getMainView().setOnClickListener(null)
            field = value
        }
    var onLongClickListener: OnLongClickListener? = null
        set(value) {
            if (value != null)
                getMainView().setOnLongClickListener {
                    value.onButtonLongClick(getMainView())
                }
            else
                getMainView().setOnLongClickListener(null)
            field = value
        }


    interface OnClickListener {
        fun onButtonClick(button: View)
    }

    interface OnLongClickListener {
        fun onButtonLongClick(button: View): Boolean
    }

}