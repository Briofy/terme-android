package net.terme.offical.card

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import com.google.android.material.card.MaterialCardView
import net.terme.offical.R
import net.terme.offical.card.typed.cardbutton.CardButtonIm
import net.terme.offical.card.typed.cardimage.CardImageIm
import net.terme.offical.card.typed.cardlink.CardLinkIm
import net.terme.offical.card.typed.cat.CtaCardIm
import net.terme.offical.card.typed.crypto.CryptoIm
import net.terme.offical.card.typed.ecommerce.EcommerceIm
import net.terme.offical.card.typed.testimonial.TestimonialIm
import net.terme.offical.card.typed.userprofile.UserProfileIm

open class TermeCardView : MaterialCardView {
    constructor(ctx: Context) : super(ctx, null) {
        initLyCardViewTheme(null)
    }
    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr) {
        initLyCardViewTheme(attr)
    }
    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(ctx,attr,defStyleAttr) {
        initLyCardViewTheme(attr, defStyleAttr)
    }
    fun getLyAction()  = mTermeCardActionUi
    private fun initLyCardViewTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.TermeCardView,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            val cardType = TypedValue()
            if (attributes.getValue(R.styleable.TermeCardView_type, cardType)) {
                mLyCardUiType = cardType.data

                when (cardType.data) {
                    /*"crypto typed" */      1 -> {
                    mTermeCardActionUi = CryptoIm(this, attributes, attrs, defStyleAttr)
                }
                    /*"testimonial"*/  2 -> {
                    mTermeCardActionUi = TestimonialIm(this, attributes, attrs, defStyleAttr)
                }
                    /*"pricing" */     3 -> {
                    //Pricing(this, attributes, attrs, defStyleAttr)
                }
                    /*"with_list"*/    4 -> {
                    //WithList(this, attributes, attrs, defStyleAttr)
                }
                    /*"form_inputs"*/  5 -> {
                    //FormInputs(this, attributes, attrs, defStyleAttr)
                }
                    /*"user_profile"*/ 6 -> {
                    mTermeCardActionUi =   UserProfileIm(this, attrs, defStyleAttr)
                }
                    /*"card_link"*/    7 -> {
                    mTermeCardActionUi =  CardLinkIm(this, attributes, attrs, defStyleAttr)
                }
                    /*"horizontal"*/   8 -> {
                    mTermeCardActionUi =   CardImageIm(this, attributes, attrs, defStyleAttr).apply {
                        disableButton()
                    }
                }
                    /*"ecommerce"*/    9 -> {
                    mTermeCardActionUi =  EcommerceIm(this, attrs, defStyleAttr)
                }
                    /*"card_image"*/  10 -> {
                    mTermeCardActionUi =   CardImageIm(this, attributes, attrs, defStyleAttr)
                }
                    /*"type11"*/      11 -> {
                    //NavTabs(this, attributes, attrs, defStyleAttr)
                }
                    /*"nav_tabs"*/    12 -> {
                    //NavTabs(this, attributes, attrs, defStyleAttr)
                }
                    /*"cta_card"*/    13 -> {
                    mTermeCardActionUi =  CtaCardIm(this, attributes, attrs, defStyleAttr)
                }
                    /*"card_button"*/ 14 -> {
                    mTermeCardActionUi = CardButtonIm(this, attributes, attrs, defStyleAttr)
                }
                }
                invalidate()
            }
            attributes.recycle()
        }

        radius = 18f
        useCompatPadding = true
    }

    private lateinit var mTermeCardActionUi: TermeCardAction
    private var mLyCardUiType: Int = 1
}