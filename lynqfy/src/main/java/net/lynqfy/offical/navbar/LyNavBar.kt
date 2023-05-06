package net.lynqfy.offical.navbar

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.LinearLayoutCompat
import net.lynqfy.offical.R
import net.lynqfy.offical.navbar.type.LyNavBarAction
import net.lynqfy.offical.navbar.type.LyNavBarType
import net.lynqfy.offical.navbar.type.SearchLinksUserIm
import net.lynqfy.offical.navbar.type.cta.CTAButtonIm
import net.lynqfy.offical.navbar.type.dropdown.DoubleDropdownIm
import net.lynqfy.offical.navbar.type.level.BottomLevelIm
import net.lynqfy.offical.navbar.type.level.three.ThreeLevelIm
import net.lynqfy.offical.navbar.type.level.top.TopLevelIm
import net.lynqfy.offical.navbar.type.links.LinksUserIm
import net.lynqfy.offical.navbar.type.simple.SimpleMegaMenu

typealias ButtonCallback = () -> Unit
typealias MenuCallback = () -> Unit

class LyNavBar : LinearLayoutCompat {
    constructor(ctx: Context) : super(ctx, null) {
        initNavBarTheme(null)
    }

    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr) {
        initNavBarTheme(attr)
    }

    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        ctx,
        attr,
        defStyleAttr
    ) {
        initNavBarTheme(attr, defStyleAttr)
    }

    fun onButtonAction(callback: ButtonCallback) {
        if (::mLyNavBarAction.isInitialized) {
            mLyNavBarAction.onButtonAction = callback
        }
    }

    fun onMenuAction(callback: MenuCallback) {
        if (::mLyNavBarAction.isInitialized) {
            mLyNavBarAction.onMenuAction = callback
        }
    }

    private fun initNavBarTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.LyNavBar,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_Toolbar
            )
            val navBarType = TypedValue()
            if (attributes.getValue(R.styleable.LyNavBar_NavBarType, navBarType)) {
                mLyNavBarUiType = navBarType.data
                when (mLyNavBarUiType) {
                    /*"SimpleMegaMenu" */      1 -> {
                    SimpleMegaMenu(this, attributes, attrs, defStyleAttr)
                }
                    /*"MegaMenuWithIcons"*/  2 -> {
//                    MegaMenuWithIcons(this, attributes, attrs, defStyleAttr)
                }
                    /*"SearchLinksUser" */     3 -> {
                    SearchLinksUserIm(this, attributes, attrs, defStyleAttr).apply {
                        initUI()
                    }
                }
                    /*"CTADropdown"*/    4 -> {
                    mLyNavBarAction = CTAButtonIm(
                        this, attributes, attrs, defStyleAttr,
                        LyNavBarType.CTADropdown
                    ).apply {
                        initUI()
                    }
                }
                    /*"TwoLevelMegaMenu"*/  5 -> {
                    //TwoLevelMegaMenu(this, attributes, attrs, defStyleAttr)
                }
                    /*"LogoCTA"*/ 6 -> {
                    mLyNavBarAction = CTAButtonIm(
                        this, attributes, attrs, defStyleAttr,
                        LyNavBarType.LogoCTA
                    ).apply {
                        initUI()
                    }
                }
                    /*"LanguageSearch"*/    7 -> {
                    mLyNavBarAction = CTAButtonIm(
                        this, attributes, attrs, defStyleAttr,
                        LyNavBarType.LanguageSearch
                    ).apply {
                        initUI()
                    }
                }
                    /*"CenteredLinks"*/   8 -> {
                    mLyNavBarAction = CTAButtonIm(
                        this, attributes, attrs, defStyleAttr,
                        LyNavBarType.CenteredLinks
                    ).apply {
                        initUI()
                    }
                }
                    /*"LinksUser"*/    9 -> {
                    LinksUserIm(this, attributes, attrs, defStyleAttr).apply {
                        initUI()
                    }
                }
                    /*"WithCTAButton"*/  10 -> {
                    mLyNavBarAction = CTAButtonIm(
                        this, attributes, attrs, defStyleAttr,
                        LyNavBarType.WithCTAButton
                    ).apply {
                        initUI()
                    }
                }
                    /*"BottomLevel"*/      11 -> {
                    BottomLevelIm(this, attributes, attrs, defStyleAttr).apply {
                        initUI()
                    }
                }
                    /*"ThreeLevels"*/    12 -> {
                    ThreeLevelIm(this, attributes, attrs, defStyleAttr).apply {
                        initUI()
                    }
                }
                    /*"FullWidthDescription"*/    13 -> {
//                     FullWidthDescription(this, attributes, attrs, defStyleAttr)
                }
                    /*"DoubleDropdown"*/ 14 -> {
                    DoubleDropdownIm(this, attributes, attrs, defStyleAttr).apply {
                        initUI()
                    }
                }
                    /*TopLevel*/  15 -> {
                    TopLevelIm(this, attributes, attrs, defStyleAttr).apply {
                        initUI()
                    }
                }

                }
                attributes.recycle()
            }
            orientation = VERTICAL
        }
    }

    private var mLyNavBarUiType: Int = 1
    private lateinit var mLyNavBarAction: LyNavBarAction
}