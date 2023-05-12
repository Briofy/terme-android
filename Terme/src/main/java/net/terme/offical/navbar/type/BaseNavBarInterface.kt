package net.terme.offical.navbar.type

import android.util.AttributeSet

interface BaseNavBarInterface {
    fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0)
    fun initUI()
}