package net.lynqfy.offical.card.typed.cardlink

import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.model.Header

interface CardLink : LyCardAction {
    fun setHeaderInfo(header: Header)
    fun setExternalLinkInfo(title : String , callback: ()->Unit)
}