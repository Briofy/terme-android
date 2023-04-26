package net.lynqfy.offical.callbacks

import net.lynqfy.offical.model.Item

interface OnItemClickListener {
    fun onItemClicked(index: Int, item: Item)
}