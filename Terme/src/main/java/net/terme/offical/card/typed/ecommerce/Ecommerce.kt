package net.terme.offical.card.typed.ecommerce

import net.terme.offical.card.TermeCardAction
import net.terme.offical.model.EcommerceInfo

interface Ecommerce : TermeCardAction {
    fun setEcommerceInfo(info: EcommerceInfo)
    fun setAddCartAction(action: () -> Unit)
}