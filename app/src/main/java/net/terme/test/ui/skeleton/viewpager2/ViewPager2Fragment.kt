package net.terme.test.ui.skeleton.viewpager2

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

import net.terme.test.ui.skeleton.recyclerview.RecyclerViewListItem
import com.google.android.material.tabs.TabLayoutMediator
import net.terme.offical.skeleton.TermeSkeleton
import net.terme.offical.skeleton.applySkeleton
import net.terme.test.R
import net.terme.test.ui.skeleton.MainPagerFragment

class ViewPager2Fragment : MainPagerFragment(R.layout.fragment_viewpager2, "ViewPager2") {

    override lateinit var skeleton: TermeSkeleton

    private lateinit var mediator: TabLayoutMediator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = RecyclerViewListItem.DEMO

        val listAdapter = ViewPager2Adapter(items)
        val viewPagerIndicator = view.findViewById<TabLayout>(R.id.viewPagerIndicator)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = listAdapter

        skeleton = viewPager.applySkeleton(R.layout.list_item_viewpager2, items.size).apply { showSkeleton() }
        mediator = TabLayoutMediator(viewPagerIndicator, viewPager) { _, _ -> }.apply { attach() }
    }
}