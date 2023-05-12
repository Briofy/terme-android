package net.terme.offical.card.typed.cardimage

import net.terme.offical.card.TermeCardAction
import net.terme.offical.model.Header

interface CardImage : TermeCardAction{
    fun setHeaderInfo(header: Header)
    fun setImage(url: String)
}