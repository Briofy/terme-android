package net.terme.offical.navbar.type.dropdown

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.terme.offical.databinding.LyNavBarMenuUiBinding
import net.terme.offical.databinding.LyNavBarUiBinding
import net.terme.offical.navbar.ButtonCallback
import net.terme.offical.navbar.MenuCallback
import net.terme.offical.navbar.type.LyNavBarType

class DoubleDropdownIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    private val attr: AttributeSet,
    private val defStyleAttr: Int,
    override var type: LyNavBarType = LyNavBarType.DoubleDropdown
) : DoubleDropdown {

    override var onButtonAction: ButtonCallback? = null
    override var onMenuAction: MenuCallback? = null
    override fun initTheme(attrs: AttributeSet?, defStyleAttr: Int) {}
    private fun showMenuWithLogin() {
        toolbar.apply {
            navButton.visibility = View.GONE
            navLogin.visibility = View.VISIBLE
            navMenu.visibility = View.VISIBLE

            navLogin.setOnClickListener {
                onButtonAction?.invoke()
            }
            navMenu.setOnClickListener {
                onMenuAction?.invoke()
            }
        }
    }

    override fun initUI() {
        initTheme(attr, defStyleAttr)
        showMenuWithLogin()

        parent.addView(toolbar.root , 0)
        parent.addView(menuUI.root , 1)
    }

    private val toolbar by lazy {
        LyNavBarUiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    private val menuUI by lazy {
        LyNavBarMenuUiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

}