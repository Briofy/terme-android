package net.lynqfy.offical.radio

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.card.MaterialCardView
import net.lynqfy.offical.R
import net.lynqfy.offical.databinding.LyRadioUiBinding

class LyRadio : MaterialCardView {

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
        ui.radioBtn.setOnCheckedChangeListener(l)
    }

    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.LyRadio,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )

            ui.radioBtn.text = attributes.getString(R.styleable.LyRadio_radioName)
            ui.helperTv.text = attributes.getString(R.styleable.LyRadio_radioHelper)

            val isRadioDisable = attributes.getBoolean(R.styleable.LyRadio_radioDisable, false)
            if (isRadioDisable) {
//                ui.radioBtn.buttonDrawable =
//                    AppCompatResources.getDrawable(context, R.drawable.ic_radio_disable)
                ui.radioBtn.isEnabled = false
                ui.radioBtn.setTextColor(context.getColor(R.color.ly_card_content))
            } else {
                ui.radioBtn.setTextColor(context.getColor(R.color.ly_card_title))
//                ui.radioBtn.buttonDrawable =
//                    AppCompatResources.getDrawable(context, R.drawable.ic_radio_enable)
            }
            attributes.recycle()
        }

        radius = 18f
        useCompatPadding = true
        addView(ui.root)
    }

    private val ui by lazy {
        LyRadioUiBinding.inflate(LayoutInflater.from(context), this, false)
    }
}