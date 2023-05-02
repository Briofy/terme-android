package net.lynqfy.offical.navbar.type.cta

import android.util.AttributeSet
import net.lynqfy.offical.navbar.type.LyNavBarAction

internal interface CTAButton : LyNavBarAction {
     fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0)
     fun initUI()
}