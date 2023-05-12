package net.terme.offical.card

import net.terme.offical.callbacks.OnItemClickListener

interface TermeCardAction {
    fun onButtonClicked(callback : ()->Unit){}
    fun onBadgeClicked(callback : ()->Unit){}
    fun onOnItemClickListener(listener : OnItemClickListener){}
}