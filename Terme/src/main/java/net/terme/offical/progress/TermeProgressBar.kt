package net.terme.offical.progress

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import com.google.android.material.card.MaterialCardView
import net.terme.offical.R
import net.terme.offical.databinding.LyProgressBarBinding

class TermeProgressBar : MaterialCardView, TermeBaseProgressBar.OnProgressBarChangeListener {
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

    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

        ui.progressBar.setOnProgressBarChangeListener(this)
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.TermeProgressBar,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            val isMode = attributes.getBoolean(R.styleable.TermeProgressBar_mode, false)
            if (isMode) {
                ui.progressBar.progressBackgroundTintList = ColorStateList.valueOf(
                    context.getColor(R.color.terme_progress_black)
                )
            }
            attributes.getInteger(R.styleable.TermeProgressBar_progressValue, 0).let {
                ui.progressBar.progress = it
            }
            attributes.getInteger(R.styleable.TermeProgressBar_maxValue, 100).let {
                ui.progressBar.max = it
            }
            val colorType = TypedValue()
            if (attributes.getValue(R.styleable.TermeProgressBar_colorName, colorType)) {

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
                ui.progressBarTxt.setTextColor(userColor)
                ui.progressBar.progressTintList = ColorStateList.valueOf(userColor)
            }


            attributes.recycle()
        }
        radius = 18f
        useCompatPadding = true
    }

    private val ui by lazy {
        LyProgressBarBinding.inflate(LayoutInflater.from(context), this, true)
    }

    override fun onProgressChanged(progress: Int) {
        post {
            ui.progressBarTxt.text = buildString {
                append("%")
                append(progress)
            }
        }
    }
}