package net.lynqfy.offical.card

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView

open class LyCardView : MaterialCardView {

    constructor(ctx: Context) : super(ctx, null)
    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr)
    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        ctx,
        attr,
        defStyleAttr
    )
}