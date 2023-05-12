package net.terme.offical

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import net.terme.offical.base.BaseAlert
import net.terme.offical.base.TermeView
import net.terme.offical.databinding.LyLayoutBinding

class LyAlert private constructor() : BaseAlert<LyLayoutBinding>(
    LyLayoutBinding::inflate
) {
    private var title: String = "Title"
    private var message: String = "Message"
    private var iconRes = R.drawable.ic_deaful_icon
    private var mCancelable = true
    private var type: AlertType = AlertType.SUCCESS
    private var buttonText: String = "OK"
    private var isIconEnable = true
    lateinit var mContext: Context
    private var onClickListener: AlertClickListener? = null


    class Builder(val context: Context) {
        private var title: String = "Title"
        private var message: String = "Message"
        private var iconRes = R.drawable.ic_deaful_icon
        private var cancelable = true
        private var type: AlertType = AlertType.SUCCESS
        private var buttonText: String = "OK"
        private var onClickListener: AlertClickListener? = null
        private var isIconEnable = true

        fun isIconEnable(enable: Boolean): Builder {
            this.isIconEnable = enable
            return this
        }

        fun setAlertClickListener(onClickListener: AlertClickListener?): Builder {
            this.onClickListener = onClickListener
            return this
        }

        fun setButtonText(buttonText: String): Builder {
            this.buttonText = buttonText
            return this
        }

        fun setType(type: AlertType): Builder {
            this.type = type
            return this
        }

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setIconRes(iconRes: Int): Builder {
            this.iconRes = iconRes
            return this
        }

        fun setCancelable(cancelable: Boolean): Builder {
            this.cancelable = cancelable
            return this
        }


        fun build(): LyAlert {
            val alert = LyAlert()
            alert.buttonText = buttonText
            alert.mCancelable = cancelable
            alert.iconRes = iconRes
            alert.message = message
            alert.type = type
            alert.title = title
            alert.onClickListener = onClickListener
            alert.isIconEnable = isIconEnable
            alert.mContext = context
            return alert
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        initDialog()
    }

    private fun initDialog() {
        viewBinding.apply {
            tvTitle.text = title
            tvMessage.text = message
            btn.button.text = buttonText
            this@LyAlert.isCancelable = mCancelable
            if (isIconEnable && iconRes > 0)
                imgIcon.setImageResource(iconRes)
            else
                imgIcon.isGone = true
            if (!mCancelable)
                imgClose.isGone = true
            else
                imgClose.isVisible = true

            val bgColor = when (type) {
                AlertType.SUCCESS -> R.color.alert_bg_success
                AlertType.ERROR -> R.color.alert_bg_error
                AlertType.INFO -> R.color.alert_bg_info
                AlertType.WARNING -> R.color.alert_bg_warning
                AlertType.MESSAGE -> R.color.alert_bg_message
            }
            val textColor = when (type) {
                AlertType.SUCCESS -> R.color.alert_text_success
                AlertType.ERROR -> R.color.alert_text_error
                AlertType.INFO -> R.color.alert_text_info
                AlertType.WARNING -> R.color.alert_text_warning
                AlertType.MESSAGE -> R.color.alert_text_message
            }
            val titleColor = when (type) {
                AlertType.SUCCESS -> R.color.alert_title_success
                AlertType.ERROR -> R.color.alert_title_error
                AlertType.INFO -> R.color.alert_title_info
                AlertType.WARNING -> R.color.alert_title_warning
                AlertType.MESSAGE -> R.color.alert_title_message
            }
            val buttonColor = when (type) {
                AlertType.SUCCESS -> R.color.alert_button_success
                AlertType.ERROR -> R.color.alert_button_error
                AlertType.INFO -> R.color.alert_button_info
                AlertType.WARNING -> R.color.alert_button_warning
                AlertType.MESSAGE -> R.color.alert_button_message
            }
            parent.backgroundTintList =
                ContextCompat.getColorStateList(mContext, bgColor)

            imgIcon.setColorFilter(
                ContextCompat.getColor(
                    mContext,
                    titleColor
                ), android.graphics.PorterDuff.Mode.SRC_IN
            )
            tvTitle.setTextColor(mContext.getColor(titleColor))
            tvMessage.setTextColor(mContext.getColor(textColor))
            btn.setTint(buttonColor)
            imgClose.setColorFilter(
                ContextCompat.getColor(
                    mContext, titleColor
                ), android.graphics.PorterDuff.Mode.SRC_IN
            )

        }
    }

    private fun onClick() {
        viewBinding.apply {

            imgClose.setOnClickListener {
                onClickListener?.onCancelClick()
                dismiss()
            }
            btn.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    onClickListener?.onConfirmClick()
                }

            }
        }
    }


