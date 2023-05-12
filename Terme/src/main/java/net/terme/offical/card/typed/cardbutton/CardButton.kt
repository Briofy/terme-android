package net.terme.offical.card.typed.cardbutton

import net.terme.offical.card.TermeCardAction
import net.terme.offical.model.Header

interface CardButton : TermeCardAction {
    fun setHeaderInfo(header: Header)
}