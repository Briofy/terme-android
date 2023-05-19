package net.terme.offical.skeleton.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import net.terme.offical.skeleton.TermeSkeletonConfig
import net.terme.offical.skeleton.TermeSkeletonLayout
import net.terme.offical.skeleton.createSkeleton

internal class TermeSkeletonRecyclerViewAdapter(
    @LayoutRes private val layoutResId: Int,
    private val itemCount: Int,
    private val config: TermeSkeletonConfig
) : RecyclerView.Adapter<TermeSkeletonRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermeSkeletonRecyclerViewHolder {
        val originView = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val skeleton = originView.createSkeleton(config) as TermeSkeletonLayout
        skeleton.layoutParams = originView.layoutParams
        skeleton.showSkeleton()
        return TermeSkeletonRecyclerViewHolder(skeleton)
    }

    override fun onBindViewHolder(holder: TermeSkeletonRecyclerViewHolder, position: Int) = Unit

    override fun getItemCount() = itemCount
}