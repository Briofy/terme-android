package net.lynqfy.offical.progress

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ProgressBar
import net.lynqfy.offical.R
import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.card.typed.cardbutton.CardButtonIm
import net.lynqfy.offical.card.typed.cardimage.CardImageIm
import net.lynqfy.offical.card.typed.cardlink.CardLinkIm
import net.lynqfy.offical.card.typed.cat.CtaCardIm
import net.lynqfy.offical.card.typed.crypto.CryptoIm
import net.lynqfy.offical.card.typed.ecommerce.EcommerceIm
import net.lynqfy.offical.card.typed.testimonial.TestimonialIm
import net.lynqfy.offical.card.typed.userprofile.UserProfileIm

class LyProgressBar : ProgressBar {
    constructor(ctx: Context) : super(ctx, null) {
        initTheme(null)
    }

    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr) {
        initTheme(attr)
    }

    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        ctx,
        attr,
        defStyleAttr
    ) {
        initTheme(attr, defStyleAttr)
    }
    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.LyCardView,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            val cardType = TypedValue()
            if (attributes.getValue(R.styleable.LyCardView_type, cardType)) {
                mLyCardUiType = cardType.data

                when (cardType.data) {
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
                }
                invalidate()
            }
            attributes.recycle()
        }

//        radius = 18f
//        useCompatPadding = true
    }


    private lateinit var mLyCardActionUi: LyCardAction
    private var mLyCardUiType: Int = 1
}