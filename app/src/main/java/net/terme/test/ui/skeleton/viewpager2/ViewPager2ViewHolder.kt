package net.terme.test.ui.skeleton.viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.terme.test.R
import net.terme.test.ui.skeleton.configuration.LayoutContainer
import net.terme.test.ui.skeleton.recyclerview.RecyclerViewListItem

class ViewPager2ViewHolder(
    parent: ViewGroup,
    private val view: View = LayoutInflater.from(parent.context)
        .inflate(R.layout.list_item_viewpager2, parent, false)
) : RecyclerView.ViewHolder(view), LayoutContainer {

    override val containerView: View
        get() = view

    fun bind(listItem: RecyclerViewListItem) {
        view.findViewById<ImageView>(R.id.wallpaperView).setImageResource(listItem.wallpaperResId)
        view.findViewById<ImageView>(R.id.avatarView).setImageResource(listItem.avatarResId)
         view.findViewById<TextView>(R.id.titleView).setText(listItem.titleResId)
         view.findViewById<TextView>(R.id.descriptionView).setText(listItem.descriptionResId)
    }
}