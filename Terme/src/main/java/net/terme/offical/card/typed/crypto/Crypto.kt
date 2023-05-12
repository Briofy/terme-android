package net.terme.offical.card.typed.crypto

import net.terme.offical.card.TermeCardAction
import net.terme.offical.model.Header
import net.terme.offical.model.Item

interface Crypto : TermeCardAction {
    fun setHeaderInfo(header: Header)
    fun setHelperMessage(helper: String)
    fun addWallet(item: Item)
    fun addWallets(wallets: List<Item>)
}