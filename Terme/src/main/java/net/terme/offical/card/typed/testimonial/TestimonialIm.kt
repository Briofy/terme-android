package net.terme.offical.card.typed.testimonial

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import net.terme.offical.R
import net.terme.offical.databinding.LyTestimonialUiBinding
import net.terme.offical.model.Author
import net.terme.offical.model.TermeContent

internal class TestimonialIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    attr: AttributeSet,
    defStyleAttr: Int
) : Testimonial {

    override fun setContent(content: TermeContent) {
        ui.title.text = content.header.title
        ui.body.text = content.header.body
        initUi(content.author)
    }

    private fun initTestimonialTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att,
                R.styleable.TermeTestimonial,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            typedArray.getString(R.styleable.TermeCardView_header)?.let {
                ui.title.text = it
            }
            typedArray.getString(R.styleable.TermeCardView_body)?.let {
                ui.body.text = it
            }

            attributes.getString(R.styleable.TermeTestimonial_authorName)?.let {
                ui.author.authorName.text = it
            }
            attributes.getString(R.styleable.TermeTestimonial_authorText)?.let {
                ui.author.authorDes.text = it
            }

            attributes.getDrawable(R.styleable.TermeTestimonial_authorAvatar)?.let {
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