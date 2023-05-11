package net.lynqfy.offical.badge

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.ShapeAppearanceModel
import net.lynqfy.offical.R
import net.lynqfy.offical.databinding.LyBadgeUiBinding
import net.lynqfy.offical.utils.Utils

class LyBadge : MaterialCardView {
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
                R.styleable.LyBadge,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            bTintColor = ColorStateList.valueOf(
                attributes.getColor(
                    R.styleable.LyBadge_bTintColor,
                    ResourcesCompat.getColor(resources, R.color.ly_card_title, null)
                )
            )
            bBackgroundColor = ColorStateList.valueOf(
                attributes.getColor(
                    R.styleable.LyBadge_bBackgroundColor,
                    ResourcesCompat.getColor(resources, R.color.ly_card_background, null)
                )
            )

            ui.clear.imageTintList = bTintColor
            ui.text.setTextColor(bTintColor)
            ui.clock.imageTintList = bTintColor
            setCardBackgroundColor(bBackgroundColor)

            val badgeType = TypedValue()
            if (attributes.getValue(R.styleable.LyBadge_badgeType, badgeType)) {

                when (badgeType.data) {
                    1 -> {

                        shapeAppearanceModel = ShapeAppearanceModel.builder(
                            context,
                            R.style.CircularShapeAppearance,
                            R.style.CircularShapeAppearance
                        ).build()
                        ui.root.setPadding(2)
                        ui.text.setPadding(Utils.dpToPx(2f,context))

                        val d24 = Utils.dpToPx(28f,context)
                        ui.text.width = d24
                        ui.text.height = d24

                        ui.clear.visibility = GONE
                        ui.clock.visibility = GONE
                        attributes.getString(R.styleable.LyBadge_bText)?.let {
                            ui.text.text = it
                        }
                    }
                    2 -> {
                        shapeAppearanceModel = ShapeAppearanceModel.builder(
                            context,
                            R.style.CircularShapeAppearance,
                            R.style.CircularShapeAppearance
                        ).build()
                        ui.root.setPadding(2)
                        ui.clear.visibility = GONE
                        ui.text.visibility = GONE
                    }
                    else -> {
                        radius = 18f
                        attributes.getString(R.styleable.LyBadge_bText)?.let {
                            ui.text.text = it
                        }
                    }
                }
            }
            attributes.recycle()
        }


        useCompatPadding = true
    }

    private var bTintColor =
        ColorStateList.valueOf(ResourcesCompat.getColor(resources, R.color.ly_card_title, null))
    private var bBackgroundColor = ColorStateList.valueOf(
        ResourcesCompat.getColor(
            resources,
            R.color.ly_card_background,
            null
        )
    )
    private val ui by lazy {
        LyBadgeUiBinding.inflate(LayoutInflater.from(context), this, true)
    }
}