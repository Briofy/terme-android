package net.lynqfy.offical.card.typed.ecommerce

import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import net.lynqfy.offical.R
import net.lynqfy.offical.databinding.LyEcommerceCardUiBinding
import net.lynqfy.offical.model.EcommerceInfo

internal class EcommerceIm(
    private val parent: ViewGroup,
    attr: AttributeSet,
    defStyleAttr: Int
) : Ecommerce {
    override fun setEcommerceInfo(info: EcommerceInfo) {
        ui.name.text = info.name
        ui.cost.text = buildString {
            append("\$")
            append((info.cast * 100).toInt() / 100)
        }
        ui.ratingValue.text = info.rating.toString()
        ui.rating.rating = info.rating
        ui.image.setImageDrawable(info.image)
    }

    override fun setAddCartAction(action: () -> Unit) {
        ui.addToCart.setOnClickListener {
            action.invoke()
        }
    }

    private fun initEcommerceTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att,
                R.styleable.LyEcommerce,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            attributes.getString(R.styleable.LyEcommerce_ecommerceName)?.let {
                ui.name.text = it
            }
            attributes.getFloat(R.styleable.LyEcommerce_ecommerceCast, 0f).let {
                ui.cost.text = buildString {
                    append("\$")
                    append((it * 100).toInt() / 100)
                }
            }

            attributes.getFloat(R.styleable.LyEcommerce_ecommerceRating, 0f).let {
                ui.ratingValue.text = it.toString()
                ui.rating.rating = it
            }

            attributes.getDrawable(R.styleable.LyEcommerce_ecommerceImage)?.let {
                ui.image.setImageDrawable(it)
            }

            attributes.recycle()
        }
    }

    private val ui by lazy {
        LyEcommerceCardUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    init {
        initEcommerceTheme(attr, defStyleAttr)
    }
}