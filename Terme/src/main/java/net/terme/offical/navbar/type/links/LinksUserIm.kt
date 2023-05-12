package net.terme.offical.navbar.type.links

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import net.terme.offical.databinding.LyNavBarUserLinkUiBinding
import net.terme.offical.navbar.ButtonCallback
import net.terme.offical.navbar.MenuCallback
import net.terme.offical.navbar.type.LyNavBarType

class LinksUserIm (
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    private val attr: AttributeSet,
    private val defStyleAttr: Int,
    override var type: LyNavBarType = LyNavBarType.LinksUser
) : LinksUser {

    override var onButtonAction: ButtonCallback? = null
    override var onMenuAction: MenuCallback? = null
    override fun initTheme(attrs: AttributeSet?, defStyleAttr: Int) {}


    override fun initUI() {
        initTheme(attr, defStyleAttr)

        parent.addView(ui.root, 0)


    }



    private val ui by lazy {
        LyNavBarUserLinkUiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
}