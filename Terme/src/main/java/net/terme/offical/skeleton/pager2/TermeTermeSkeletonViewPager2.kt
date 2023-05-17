package net.terme.offical.skeleton.pager2

import androidx.annotation.LayoutRes
import androidx.viewpager2.widget.ViewPager2
import net.terme.offical.skeleton.TermeTermeSkeleton
import net.terme.offical.skeleton.TermeSkeletonConfig
import net.terme.offical.skeleton.TermeSkeletonStyle
import net.terme.offical.skeleton.recyclerview.TermeSkeletonRecyclerViewAdapter

internal class TermeTermeSkeletonViewPager2(
    private val viewPager: ViewPager2,
    @LayoutRes layoutResId: Int,
    itemCount: Int,
    config: TermeSkeletonConfig
) : TermeTermeSkeleton, TermeSkeletonStyle by config {

    private val originalAdapter = viewPager.adapter
    private var skeletonAdapter = TermeSkeletonRecyclerViewAdapter(layoutResId, itemCount, config)

    init {
        config.addValueObserver { skeletonAdapter.notifyDataSetChanged() }
    }

    override fun showOriginal() {
        viewPager.adapter = originalAdapter
    }

    override fun showSkeleton() {
        viewPager.adapter = skeletonAdapter
    }

    override fun isSkeleton(): Boolean {
        return viewPager.adapter == skeletonAdapter
    }
}