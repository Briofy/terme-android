package net.terme.offical

import android.content.Context
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import net.terme.offical.R
import net.terme.offical.base.TermeView


class TermeEditText : TermeView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet?) : super(context, attr)
    constructor(context: Context, attr: AttributeSet?, style: Int) : super(context, attr, style)

    override fun getLayoutId() = R.layout.ly_edit_text

    lateinit var editText: EditText
    lateinit var tvTitle: TextView
    lateinit var searchButton: TermeButton
    lateinit var imgSeen: ImageView
    lateinit var notSeen: View
    private var title = "Title"
    private var hint = "Enter Your Hint"
    private var error = "Error"
    private var iconResId = R.drawable.ic_deaful_icon
    private var type = EditTextType.NORMAL

    enum class EditTextType {
        NORMAL, PASSWORD, SEARCH
    }

    override fun init(mContext: Context, attr: AttributeSet?, defStyleAttr: Int) {
        super.init(mContext, attr, defStyleAttr)
        editText = mView.findViewById(R.id.edit_text)
        tvTitle = mView.findViewById(R.id.tv_title)
        imgSeen = mView.findViewById(R.id.img_seen)
        notSeen = mView.findViewById(R.id.not_seen)
        searchButton = mView.findViewById(R.id.searchBtn)
//        imgIcon = mView.findViewById(R.id.img_icon)
//        line = mView.findViewById(R.id.line)

        attr?.apply {
            val typedArray = context.obtainStyledAttributes(
                this,
                R.styleable.TermeEditText,
                defStyleAttr,
                R.style.Widget_TermeEditText
            )

            title = typedArray.getString(R.styleable.TermeEditText_title) ?: "Title"
            hint = typedArray.getString(R.styleable.TermeEditText_hint) ?: "Enter Your Hint"
            type = when (typedArray.getInt(R.styleable.TermeEditText_terme_type, 1)) {
                1 -> EditTextType.NORMAL
                2 -> EditTextType.PASSWORD
                3 -> EditTextType.SEARCH
                else -> EditTextType.NORMAL
            }
            error = typedArray.getString(R.styleable.TermeEditText_error) ?: "Error"
            iconResId = typedArray.getResourceId(R.styleable.TermeEditText_EditTextIcon, 0)
            typedArray.recycle()
        }

        setValues()
    }

    override fun getMainView() = editText


    private var showPassword = true
    private fun setValues() {
        tvTitle.text = title
        editText.hint = hint
        notSeen.isVisible = false

        when (type) {
            EditTextType.NORMAL -> {
                imgSeen.visibility = GONE
                editText.inputType = InputType.TYPE_CLASS_TEXT
                editText.transformationMethod = null
                searchButton.isGone = true

            }
            EditTextType.SEARCH -> {
                searchButton.isVisible = true
                val img = context.resources.getDrawable(R.drawable.ic_search)
                editText.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
            }
            EditTextType.PASSWORD -> {
                searchButton.isGone = true

                imgSeen.visibility = VISIBLE
                editText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                editText.transformationMethod = PasswordTransformationMethod()
                notSeen.isVisible = false

                imgSeen.setOnClickListener {
                    showPassword = !showPassword
                    if (showPassword) {
                        editText.transformationMethod = PasswordTransformationMethod()
                        notSeen.isVisible = false

                    } else {
                        editText.transformationMethod = null
                        notSeen.isVisible = true

                    }
                }
            }
        }


    }

}
