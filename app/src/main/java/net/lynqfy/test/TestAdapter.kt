package net.lynqfy.test

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class TestAdapter(fm: FragmentManager, val frags: List<Fragment>) : FragmentStatePagerAdapter(fm) {
    override fun getCount() = frags.size

    override fun getItem(position: Int) = frags[position]

}