package net.lynqfy.offical.drawer

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import com.google.android.material.navigation.NavigationView
import net.lynqfy.offical.R

class LyDrawer : NavigationView {

    constructor(ctx: Context) : super(ctx, null ) {
        initTheme(null)
    }
    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr ) {
        initTheme(attr)
    }
    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(ctx,attr) {
        initTheme(attr, defStyleAttr)
    }

    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

        isTopInsetScrimEnabled = true
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.LyDrawer,
                defStyleAttr,
                com.google.android.material.R.style.Widget_Material3_NavigationView
            )
            val cardType = TypedValue()
//            if (attributes.getValue(R.styleable.LyCardView_type, cardType)) {
//                mLyCardUiType = cardType.data
//
//                when (cardType.data) {
//                    /*"crypto typed" */      1 -> {
//                    mLyCardActionUi = CryptoIm(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"testimonial"*/  2 -> {
//                    mLyCardActionUi = TestimonialIm(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"pricing" */     3 -> {
//                    //Pricing(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"with_list"*/    4 -> {
//                    //WithList(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"form_inputs"*/  5 -> {
//                    //FormInputs(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"user_profile"*/ 6 -> {
//                    mLyCardActionUi =   UserProfileIm(this, attrs, defStyleAttr)
//                }
//                    /*"card_link"*/    7 -> {
//                    mLyCardActionUi =  CardLinkIm(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"horizontal"*/   8 -> {
//                    mLyCardActionUi =   CardImageIm(this, attributes, attrs, defStyleAttr).apply {
//                        disableButton()
//                    }
//                }
//                    /*"ecommerce"*/    9 -> {
//                    mLyCardActionUi =  EcommerceIm(this, attrs, defStyleAttr)
//                }
//                    /*"card_image"*/  10 -> {
//                    mLyCardActionUi =   CardImageIm(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"type11"*/      11 -> {
//                    //NavTabs(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"nav_tabs"*/    12 -> {
//                    //NavTabs(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"cta_card"*/    13 -> {
//                    mLyCardActionUi =  CtaCardIm(this, attributes, attrs, defStyleAttr)
//                }
//                    /*"card_button"*/ 14 -> {
//                    mLyCardActionUi = CardButtonIm(this, attributes, attrs, defStyleAttr)
//                }
//                }
//                invalidate()
//            }
            attributes.recycle()
        }

        //ly_card_background
    }

}