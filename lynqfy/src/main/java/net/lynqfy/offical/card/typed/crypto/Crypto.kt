package net.lynqfy.offical.card.typed.crypto

import net.lynqfy.offical.callbacks.OnItemClickListener
import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.model.Header
import net.lynqfy.offical.model.Item

interface Crypto : LyCardAction {
    fun setHeaderInfo(header: Header)
    fun setHelperMessage(helper: String)
    fun addWallet(item: Item)
    fun addWallets(wallets: List<Item>)
}