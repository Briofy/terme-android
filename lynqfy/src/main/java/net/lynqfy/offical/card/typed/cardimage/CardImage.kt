package net.lynqfy.offical.card.typed.cardimage

import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.model.Header

interface CardImage : LyCardAction{
    fun setHeaderInfo(header: Header)
    fun setImage(url: String)
}