//    private fun initDialog() {
//
//        arguments?.let {
//            val title = it.getString(DIALOG_TITLE) ?: ""
//            val description = it.getString(DIALOG_DESC) ?: ""
//            val addSecondButton = it.getBoolean(SECOND_BUTTON)
//            val titleConfirm = it.getString(TITLE_CONFIRM_BUTTON) ?: ""
//            val secondBtnTitle = it.getString(TITLE_SECOND_BUTTON) ?: ""
//            isCancelable = it.getBoolean(CANCELABLE)
//            val imageResId = it.getInt(IMAGE_RES_ID)
//            val dialogType = (it.getSerializable(DIALOG_TYPE) as? DialogType?) ?: DialogType.ERROR
//
//            viewBinding.apply {
//                if (dialogType == DialogType.ERROR) {
//                    labelTitle.setTextColor(
//                        ContextCompat.getColor(
//                            requireContext(),
//                            R.color.error_color
//                        )
//                    )
//                    btnOk.setBackgroundResource(R.drawable.bg_btn_dialog_red)
//                    btnCancel.setBackgroundResource(R.drawable.bg_btn_dialog_red)
//                    parent.setBackgroundResource(R.drawable.bg_item_red_top)
//                } else {
//                    labelTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
//                    btnOk.setBackgroundResource(R.drawable.bg_btn_dialog_green)
//                    btnCancel.setBackgroundResource(R.drawable.bg_btn_dialog_green)
//                    parent.setBackgroundResource(R.drawable.bg_item_green_top)
//                }
//
//                if (imageResId != 0)
//                    imgDialog.setImageResource(imageResId)
//
//                if (addSecondButton)
//                    btnCancel.visibility = View.VISIBLE
//
//                if (secondBtnTitle.isNotBlank())
//                    btnCancel.text = secondBtnTitle
//
//                if (titleConfirm.isNotBlank())
//                    btnOk.text = titleConfirm
//
//                if (title.isNotBlank())
//                    labelTitle.text = title
//
//                if (description.isNotBlank())
//                    labelDesc.text = description
//
//            }
//
//        }
//
//    }

//    private fun onClick() {
//        viewBinding.apply {
//            btnOk.setOnClickListener {
//                dismiss()
//                onClickListener?.onConfirmClick()
//            }
//            btnCancel.setOnClickListener {
//                dismiss()
//                onClickListener?.onCancelClick()
//
//            }
//        }
//    }


    companion object {
        const val DIALOG_TITLE = "DIALOG_TITLE"
        const val DIALOG_DESC = "DIALOG_DESC"
        const val SECOND_BUTTON = "SECOND_BUTTON"
        const val TITLE_CONFIRM_BUTTON = "TITLE_CONFIRM_BUTTON"
        const val TITLE_SECOND_BUTTON = "TITLE_SECOND_BUTTON"
        const val CANCELABLE = "CANCELABLE"
        const val IMAGE_RES_ID = "IMAGE_RES_ID"
        const val DIALOG_TYPE = "DIALOG_TYPE"


    }


}

enum class AlertType {
    SUCCESS, ERROR, WARNING, MESSAGE, INFO
}


interface AlertClickListener {
    fun onConfirmClick()
    fun onCancelClick()
}