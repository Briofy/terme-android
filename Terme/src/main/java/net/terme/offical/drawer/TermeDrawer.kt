package net.terme.offical.drawer

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import com.google.android.material.navigation.NavigationView
import net.terme.offical.R

class TermeDrawer : NavigationView {

    constructor(ctx: Context) : super(ctx, null ) {
        initTheme(null)
    }
    constructor(mContext: Context, attr: AttributeSet?) : super(mContext, attr ) {
        initTheme(attr)
    }
    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(ctx,attr) {
        initTheme(attr, defStyleAttr)
    }

    private fun initTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {

        isTopInsetScrimEnabled = true
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = context.obtainStyledAttributes(
                att,
                R.styleable.TermeDrawer,
                defStyleAttr,
                com.google.android.material.R.style.Widget_Material3_NavigationView
            )

            attributes.recycle()
        }
    }

}