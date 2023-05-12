package net.terme.offical.checkbox

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.checkbox.MaterialCheckBox
import net.terme.offical.R
import net.terme.offical.utils.ScalingDrawable
import timber.log.Timber

class TermeCheckBox : MaterialCheckBox {

    private var isInvalid = false
    private var isIndeterminate = false
    private var isRequired = false
    private var activeTextColor = Color.BLACK
    private var tintColor = Color.BLACK

    /** the check image  */
    private var checkImg: ScalingDrawable? = null

    /** original height of the check-box image  */
    private var origHeight = 0

    /** original padding-left  */
    private var origPadLeft = 0

    /** height set by the user directly  */
    private var height = 0f

    constructor(ctx: Context) : super(ctx, null) {
        initTheme(null)
    }

    constructor(mContext: Context, attr: AttributeSet) : super(mContext, attr) {
        initTheme(attr)
    }

    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        ctx,
        attr,
        defStyleAttr
    ) {
        initTheme(attr, defStyleAttr)
    }

    private fun initTheme(attr: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attr?.also {
            val attributes = context.obtainStyledAttributes(
                it, R.styleable.TermeCheckBox, defStyleAttr,
                com.google.android.material.R.style.Widget_Material3_CompoundButton_CheckBox
            )
            activeTextColor =
                attributes.getColor(R.styleable.TermeCheckBox_textColor, currentTextColor)
            tintColor = attributes.getColor(R.styleable.TermeCheckBox_tintColor, Color.BLUE)
            val sizeValue = TypedValue()
            if (attributes.getValue(R.styleable.TermeCheckBox_size, sizeValue)) {
                when (sizeValue.data) {
                    /*"small" */  1 -> scale(0.9f)
                    /*"medium"*/  2 -> scale(1f)
                    /*"large" */  3 -> scale(1.15f)
                    /*"xlarge"*/  4 -> scale(1.4f)
                }
                invalidate()
            }

            var label = attributes.getString(R.styleable.TermeCheckBox_label)
            if (label.isNullOrEmpty() || label.isEmpty()) {
                label = attributes.getString(R.styleable.TermeCheckBox_name)
            }
            text = label

            val value = TypedValue()
            if (attributes.getValue(R.styleable.TermeCheckBox_value, value)) {
                when (value.data) {
                    /*"number" */  1 -> Timber.e("Get Value Type number")
                    /*"string"*/  2 -> Timber.e("Get Size Type string")
                }
            }



            isEnabled = !attributes.getBoolean(R.styleable.TermeCheckBox_isDisabled, false)
            if (!isEnabled) {
                setTextColor(Color.GRAY)
            }

            isIndeterminate = attributes.getBoolean(R.styleable.TermeCheckBox_isIndeterminate, false)
            isInvalid = attributes.getBoolean(R.styleable.TermeCheckBox_isInvalid, false)
            isRequired = attributes.getBoolean(R.styleable.TermeCheckBox_isRequired, false)

            attributes.recycle()
        }
    }

    private fun scale(value: Float) {
        // get the original drawable and get its height
        getDefaultCheckBoxDrawable()?.also { origImg ->
            origHeight = origImg.intrinsicHeight.also { height = it.toFloat() }.toInt()
            // I tried origImg.mutate(), but that fails on Android 2.1 (NullPointerException)
            checkImg = ScalingDrawable(origImg, value)
        }
        origPadLeft = paddingLeft
        buttonDrawable = checkImg
    }

    /** set checkbox height in pixels directly  */
    override fun setHeight(height: Int) {
        this.height = height.toFloat()
        val scale = height.toFloat() / origHeight
        checkImg?.setScale(scale)

        // Make sure the text is not overlapping with the image.
        // This is unnecessary on Android 4.2.2, but very important on previous versions.
        setPadding((scale * origPadLeft).toInt(), 0, 0, 0)
        //   (may be unnecessary in your case)
        // super.setHeight(height)
    }

    override fun setTextColor(color: Int) {
        Timber.e("Set Text Color $color")
        super.setTextColor(color)
    }

    override fun setEnabled(enabled: Boolean) {
        Timber.e("Set Enabled $enabled")
        super.setEnabled(enabled)
        setTextColor(if (enabled) activeTextColor else Color.GRAY)
    }

    /** get the default drawable for the check box  */
    private fun getDefaultCheckBoxDrawable(): Drawable? {
        // starting with Honeycomb, retrieve the theme-based indicator as CheckBox button drawable
        val value = TypedValue()
        context.theme.resolveAttribute(android.R.attr.listChoiceIndicatorMultiple, value, true)
        val resID = value.resourceId
        return ResourcesCompat.getDrawable(resources, resID, null)
            ?.also { it.setTintList(ColorStateList.valueOf(tintColor)) }
    }
}