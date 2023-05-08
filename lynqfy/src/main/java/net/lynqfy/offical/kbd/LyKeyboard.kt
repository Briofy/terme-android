package net.lynqfy.offical.kbd

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import net.lynqfy.offical.R
import net.lynqfy.offical.utils.Utils

class LyKeyboard : MaterialCardView {

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
                R.styleable.LyKeyboard,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            val keyType = TypedValue()
            if (attributes.getValue(R.styleable.LyKeyboard_keyType, keyType)) {
                when (keyType.data) {
                    /*"arrow left "*/ 1 -> {
                    mIcon.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.arrow_left,
                            null
                        )
                    )
                    addView(mIcon)
                }
                    /*"arrow right"*/ 2 -> {
                    mIcon.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.arrow_right,
                            null
                        )
                    )
                    addView(mIcon)
                }
                    /*"arrow up   "*/ 3 -> {
                    mIcon.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.arrow_up,
                            null
                        )
                    )
                    addView(mIcon)
                }
                    /*"arrow down "*/ 4 -> {
                    mIcon.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.arrow_down,
                            null
                        )
                    )
                    addView(mIcon)
                }
                    /*"text"*/  else -> {
                    attributes.getString(R.styleable.LyKeyboard_keyText)?.let {
                        mTextView.text = it
                    }
                    addView(mTextView)
                }
                }
            }
            attributes.getColor(R.styleable.LyKeyboard_android_keyBackground, mBackgroundColor)
                .let {
                    setCardBackgroundColor(it)
                }

            attributes.getColor(R.styleable.LyKeyboard_android_keyTextColor, mTextColor).let {
                mTextView.setTextColor(it)
            }
            attributes.recycle()
        }
        radius = 18f
        useCompatPadding = true
    }

    private val mTextView by lazy {
        MaterialTextView(context).apply {
            val dp8 = Utils.dpToPx(8f, context)
            val dp6 = Utils.dpToPx(6f, context)
            setPadding(dp8 ,dp6,dp8,dp6)
            minimumWidth = Utils.dpToPx(32f, context)
            maxHeight = Utils.dpToPx(30f, context)
        }
    }
    private val mIcon by lazy {
        ImageView(context).apply {
            minimumWidth = Utils.dpToPx(32f, context)
            maxHeight = Utils.dpToPx(30f, context)
        }
    }
    private var mBackgroundColor = resources.getColor(R.color.ly_card_background, null)
    private var mTextColor = resources.getColor(R.color.ly_card_title, null)
}