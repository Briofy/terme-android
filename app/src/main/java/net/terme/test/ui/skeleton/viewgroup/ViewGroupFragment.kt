package net.terme.test.ui.skeleton.viewgroup

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import net.terme.offical.skeleton.TermeSkeleton
import net.terme.offical.skeleton.TermeSkeletonLayout
import net.terme.test.R
import net.terme.test.ui.skeleton.MainPagerFragment
import net.terme.test.ui.skeleton.recyclerview.RecyclerViewListItem

class ViewGroupFragment : MainPagerFragment(R.layout.fragment_viewgroup, "ViewGroup") {

    override lateinit var skeleton: TermeSkeleton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = RecyclerViewListItem.DEMO.first()
        view.findViewById<ImageView>(R.id.wallpaperView).setImageResource(item.wallpaperResId)
        view.findViewById<ImageView>(R.id.avatarView).setImageResource(item.avatarResId)
        view.findViewById<TextView>(R.id.titleView).setText(item.titleResId)
        view.findViewById<TextView>(R.id.descriptionView).setText(item.descriptionResId)

        skeleton = view.findViewById<TermeSkeletonLayout>(R.id.skeletonLayout).apply { showSkeleton() }
    }
}