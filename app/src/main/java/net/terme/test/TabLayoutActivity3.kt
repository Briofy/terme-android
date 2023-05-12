package net.terme.test

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import net.terme.offical.tablayout.TermeTabLayoutSliding
import net.terme.offical.tablayout.listener.OnTabSelectListener


class TabLayoutActivity3 : AppCompatActivity(), OnTabSelectListener {
    private val mFragments: ArrayList<Fragment> = ArrayList()
    private val mTitles = arrayOf(
        "Slide 1", "Slide 2", "Slide 3", "Slide 4", "Slide 5", "Slide 6", "Slide 7"
    )
    private var mAdapter: MyPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tablayout_activity_3)

        for (title in mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title))
        }


        val vp: ViewPager = findViewById(R.id.vp)
        mAdapter = MyPagerAdapter(supportFragmentManager)
        vp.adapter = mAdapter

        /** 默认 */
        /** 默认  */
        val tabLayout_1: TermeTabLayoutSliding = findViewById(R.id.tl_1)
        val tabLayout_2: TermeTabLayoutSliding = findViewById(R.id.tl_2)

        val tabLayout_3: TermeTabLayoutSliding = findViewById(R.id.tl_3)

        val tabLayout_4: TermeTabLayoutSliding = findViewById(R.id.tl_4)

        val tabLayout_5: TermeTabLayoutSliding = findViewById(R.id.tl_5)

        val tabLayout_6: TermeTabLayoutSliding = findViewById(R.id.tl_6)

        val tabLayout_7: TermeTabLayoutSliding = findViewById(R.id.tl_7)

        val tabLayout_8: TermeTabLayoutSliding = findViewById(R.id.tl_8)

        val tabLayout_9: TermeTabLayoutSliding = findViewById(R.id.tl_9)

        val tabLayout_10: TermeTabLayoutSliding = findViewById(R.id.tl_10)


        tabLayout_1.setViewPager(vp)
        tabLayout_2.setViewPager(vp)
        tabLayout_2.setOnTabSelectListener(this)
        tabLayout_3.setViewPager(vp)
        tabLayout_4.setViewPager(vp)
        tabLayout_5.setViewPager(vp)
        tabLayout_6.setViewPager(vp)
        tabLayout_7.setViewPager(vp, mTitles)
        tabLayout_8.setViewPager(vp, mTitles, this, mFragments)
        tabLayout_9.setViewPager(vp)
        tabLayout_10.setViewPager(vp)

        vp.currentItem = 4

        tabLayout_1.showDot(4)
        tabLayout_3.showDot(4)
        tabLayout_2.showDot(4)

        tabLayout_2.showMsg(3, 5)
        tabLayout_2.setMsgMargin(3, 0f, 10f)
        tabLayout_2.getLyTextView(3)?.backgroundColor = Color.parseColor("#6D8FB0")

        tabLayout_2.showMsg(5, 5)
        tabLayout_2.setMsgMargin(5, 0f, 10f)
    }

    override fun onTabSelect(position: Int) {
        Toast.makeText(this, "onTabSelect&position--->$position", Toast.LENGTH_SHORT).show()
    }

    override fun onTabReselect(position: Int) {
        Toast.makeText(this, "onTabReselect&position--->$position", Toast.LENGTH_SHORT).show()
    }

    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return mFragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mTitles.get(position)
        }

        override fun getItem(position: Int): Fragment {
            return mFragments.get(position)
        }
    }
}