package net.lynqfy.offical.navbar.type

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import net.lynqfy.offical.databinding.LyNavBarSearchLinkUserUiBinding
import net.lynqfy.offical.navbar.ButtonCallback
import net.lynqfy.offical.navbar.MenuCallback

class SearchLinksUserIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    private val attr: AttributeSet,
    private val defStyleAttr: Int,
    override var type: LyNavBarType = LyNavBarType.SearchLinksUser
) : SearchLinksUser {

    override var onButtonAction: ButtonCallback? = null
    override var onMenuAction: MenuCallback? = null
    override fun initTheme(attrs: AttributeSet?, defStyleAttr: Int) {
        //TODO("Not yet implemented")
    }

    override fun initUI() {
        initTheme(attr, defStyleAttr)
        parent.addView(ui.root)
    }

    private val ui by lazy {
        LyNavBarSearchLinkUserUiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
}