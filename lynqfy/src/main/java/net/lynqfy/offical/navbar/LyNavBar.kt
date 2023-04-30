package net.lynqfy.offical.navbar

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.LinearLayoutCompat
import net.lynqfy.offical.R
import net.lynqfy.offical.navbar.type.simple.SimpleMegaMenu


class LyNavBar : LinearLayoutCompat{
    constructor(ctx: Context) : super(ctx, null) {
        initTheme(null)
    }
    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr) {
        initTheme(attr)
    }
    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(ctx,attr,defStyleAttr) {
        initTheme(attr, defStyleAttr)
    }

    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.LyNavBar,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_Toolbar
            )
            val cardType = TypedValue()
            if (attributes.getValue(R.styleable.LyNavBar_NavBarType, cardType)) {
                mLyCardUiType = cardType.data

                when (cardType.data) {
                    /*"SimpleMegaMenu" */      1 -> {
                    SimpleMegaMenu(this, attributes, attrs, defStyleAttr)
                }
                    /*"MegaMenuWithIcons"*/  2 -> {
//                    MegaMenuWithIcons(this, attributes, attrs, defStyleAttr)
                }
                    /*"SearchLinksUser" */     3 -> {
                    //SearchLinksUser(this, attributes, attrs, defStyleAttr)
                }
                    /*"CTADropdown"*/    4 -> {
                    //CTADropdown(this, attributes, attrs, defStyleAttr)
                }
                    /*"TwoLevelMegaMenu"*/  5 -> {
                    //TwoLevelMegaMenu(this, attributes, attrs, defStyleAttr)
                }
                    /*"LogoCTA"*/ 6 -> {
//                     LogoCTA(this, attrs, defStyleAttr)
                }
                    /*"LanguageSearch"*/    7 -> {
//                     LanguageSearch(this, attributes, attrs, defStyleAttr)
                }
                    /*"CenteredLinks"*/   8 -> {
//                     CenteredLinks(this, attributes, attrs, defStyleAttr).apply {
//                        disableButton()
//                    }
                }
                    /*"LinksUser"*/    9 -> {
//                     EcommerceIm(this, attrs, defStyleAttr)
                }
                    /*"WithCTAButton"*/  10 -> {
//                     WithCTAButton(this, attributes, attrs, defStyleAttr)
                }
                    /*"BottomLevel"*/      11 -> {
                    //BottomLevel(this, attributes, attrs, defStyleAttr)
                }
                    /*"ThreeLevels"*/    12 -> {
                    //ThreeLevels(this, attributes, attrs, defStyleAttr)
                }
                    /*"FullWidthDescription"*/    13 -> {
//                     FullWidthDescription(this, attributes, attrs, defStyleAttr)
                }
                    /*"DoubleDropdown"*/ 14 -> {
//                    DoubleDropdown(this, attributes, attrs, defStyleAttr)
                }
                }
                invalidate()
            }
            attributes.recycle()
        }
    }

    private var mLyCardUiType: Int = 1
}