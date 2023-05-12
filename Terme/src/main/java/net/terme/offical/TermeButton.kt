package net.terme.offical

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import net.terme.offical.R
import net.terme.offical.base.TermeView
import net.terme.offical.spinner.TermeSpinner
import kotlin.math.min


class TermeButton : TermeView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet?) : super(context, attr)
    constructor(context: Context, attr: AttributeSet?, style: Int) : super(context, attr, style)


    override fun getLayoutId() = R.layout.button

    lateinit var buttonText: String

    var buttonEnable: Boolean = true
    private var equalHeightAndWidth = false

    private var buttonTextColorRes = R.color.white_black

    private var backgroundType = ButtonBackgroundType.FILLED

    lateinit var buttonType: ButtonType
    private lateinit var buttonModel: ButtonModel
    private var buttonShape = ButtonShape.Rect

    private var bgColor = R.color.defualt_button_color
    private var progressColor = R.color.test_color
    private var animRawRes = R.raw.test_anim

    private var icon = R.drawable.ic_deaful_icon
     var startAnimationFirst: Boolean = false

    private var leftIcon: Int = -1

    private var rightIcon: Int = -1


    override fun init(mContext: Context, attr: AttributeSet?, defStyleAttr: Int) {
        super.init(mContext, attr, defStyleAttr)
        button = mView.findViewById(R.id.btn)
        progress = mView.findViewById(R.id.progress)
        anim = mView.findViewById(R.id.anim)

        attr?.apply {
            val typedArray = context.obtainStyledAttributes(
                this,
                R.styleable.TermeButton,
                defStyleAttr,
                R.style.Widget_TermeButton
            )
            buttonText = typedArray.getString(R.styleable.TermeButton_buttonText) ?: "Terme Button"
            bgColor = typedArray.getResourceId(
                R.styleable.TermeButton_ButtonBackground,
                R.color.defualt_button_color
            )
            progressColor = typedArray.getResourceId(
                R.styleable.TermeButton_progressColorTint,
                R.color.test_color
            )

            animRawRes = typedArray.getResourceId(
                R.styleable.TermeButton_anim_raw_res,
                R.raw.test_anim
            )

            icon = typedArray.getResourceId(R.styleable.TermeButton_icon, R.drawable.ic_deaful_icon)
            Log.i("CunstomBtnIconTest", "icon=$icon ")
            leftIcon = typedArray.getResourceId(R.styleable.TermeButton_leftIcon, -1)
            buttonTextColorRes = typedArray.getResourceId(
                R.styleable.TermeButton_buttonTextColorRes,
                R.color.white_black
            )
            buttonEnable = typedArray.getBoolean(R.styleable.TermeButton_buttonEnable, true)
            startAnimationFirst = typedArray.getBoolean(R.styleable.TermeButton_startAnimationFirst, false)

            equalHeightAndWidth =
                typedArray.getBoolean(R.styleable.TermeButton_equalHeightAndWidth, false)
            rightIcon = typedArray.getResourceId(R.styleable.TermeButton_rightIcon, -1)
            //   val typeValue =
            backgroundType = when (typedArray.getInt(R.styleable.TermeButton_backgroundType, 3)) {
                1 -> ButtonBackgroundType.FILLED
                2 -> ButtonBackgroundType.BORDERED
                else -> ButtonBackgroundType.FILLED
            }
            buttonType = when (typedArray.getInt(R.styleable.TermeButton_buttonType, 1)) {
                1 -> ButtonType.TEXT
                2 -> ButtonType.IMAGE
                else -> ButtonType.TEXT

            }

            buttonModel = when (typedArray.getInt(R.styleable.TermeButton_buttonModel, 1)) {
                1 -> ButtonModel.STANDARD_BUTTON
                2 -> ButtonModel.PROGRESS_BUTTON
                else -> ButtonModel.LOTTIE_BUTTON


            }
            buttonShape = when (typedArray.getInt(R.styleable.TermeButton_buttonShape, 1)) {
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
    lateinit var progress: TermeSpinner
    lateinit var anim: LottieAnimationView


    fun setTint(@ColorRes color: Int) {
        bgColor = color
        button.backgroundTintList = ContextCompat.getColorStateList(context, bgColor)
    }

    var isProgress = false
    var isAnimated = false

    fun startProgress() {
        if (buttonModel == ButtonModel.PROGRESS_BUTTON) {
            progress.visibility = VISIBLE
            if (buttonType == ButtonType.TEXT)
                button.text = ""
            else if (buttonType == ButtonType.IMAGE) {
                image?.visibility = View.GONE
            }
            isProgress = true
        }
    }

    fun stopProgress() {
        if (buttonModel == ButtonModel.PROGRESS_BUTTON) {
            progress.visibility = GONE

            if (buttonType == ButtonType.TEXT)
                button.text = buttonText
            else if (buttonType == ButtonType.IMAGE) {
                image?.visibility = View.VISIBLE
            }

            isProgress = false


        }
    }

    fun showAnimation() {
        if (buttonModel == ButtonModel.LOTTIE_BUTTON) {
            anim.visibility = VISIBLE
            if (buttonType == ButtonType.TEXT)
                button.text = ""
            else if (buttonType == ButtonType.IMAGE) {
                image?.visibility = View.GONE
            }
            isAnimated = true
        }
    }

    fun hideAnimation() {
        if (buttonModel == ButtonModel.LOTTIE_BUTTON) {
            anim.visibility = GONE

            if (buttonType == ButtonType.TEXT)
                button.text = buttonText
            else if (buttonType == ButtonType.IMAGE) {
                image?.visibility = View.VISIBLE
            }

            isAnimated = false


        }
    }

    private fun setValues() {

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
                                        button.layoutParams = FrameLayout.LayoutParams(size, size)

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
                                        button.layoutParams = FrameLayout.LayoutParams(size, size)

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
                image = ImageView(context)
                button.viewTreeObserver
                    .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                        override fun onGlobalLayout() {
                            button.viewTreeObserver.removeOnGlobalLayoutListener(this)
                            val size = (min(button.width, button.height) * 2) / 3
                            val lp = FrameLayout.LayoutParams(size, size)
                            lp.gravity = Gravity.CENTER
                            image?.layoutParams = lp

                        }
                    })
                image?.setImageResource(icon)
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

        if (buttonModel == ButtonModel.PROGRESS_BUTTON) {
            progress.setTintColorRes(progressColor)

            button.viewTreeObserver
                .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        button.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        val size = min(button.width, button.height)
                        val lp = FrameLayout.LayoutParams(size, size)
                        lp.gravity = Gravity.CENTER

                        progress.layoutParams = lp
                        progress.elevation = 500f
                        progress.translationZ = 900f
                    }
                })
        } else if (buttonModel == ButtonModel.LOTTIE_BUTTON) {
            anim.setAnimation(animRawRes)

            button.viewTreeObserver
                .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        button.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        val size = min(button.width, button.height)
                        val lp = FrameLayout.LayoutParams(size, size)
                        lp.gravity = Gravity.CENTER

                        anim.layoutParams = lp
                        anim.elevation = 500f
                        anim.translationZ = 900f
                    }
                })
            if (startAnimationFirst)
                showAnimation()
        }


    }

    var image: ImageView? = null

    enum class ButtonModel {
        STANDARD_BUTTON, PROGRESS_BUTTON, LOTTIE_BUTTON
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