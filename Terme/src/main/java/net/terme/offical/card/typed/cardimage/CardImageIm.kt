package net.terme.offical.card.typed.cardimage

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import net.terme.offical.R
import net.terme.offical.databinding.LyCardImageUiBinding
import net.terme.offical.model.Header

internal class CardImageIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int
) : CardImage {
    override fun setHeaderInfo(header: Header) {
        ui.cardButton.title.text = header.title
        ui.cardButton.body.text = header.body
    }

    override fun onButtonClicked(callback: () -> Unit) {
        ui.cardButton.actionButton.setOnClickListener {
            callback.invoke()
        }
    }

    override fun setImage(url: String) {

        val context = parent.context
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide
            .with(context)
            .load(url)
//            .centerCrop()
            .placeholder(circularProgressDrawable)
            .into(ui.image)
    }

    private fun initCardImageTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att,
                R.styleable.TermeCardButton,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            typedArray.getString(R.styleable.TermeCardView_header)?.let {
                ui.cardButton.title.text = it
            }
            typedArray.getString(R.styleable.TermeCardView_body)?.let {
                ui.cardButton.body.text = it
            }

            attributes.getString(R.styleable.TermeCardButton_actionButtonText)?.let {
                ui.cardButton.actionButton.text = it
            }
            attributes.getDrawable(R.styleable.TermeCardButton_actionButtonIconStart)?.let {
                ui.cardButton.actionButton.setCompoundDrawablesRelative(null, null, it, null)
            }
            attributes.recycle()
        }
    }
    fun disableButton() {
        ui.cardButton.actionButton.visibility = View.GONE
    }

    private val ui by lazy {
        LyCardImageUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    init {
        initCardImageTheme(attr, defStyleAttr)
    }
}