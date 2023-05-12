package net.terme.offical.card.typed.userprofile

import net.terme.offical.card.TermeCardAction
import net.terme.offical.model.UserInfo

interface UserProfile : TermeCardAction {

    fun setUserInfo(info: UserInfo)
    fun setAddFriendAction(action: () -> Unit)
    fun setMessageAction(action: () -> Unit)
    fun setMenuAction(action: () -> Unit)
}