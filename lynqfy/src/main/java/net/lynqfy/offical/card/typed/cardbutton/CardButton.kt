package net.lynqfy.offical.card.typed.cardbutton

import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.model.Header

interface CardButton : LyCardAction {
    fun setHeaderInfo(header: Header)
}