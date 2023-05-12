package net.terme.offical.tag

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.material.card.MaterialCardView
import net.terme.offical.R
import net.terme.offical.card.TermeCardAction
import net.terme.offical.databinding.LyTagUiBinding

class TermeTag : MaterialCardView {

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

        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.TermeTag,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )

            attributes.getString(R.styleable.TermeTag_tag)?.let {
                ui.tagTv.text = it
            }
            attributes.recycle()
        }
        radius = 18f
        useCompatPadding = true
    }

    fun getTagView() = ui.tagTv
    fun getParentView() = ui.root

    fun setClearAction(action : ()->Unit){
        ui.clear.setOnClickListener { action.invoke() }
    }
    private val ui by lazy {
        LyTagUiBinding.inflate(LayoutInflater.from(context), this, true)
    }
    private lateinit var mTermeCardActionUi: TermeCardAction
    private var mLyCardUiType: Int = 1
}