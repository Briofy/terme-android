package net.lynqfy.test

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import net.lynqfy.offical.tablayout.SegmentLyTabLayout
import net.lynqfy.offical.tablayout.listener.OnTabSelectListener


class TabLayoutActivity2 : AppCompatActivity() {

    private val mFragments: ArrayList<Fragment> = ArrayList()
    private val mFragments2: ArrayList<Fragment> = ArrayList()

    private val mTitles = arrayOf("Page 1", "Page 2")
    private val mTitles_2 = arrayOf("Page 1", "Page 2", "Page 3")
    private val mTitles_3 = arrayOf("Page 1", "Page 2", "Page 3", "Page 4")
    private lateinit var mTabLayout_3: SegmentLyTabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tablayout_activity_2)
        for (title in mTitles_3) {
            mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager $title"))
        }

        for (title in mTitles_2) {
            mFragments2.add(SimpleCardFragment.getInstance("Switch Fragment $title"))
        }

        val tabLayout_1: SegmentLyTabLayout = findViewById(R.id.tl_1)
        val tabLayout_2: SegmentLyTabLayout = findViewById(R.id.tl_2)
        mTabLayout_3 = findViewById(R.id.tl_3)
        val tabLayout_4: SegmentLyTabLayout = findViewById(R.id.tl_4)
        val tabLayout_5: SegmentLyTabLayout = findViewById(R.id.tl_5)
        tabLayout_1.setTabData(mTitles)
        tabLayout_2.setTabData(mTitles_2)
        tl_3()
        tabLayout_4.setTabData(mTitles_2, this, R.id.fl_change, mFragments2)
        tabLayout_5.setTabData(mTitles_3)

        //显示未读红点

        //显示未读红点
        tabLayout_1.showDot(2)
        tabLayout_2.showDot(2)
        mTabLayout_3.showDot(1)
        tabLayout_4.showDot(1)


        mTabLayout_3.showDot(2)
        val rtv_3_2 = mTabLayout_3.getLyTextView(2)
        if (rtv_3_2 != null) {
            rtv_3_2.backgroundColor = Color.parseColor("#6D8FB0")
        }
    }

    private fun tl_3() {
        val vp_3: ViewPager = findViewById(R.id.vp_2)
        vp_3.adapter = MyPagerAdapter(supportFragmentManager)
        mTabLayout_3.setTabData(mTitles_3)
        mTabLayout_3.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                vp_3.currentItem = position
            }

            override fun onTabReselect(position: Int) {}
        })
        vp_3.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                mTabLayout_3.currentTab = position
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        vp_3.currentItem = 1
    }

    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return mFragments.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mTitles_3[position]
        }

        override fun getItem(position: Int): Fragment {
            return mFragments[position]
        }
    }
}