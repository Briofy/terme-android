package net.lynqfy.offical.card

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import com.google.android.material.card.MaterialCardView
import net.lynqfy.offical.R
import net.lynqfy.offical.card.typed.cardbutton.CardButtonIm
import net.lynqfy.offical.card.typed.crypto.CryptoIm
import net.lynqfy.offical.card.typed.testimonial.TestimonialIm

open class LyCardView : MaterialCardView {

    constructor(ctx: Context) : super(ctx, null) {
        initLyCardViewTheme(null)
    }

    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr) {
        initLyCardViewTheme(attr)
    }

    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        ctx,
        attr,
        defStyleAttr
    ) {
        initLyCardViewTheme(attr, defStyleAttr)
    }

    private fun initLyCardViewTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

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
                when (cardType.data) {
                    /*"crypto typed" */      1 -> {
                    CryptoIm(this, attributes, attrs, defStyleAttr)
                }
                    /*"testimonial"*/  2 -> {
                    TestimonialIm(this, attributes, attrs, defStyleAttr)
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
                    //UserProfile(this, attributes, attrs, defStyleAttr)
                }
                    /*"card_link"*/    7 -> {
                    //CardLink(this, attributes, attrs, defStyleAttr)
                }
                    /*"horizontal"*/   8 -> {
                    //Horizontal(this, attributes, attrs, defStyleAttr)
                }
                    /*"ecommerce"*/    9 -> {
                    //Ecommerce(this, attributes, attrs, defStyleAttr)
                }
                    /*"card_image"*/  10 -> {
                    //CardImage(this, attributes, attrs, defStyleAttr)
                }
                    /*"type11"*/      11 -> {
                    //NavTabs(this, attributes, attrs, defStyleAttr)
                }
                    /*"nav_tabs"*/    12 -> {
                    //NavTabs(this, attributes, attrs, defStyleAttr)
                }
                    /*"cta_card"*/    13 -> {
                    //CTACard(this, attributes, attrs, defStyleAttr)
                }
                    /*"card_button"*/ 14 -> {
                    CardButtonIm(this, attributes, attrs, defStyleAttr)
                }
                }
                invalidate()
            }
            attributes.recycle()
        }

        radius = 18f
        useCompatPadding = true
    }

}