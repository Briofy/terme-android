package net.lynqfy.offical.card.typed.ecommerce

import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.model.EcommerceInfo

interface Ecommerce : LyCardAction {
    fun setEcommerceInfo(info: EcommerceInfo)
    fun setAddCartAction(action: () -> Unit)
}