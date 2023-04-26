package net.lynqfy.offical

import android.content.Context
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import net.lynqfy.offical.base.LyView

class LyEditText : LyView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet?) : super(context, attr)
    constructor(context: Context, attr: AttributeSet?, style: Int) : super(context, attr, style)

    override fun getLayoutId() = R.layout.ly_edit_text

    lateinit var editText: EditText
    lateinit var tvTitle:TextView
    lateinit var imgSeen:ImageView

    private var title = "Title"
    private var hint = "Enter Your Hint"
    private var isPassword = false
    private var error = "Error"
    private var iconResId = R.drawable.ic_deaful_icon

    override fun init(mContext: Context, attr: AttributeSet?, defStyleAttr: Int) {
        super.init(mContext, attr, defStyleAttr)
        editText = mView.findViewById(R.id.edit_text)
        tvTitle = mView.findViewById(R.id.tv_title)
        imgSeen = mView.findViewById(R.id.img_seen)
//        imgIcon = mView.findViewById(R.id.img_icon)
//        line = mView.findViewById(R.id.line)

        attr?.apply {
            val typedArray = context.obtainStyledAttributes(
                this,
                R.styleable.LyEditText,
                defStyleAttr,
                R.style.Widget_LyEditText
            )

            title = typedArray.getString(R.styleable.LyEditText_title) ?: "Title"
            hint = typedArray.getString(R.styleable.LyEditText_hint) ?: "Enter Your Hint"
            isPassword = typedArray.getBoolean(R.styleable.LyEditText_isPassword, false)
            error = typedArray.getString(R.styleable.LyEditText_error) ?: "Error"
            iconResId = typedArray.getResourceId(R.styleable.LyEditText_EditTextIcon, 0)
            typedArray.recycle()
        }

        setValues()
    }

    override fun getMainView() = editText


    private var showPassword = true
    private fun setValues() {
        tvTitle.text = title
        editText.hint = hint

        if (isPassword) {
            imgSeen.visibility = VISIBLE
            editText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            editText.transformationMethod = PasswordTransformationMethod()

            imgSeen.setOnClickListener {
                showPassword = !showPassword
                if (showPassword)
                    editText.transformationMethod = PasswordTransformationMethod()
                else
                    editText.transformationMethod = null

            }

        } else {
            imgSeen.visibility = GONE
            editText.inputType = InputType.TYPE_CLASS_TEXT
            editText.transformationMethod = null

        }



    }

}
