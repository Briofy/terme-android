package net.terme.offical.radio

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import android.widget.LinearLayout
import com.google.android.material.radiobutton.MaterialRadioButton
import net.terme.offical.R
import net.terme.offical.databinding.LyRadioUiBinding

class TermeRadio : LinearLayout {

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

    fun setOnCheckedChangeListener(l: CompoundButton.OnCheckedChangeListener) {
        radioBtn.setOnCheckedChangeListener(l)
    }

    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.

        radioBtn =  MaterialRadioButton(context,attrs)

        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.TermeRadio,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )

            radioBtn.text = attributes.getString(R.styleable.TermeRadio_radioName)
            ui.helperTv.text = attributes.getString(R.styleable.TermeRadio_radioHelper)

            val isRadioDisable = attributes.getBoolean(R.styleable.TermeRadio_radioDisable, false)
            if (isRadioDisable) {
                radioBtn.isEnabled = false
                radioBtn.setTextColor(context.getColor(R.color.terme_card_content))
            } else {
                radioBtn.setTextColor(context.getColor(R.color.terme_card_title))
            }
            attributes.recycle()
        }

        ui.radioParent.addView(radioBtn)
        addView(ui.root)
    }

    fun isChecked() = radioBtn.isChecked
    fun setChecked(v: Boolean) {
        radioBtn.isChecked = v
    }

    fun getHelper(): CharSequence? = ui.helperTv.text

    private lateinit var radioBtn  : MaterialRadioButton

    private val ui by lazy {
        LyRadioUiBinding.inflate(LayoutInflater.from(context), this, false)
    }
}