package net.lynqfy.offical.card.typed.userprofile

import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.model.UserInfo

interface UserProfile : LyCardAction {

    fun setUserInfo(info: UserInfo)
    fun setAddFriendAction(action: () -> Unit)
    fun setMessageAction(action: () -> Unit)
    fun setMenuAction(action: () -> Unit)
}