package net.terme.offical.callbacks

import net.terme.offical.model.Item

interface OnItemClickListener {
    fun onItemClicked(index: Int, item: Item)
}