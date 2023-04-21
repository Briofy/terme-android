package net.lynqfy.offical.card.typed.cardlink

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import net.lynqfy.offical.R
import net.lynqfy.offical.databinding.LyCardLinkUiBinding
import net.lynqfy.offical.model.Header

class CardLinkIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int
) : CardLink {

    override fun setHeaderInfo(header: Header) {
        ui.title.text = header.title
        ui.body.text = header.body
    }

    override fun setExternalLinkInfo(title: String, callback: () -> Unit) {
        ui.linkAction.text = title
        ui.linkAction.setOnClickListener {
            callback.invoke()
        }
    }

    private fun initCardLinkTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att,
                R.styleable.LyCardLink,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            typedArray.getString(R.styleable.LyCardView_header)?.let {
                ui.title.text = it
            }
            typedArray.getString(R.styleable.LyCardView_body)?.let {
                ui.body.text = it
            }

            attributes.getString(R.styleable.LyCardLink_externalLinkText)?.let {
                ui.linkAction.text = it
            }
            attributes.recycle()
        }
    }

    private val ui by lazy {
        LyCardLinkUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    init {
        initCardLinkTheme(attr, defStyleAttr)
    }

}