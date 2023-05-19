package net.terme.offical.skeleton

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import net.terme.offical.skeleton.pager2.TermeSkeletonViewPager2
import net.terme.offical.skeleton.recyclerview.TermeSkeletonRecyclerView

private const val LIST_ITEM_COUNT_DEFAULT = 3

@JvmOverloads
fun View.createSkeleton(
    config: TermeSkeletonConfig = TermeSkeletonConfig.default(context)
): TermeSkeleton {
    // If this View already has a parent, we need to replace it with the TermeSkeletonLayout
    val parent = (parent as? ViewGroup)
    val index = parent?.indexOfChild(this) ?: 0
    val params = layoutParams

    parent?.removeView(this)

    val skeleton = TermeSkeletonLayout(this, config)

    if (params != null) {
        skeleton.layoutParams = params
    }
    parent?.addView(skeleton, index)

    return skeleton
}

@JvmOverloads
fun RecyclerView.applySkeleton(
    @LayoutRes listItemLayoutResId: Int,
    itemCount: Int = LIST_ITEM_COUNT_DEFAULT,
    config: TermeSkeletonConfig = TermeSkeletonConfig.default(context)
): TermeSkeleton = TermeSkeletonRecyclerView(this, listItemLayoutResId, itemCount, config)

@JvmOverloads
fun ViewPager2.applySkeleton(
    @LayoutRes listItemLayoutResId: Int,
    itemCount: Int = LIST_ITEM_COUNT_DEFAULT,
    config: TermeSkeletonConfig = TermeSkeletonConfig.default(context)
): TermeSkeleton = TermeSkeletonViewPager2(this, listItemLayoutResId, itemCount, config)