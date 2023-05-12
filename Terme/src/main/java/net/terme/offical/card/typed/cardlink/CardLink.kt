package net.terme.offical.card.typed.cardlink

import net.terme.offical.card.TermeCardAction
import net.terme.offical.model.Header

interface CardLink : TermeCardAction {
    fun setHeaderInfo(header: Header)
    fun setExternalLinkInfo(title : String , callback: ()->Unit)
}