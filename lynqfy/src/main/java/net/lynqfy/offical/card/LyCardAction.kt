package net.lynqfy.offical.card

import net.lynqfy.offical.callbacks.OnItemClickListener

interface LyCardAction {
    fun onButtonClicked(callback : ()->Unit){}
    fun onBadgeClicked(callback : ()->Unit){}
    fun onOnItemClickListener(listener : OnItemClickListener){}
}