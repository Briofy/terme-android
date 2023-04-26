package net.lynqfy.offical.card.typed.userprofile

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import net.lynqfy.offical.R
import net.lynqfy.offical.databinding.LyUserProfileUiBinding
import net.lynqfy.offical.model.UserInfo

internal class UserProfileIm(
    private val parent: ViewGroup,
    attr: AttributeSet,
    defStyleAttr: Int
) : UserProfile {

    override fun setUserInfo(info: UserInfo) {
        ui.userName.text = info.name
        ui.userWork.text = info.dic
        ui.userImage.setImageDrawable(info.avatar)
    }

    override fun setAddFriendAction(action: () -> Unit) {
        ui.addFriend.setOnClickListener { action.invoke() }
    }

    override fun setMessageAction(action: () -> Unit) {
        ui.message.setOnClickListener { action.invoke() }
    }

    override fun setMenuAction(action: () -> Unit) {
        ui.dotMenu.setOnClickListener { action.invoke() }
    }

    private fun initUserProfileTheme(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        // Ensure we are using the correctly themed context rather than the context that was passed in.
        attrs?.also { att ->
            val attributes = parent.context.obtainStyledAttributes(
                att,
                R.styleable.LyUserProfile,
                defStyleAttr,
                com.google.android.material.R.style.Widget_MaterialComponents_CardView
            )
            attributes.getString(R.styleable.LyUserProfile_userName)?.let {
                ui.userName.text = it
            }
            attributes.getString(R.styleable.LyUserProfile_userWork)?.let {
                ui.userWork.text = it
            }

            attributes.getDrawable(R.styleable.LyUserProfile_userImage)?.let {
                ui.userImage.setImageDrawable(it)
            }

            attributes.recycle()
        }
    }

    private val ui by lazy {
        LyUserProfileUiBinding.inflate(LayoutInflater.from(parent.context), parent, true)
    }

    init {
        initUserProfileTheme(attr, defStyleAttr)
    }
}