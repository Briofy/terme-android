package net.terme.offical.card.typed.cat

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import net.terme.offical.R
import net.terme.offical.databinding.LyCtaCardUiBinding
import net.terme.offical.model.Header

internal class CtaCardIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int
) : CtaCard {
    override fun setHeaderInfo(header: Header) {
        ui.title.text = header.title
        ui.body.text = header.body
    }

    override fun setCatAction(callback: (isGoogle: Boolean) -> Unit) {
        ui.googlePlay.setOnClickListener {
            callback.invoke(true)
        }
        ui.apple.setOnClickListener {
            callback.invoke(false)
        }
    }

    private fun initCatCardTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att,
                R.styleable.TermeCardView,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            typedArray.getString(R.styleable.TermeCardView_header)?.let {
                ui.title.text = it
            }
            typedArray.getString(R.styleable.TermeCardView_body)?.let {
                ui.body.text = it
            }
            attributes.recycle()
        }
    }

    private val ui by lazy {
        LyCtaCardUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    init {
        initCatCardTheme(attr, defStyleAttr)
    }
}