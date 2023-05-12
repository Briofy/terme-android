package net.terme.offical.card.typed.cat

import net.terme.offical.card.TermeCardAction
import net.terme.offical.model.Header

interface CtaCard : TermeCardAction {
    fun setHeaderInfo(header: Header)
    fun setCatAction(callback: (isGoogle: Boolean) -> Unit)
}