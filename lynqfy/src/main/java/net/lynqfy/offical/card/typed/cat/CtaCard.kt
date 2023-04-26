package net.lynqfy.offical.card.typed.cat

import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.model.Header

interface CtaCard : LyCardAction {
    fun setHeaderInfo(header: Header)
    fun setCatAction(callback: (isGoogle: Boolean) -> Unit)
}