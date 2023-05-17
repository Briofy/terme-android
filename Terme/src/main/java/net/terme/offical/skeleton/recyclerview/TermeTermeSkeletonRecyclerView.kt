package net.terme.offical.skeleton.recyclerview

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import net.terme.offical.skeleton.TermeTermeSkeleton
import net.terme.offical.skeleton.TermeSkeletonConfig
import net.terme.offical.skeleton.TermeSkeletonStyle

internal class TermeTermeSkeletonRecyclerView(
    private val recyclerView: RecyclerView,
    @LayoutRes layoutResId: Int,
    itemCount: Int,
    config: TermeSkeletonConfig
) : TermeTermeSkeleton, TermeSkeletonStyle by config {

    private val originalAdapter = recyclerView.adapter
    private var skeletonAdapter = TermeSkeletonRecyclerViewAdapter(layoutResId, itemCount, config)

    init {
        config.addValueObserver { skeletonAdapter.notifyDataSetChanged() }
    }

    override fun showOriginal() {
        recyclerView.adapter = originalAdapter
    }

    override fun showSkeleton() {
        recyclerView.adapter = skeletonAdapter
    }

    override fun isSkeleton(): Boolean {
        return recyclerView.adapter == skeletonAdapter
    }
}