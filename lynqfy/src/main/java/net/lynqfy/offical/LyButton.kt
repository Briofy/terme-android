package net.lynqfy.offical

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import net.lynqfy.offical.base.BaseWidget

class LyButton : BaseWidget {
    constructor(context: Context):super(context)
    constructor(context: Context,attr: AttributeSet?):super(context,attr)
    constructor(context: Context,attr: AttributeSet?,style:Int):super(context,attr,style)


    override fun getLayoutId() = R.layout.button







}