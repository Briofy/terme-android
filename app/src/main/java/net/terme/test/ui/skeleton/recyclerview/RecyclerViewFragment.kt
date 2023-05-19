package net.terme.test.ui.skeleton.recyclerview

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.terme.offical.skeleton.TermeSkeleton
import net.terme.offical.skeleton.applySkeleton
import net.terme.test.R
import net.terme.test.ui.skeleton.MainPagerFragment

class RecyclerViewFragment : MainPagerFragment(R.layout.fragment_recyclerview, "RecyclerView") {

    override lateinit var skeleton: TermeSkeleton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = RecyclerViewListItem.DEMO
        val list = view.findViewById<RecyclerView>(R.id.list)

        val listAdapter = RecyclerViewAdapter(items)
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = listAdapter

        skeleton = list.applySkeleton(R.layout.list_item_recyclerview, items.size).apply { showSkeleton() }
    }
}