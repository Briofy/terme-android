package net.lynqfy.offical.card.typed.testimonial

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import net.lynqfy.offical.R
import net.lynqfy.offical.databinding.LyTestimonialUiBinding
import net.lynqfy.offical.model.Author
import net.lynqfy.offical.model.LyContent

internal class TestimonialIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int
) : Testimonial {

    override fun setContent(content: LyContent) {
        ui.title.text = content.header.title
        ui.body.text = content.header.body
        initUi(content.author)
    }

    private fun initTestimonialTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att,
                R.styleable.LyTestimonial,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            typedArray.getString(R.styleable.LyCardView_header)?.let {
                ui.title.text = it
            }
            typedArray.getString(R.styleable.LyCardView_body)?.let {
                ui.body.text = it
            }

            attributes.getString(R.styleable.LyTestimonial_authorName)?.let {
                ui.author.authorName.text = it
            }
            attributes.getString(R.styleable.LyTestimonial_authorText)?.let {
                ui.author.authorDes.text = it
            }

            attributes.getDrawable(R.styleable.LyTestimonial_authorAvatar)?.let {
                ui.author.authorIcon.setImageDrawable(it)
            }
            attributes.recycle()
        }
    }

    private fun initUi(author: Author) {
        ui.author.apply {
            root.setOnClickListener {
                Toast.makeText(it.context, "You Clicked : ${author.info.title}", Toast.LENGTH_LONG)
                    .show()
            }
            authorName.text = author.info.title
            authorDes.text = author.info.body

            author.avatar?.let {
                authorIcon.setImageDrawable(it)
            }
        }
    }


    private val ui by lazy {
        LyTestimonialUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    init {
        initTestimonialTheme(attr, defStyleAttr)
    }
}