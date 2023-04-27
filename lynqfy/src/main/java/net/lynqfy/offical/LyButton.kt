package net.lynqfy.offical

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import net.lynqfy.offical.base.LyView
import kotlin.math.min


class LyButton : LyView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet?) : super(context, attr)
    constructor(context: Context, attr: AttributeSet?, style: Int) : super(context, attr, style)


    override fun getLayoutId() = R.layout.button

    private var buttonText = "Ly Button"

    private var buttonEnable = true
    private var equalHeightAndWidth = false

    private var buttonTextColorRes = R.color.white_black

    private var backgroundType = ButtonBackgroundType.FILLED

    private var buttonType = ButtonType.TEXT
    private var buttonShape = ButtonShape.Rect

    private var bgColor = R.color.defualt_button_color

    private var icon = R.drawable.ic_deaful_icon

    private var leftIcon: Int = -1

    private var rightIcon: Int = -1


    override fun init(mContext: Context, attr: AttributeSet?, defStyleAttr: Int) {
        super.init(mContext, attr, defStyleAttr)
        button = mView.findViewById(R.id.btn)
        attr?.apply {
            val typedArray = context.obtainStyledAttributes(
                this,
                R.styleable.LyButton,
                defStyleAttr,
                R.style.Widget_LyButton
            )
            buttonText = typedArray.getString(R.styleable.LyButton_buttonText) ?: "Ly Button"
            bgColor = typedArray.getResourceId(
                R.styleable.LyButton_ButtonBackground,
                R.color.defualt_button_color
            )
            icon = typedArray.getResourceId(R.styleable.LyButton_icon, R.drawable.ic_deaful_icon)
            Log.i("CunstomBtnIconTest", "icon=$icon ")
            leftIcon = typedArray.getResourceId(R.styleable.LyButton_leftIcon, -1)
            buttonTextColorRes = typedArray.getResourceId(
                R.styleable.LyButton_buttonTextColorRes,
                R.color.white_black
            )
            buttonEnable = typedArray.getBoolean(R.styleable.LyButton_buttonEnable, true)
            equalHeightAndWidth =
                typedArray.getBoolean(R.styleable.LyButton_equalHeightAndWidth, false)
            rightIcon = typedArray.getResourceId(R.styleable.LyButton_rightIcon, -1)
            //   val typeValue =
            backgroundType = when (typedArray.getInt(R.styleable.LyButton_backgroundType, 3)) {
                1 -> ButtonBackgroundType.FILLED
                2 -> ButtonBackgroundType.BORDERED
                else -> ButtonBackgroundType.FILLED
            }
            buttonType = when (typedArray.getInt(R.styleable.LyButton_buttonType, 1)) {
                1 -> ButtonType.TEXT
                2 -> ButtonType.IMAGE
                else -> ButtonType.TEXT

            }

            buttonShape = when (typedArray.getInt(R.styleable.LyButton_buttonShape, 1)) {
                1 -> ButtonShape.Rect
                2 -> ButtonShape.Circle
                else -> ButtonShape.Rect


            }
            typedArray.recycle()

            setValues()
        }


    }

    override fun getMainView() = button

    lateinit var button: AppCompatButton


    fun setTint(@ColorRes color: Int) {
        bgColor = color
        button.backgroundTintList = ContextCompat.getColorStateList(context, bgColor)
    }

    private fun setValues() {
        Log.i("TestTagLyButton", "$backgroundType  $buttonShape  ${buttonText}  $buttonType equalHeightAndWidth=$equalHeightAndWidth")

        when (backgroundType) {
            ButtonBackgroundType.FILLED -> {
                when (buttonShape) {
                    ButtonShape.Rect -> {
                        button.setBackgroundResource(R.drawable.button_bg_rect)

                    }
                    ButtonShape.Circle -> {
                        if (equalHeightAndWidth)
                            button.viewTreeObserver
                                .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                                    override fun onGlobalLayout() {
                                        button.viewTreeObserver.removeOnGlobalLayoutListener(this)
                                        val size = maxOf(button.width, button.height)
                                        button.layoutParams = LinearLayout.LayoutParams(size, size)

                                    }
                                })

                        button.setBackgroundResource(R.drawable.button_bg_circle)

                    }
                }
            }
            ButtonBackgroundType.BORDERED -> {
                when (buttonShape) {
                    ButtonShape.Rect -> {
                        button.setBackgroundResource(R.drawable.button_bordered_bg_rect)

                    }
                    ButtonShape.Circle -> {
                        if (equalHeightAndWidth)
                            button.viewTreeObserver
                                .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                                    override fun onGlobalLayout() {
                                        button.viewTreeObserver.removeOnGlobalLayoutListener(this)
                                        val size = maxOf(button.width, button.height)
                                        button.layoutParams = LinearLayout.LayoutParams(size, size)

                                    }
                                })
                        button.setBackgroundResource(R.drawable.button_bordered_bg_circle)

                    }
                }
            }

        }
        when (buttonType) {
            ButtonType.IMAGE -> {
                button.text = ""
                val image = ImageView(context)
                button.viewTreeObserver
                    .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                        override fun onGlobalLayout() {
                            button.viewTreeObserver.removeOnGlobalLayoutListener(this)
                            val size = (min(button.width, button.height)*2) / 3
                            val lp = FrameLayout.LayoutParams(size, size)
                            lp.gravity = Gravity.CENTER
                            image.layoutParams = lp

                        }
                    })
                image.setImageResource(icon)
                addView(image)
            }
            ButtonType.TEXT -> {
                button.text = buttonText
                val leftIcon = if (leftIcon > 0) context.resources.getDrawable(leftIcon) else null
                val rightIcon =
                    if (rightIcon > 0) context.resources.getDrawable(rightIcon) else null
                if (leftIcon != null || rightIcon != null) {
                    rightIcon?.setBounds(0, 0, 60, 60);
                    leftIcon?.setBounds(0, 0, 60, 60);
                    button.setCompoundDrawables(leftIcon, null, rightIcon, null)
                }
            }
        }

        button.isEnabled = buttonEnable
        button.setTextColor(context.getColor(buttonTextColorRes))
        button.backgroundTintList = ContextCompat.getColorStateList(context, bgColor)
    }


    enum class ButtonType {
        TEXT, IMAGE
    }

    enum class ButtonShape {
        Circle, Rect
    }

    enum class ButtonBackgroundType {
        FILLED, BORDERED
    }


}