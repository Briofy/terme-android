package net.terme.offical.navbar.type.level.top

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.terme.offical.R
import net.terme.offical.databinding.LyNavBarTopLevelUiBinding
import net.terme.offical.databinding.LyNavBarUiBinding
import net.terme.offical.navbar.ButtonCallback
import net.terme.offical.navbar.MenuCallback
import net.terme.offical.navbar.type.LyNavBarType
import net.terme.offical.utils.VectorDrawableUtils

internal class TopLevelIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    private val attr: AttributeSet,
    private val defStyleAttr: Int,
    override var type: LyNavBarType = LyNavBarType.TopLevel
) : TopLevel {

    override var onButtonAction: ButtonCallback? = null
    override var onMenuAction: MenuCallback? = null
    override fun initTheme(attrs: AttributeSet?, defStyleAttr: Int) {}
    private fun showMenuWithLogin() {
        toolbar.apply {
            navButton.visibility = View.GONE
            navLogin.visibility = View.GONE
            navMenu.visibility = View.VISIBLE

            navMenu.setOnClickListener {
                onMenuAction?.invoke()
            }
        }
        topLevel.apply {
            carouselNav.setOnClickListener {
                onButtonAction?.invoke()
            }
        }
    }

    override fun initUI() {
        initTheme(attr, defStyleAttr)
        showMenuWithLogin()
        parent.addView(topLevel.root, 0)
        val v = View(parent.context)
        val layout = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , 1)
        v.background = VectorDrawableUtils.getDrawable(parent.context, R.drawable.separator)
        v.layoutParams = layout
        parent.addView(v, 1)
        parent.addView(toolbar.root, 2)

    }

    private val toolbar by lazy {
        LyNavBarUiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    private val topLevel by lazy {
        LyNavBarTopLevelUiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
}