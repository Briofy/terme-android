package net.terme.offical.card.typed.cardbutton

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import net.terme.offical.R
import net.terme.offical.databinding.LyCardButtonUiBinding
import net.terme.offical.model.Header

internal class CardButtonIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int
) : CardButton {
    override fun setHeaderInfo(header: Header) {
        ui.title.text = header.title
        ui.body.text = header.body
    }

    override fun onButtonClicked(callback: () -> Unit) {
        ui.actionButton.setOnClickListener {
            callback.invoke()
        }
    }


    private fun initTestimonialTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att,
                R.styleable.TermeCardButton,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            typedArray.getString(R.styleable.TermeCardView_header)?.let {
                ui.title.text = it
            }
            typedArray.getString(R.styleable.TermeCardView_body)?.let {
                ui.body.text = it
            }

            attributes.getString(R.styleable.TermeCardButton_actionButtonText)?.let {
                ui.actionButton.text = it
            }
            attributes.getDrawable(R.styleable.TermeCardButton_actionButtonIconStart)?.let {
                ui.actionButton.setCompoundDrawablesRelative(null, null, it, null)
            }
            attributes.recycle()
        }
    }

    private val ui by lazy {
        LyCardButtonUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    init {
        initTestimonialTheme(attr, defStyleAttr)
    }
}