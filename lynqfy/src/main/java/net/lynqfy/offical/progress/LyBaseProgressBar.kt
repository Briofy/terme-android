package net.lynqfy.offical.progress

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar

internal class LyBaseProgressBar : ProgressBar {

    constructor(ctx: Context) : super(ctx, null)

    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr)

    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        ctx,
        attr,
        defStyleAttr
    )

    override fun setProgress(progress: Int) {
        super.setProgress(progress)
        listener?.onProgressChanged(progress)
    }

    fun setOnProgressBarChangeListener(l: OnProgressBarChangeListener) {
        listener = l
    }

    private var listener: OnProgressBarChangeListener? = null

    interface OnProgressBarChangeListener {
        fun onProgressChanged(progress: Int)
    }
}