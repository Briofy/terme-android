package net.terme.offical.spinner

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import com.google.android.material.card.MaterialCardView
import net.terme.offical.R
import net.terme.offical.databinding.LySpinnerUiBinding
import net.terme.offical.progress.TermeBaseProgressBar

class TermeSpinner : MaterialCardView, TermeBaseProgressBar.OnProgressBarChangeListener {
    constructor(ctx: Context) : super(ctx, null) {
        initTheme(null)
    }
    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr) {
        initTheme(attr)
    }
    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(ctx, attr, defStyleAttr) {
        initTheme(attr, defStyleAttr)
    }
    override fun onProgressChanged(progress: Int) {
//        post {
//            ui.progressBarTxt.text = buildString {
//                append("%")
//                append(progress)
//            }
//        }
    }
    fun setTintColorRes(tiniColor: Int) {
        this.tiniColor = tiniColor
        refreshTintColor()
    }

    private var tiniColor: Int = 0
    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        setCardBackgroundColor(context.getColor(R.color.transparent))
        ui.progressBar.setOnProgressBarChangeListener(this)
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.TermeSpinner,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            val isMode = attributes.getBoolean(R.styleable.TermeSpinner_spinner_mode, false)

            tiniColor = attributes.getResourceId(
                R.styleable.TermeSpinner_spinner_tint,
                0
            )
            if (isMode) {
                ui.progressBar.progressBackgroundTintList = ColorStateList.valueOf(
                    context.getColor(R.color.terme_progress_black)
                )
            }
            val colorType = TypedValue()
            if (attributes.getValue(R.styleable.TermeSpinner_spinnerColorName, colorType)) {

                val userColor = when (colorType.data) {
                    /*"Indigo" */ 1 -> {
                        context.getColor(R.color.terme_progress_indigo)
                    }
                    /*"Pink"*/  2 -> {
                        context.getColor(R.color.terme_progress_pink)
                    }
                    /*"Yellow" */ 3 -> {
                        context.getColor(R.color.terme_progress_yellow)
                    }
                    /*"Purple"*/    4 -> {
                        context.getColor(R.color.terme_progress_purple)
                    }
                    /*"Orange"*/  5 -> {
                        context.getColor(R.color.terme_progress_orange)
                    }
                    /*"Dark"*/ 6 -> {
                        context.getColor(R.color.terme_progress_dark)
                    }
                    /*"Green"*/    7 -> {
                        context.getColor(R.color.terme_progress_green)
                    }
                    /*"Primary"*/   8 -> {
                        context.getColor(R.color.terme_progress_primary)
                    }

                    else -> {
                        context.getColor(R.color.terme_progress_primary)
                    }
                }
//              ui.progressBarTxt.setTextColor(userColor)
                ui.progressBar.indeterminateTintList = ColorStateList.valueOf(userColor)
                refreshTintColor()

            }


            attributes.recycle()
        }
        radius = 100f
        useCompatPadding = true
    }


    private fun refreshTintColor() {
        if (tiniColor>0) {
            ui.progressBar.indeterminateDrawable.setColorFilter(
                context.getColor(tiniColor),
                android.graphics.PorterDuff.Mode.MULTIPLY
            )
        }
    }
    private val ui by lazy {
        LySpinnerUiBinding.inflate(LayoutInflater.from(context), this, true)
    }

}