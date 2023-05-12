package net.terme.offical.navbar.type.cta

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.terme.offical.R
import net.terme.offical.databinding.LyNavBarUiBinding
import net.terme.offical.navbar.ButtonCallback
import net.terme.offical.navbar.MenuCallback
import net.terme.offical.navbar.type.LyNavBarType

class CTAButtonIm(
    private val parent: ViewGroup,
    private val typedArray: TypedArray,
    private val attr: AttributeSet,
    private val defStyleAttr: Int, override var type: LyNavBarType
) : CTAButton {

    override var onButtonAction: ButtonCallback? = null
    override var onMenuAction: MenuCallback? = null

    private fun showJustMenu() {
        ui.apply {
            navButton.visibility = View.GONE
            navLogin.visibility = View.GONE
            navMenu.visibility = View.VISIBLE
            navMenu.setOnClickListener {
                onMenuAction?.invoke()
            }
        }
    }

    private fun showMenuWithButton() {
        ui.apply {
            navButton.visibility = View.VISIBLE
            navButton.button.setText(R.string.sing_up_free)
            navLogin.visibility = View.GONE
            navMenu.visibility = View.VISIBLE
            navButton.button.setOnClickListener {
                onButtonAction?.invoke()
            }
            navMenu.setOnClickListener {
                onMenuAction?.invoke()
            }
        }
    }

    override fun initUI() {
        initTheme(attr, defStyleAttr)
        when (type) {
            LyNavBarType.CTADropdown -> showMenuWithButton()
            LyNavBarType.LogoCTA -> showMenuWithButton()
//                LyNavBarType.LanguageSearch ->  showJustMenu()
//                LyNavBarType.WithCTAButton ->  showJustMenu()
//                LyNavBarType.CenteredLinks ->  showJustMenu()
            else -> showJustMenu()
        }
    }

    private val ui by lazy {
        LyNavBarUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    override fun initTheme(attrs: AttributeSet?, defStyleAttr: Int) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
//        attrs?.also { att ->
//            val attributes = parent.context.obtainStyledAttributes(
//                att, R.styleable.LyCrypto, defStyleAttr, com.google.android.material.R.style.Widget_MaterialComponents_CardView
//            )
//            typedArray.getString(R.styleable.LyCardView_header)?.let {
            //ui.title.text = it
//            }
//            typedArray.getString(R.styleable.LyCardView_body)?.let {
            //ui.body.text = it
//            }
//            attributes.getString(R.styleable.LyCrypto_helperText)?.let {
//                ui.helper.text = it
//            }
//            attributes.recycle()
//        }
    }
}