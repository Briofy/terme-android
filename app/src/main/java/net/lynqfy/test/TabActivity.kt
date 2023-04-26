package net.lynqfy.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import net.lynqfy.offical.LyTextView
import net.lynqfy.offical.tablayout.CommonLyTabLayout
import net.lynqfy.offical.tablayout.SegmentLyTabLayout
import net.lynqfy.offical.tablayout.SlidingLyTabLayout
import net.lynqfy.offical.tablayout.listener.CustomTabEntity
import net.lynqfy.offical.tablayout.listener.OnTabSelectListener
import net.lynqfy.offical.tablayout.utils.UnreadMsgUtils
import java.util.*


class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        val frg1 = TestFragment1()
        val bundle1 = Bundle()
        bundle1.putInt("Index", 0)
        frg1.arguments = bundle1
        /////////////
        val frg2 = TestFragment1()
        val bundle2 = Bundle()
        bundle2.putInt("Index", 1)
        frg2.arguments = bundle2
        /////////////
        val frg3 = TestFragment1()
        val bundle3 = Bundle()
        bundle3.putInt("Index", 2)
        frg3.arguments = bundle3
        /////////////
        val frg4 = TestFragment1()
        val bundle4 = Bundle()
        bundle4.putInt("Index", 3)
        frg4.arguments = bundle4
        /////////////
        val frg5 = TestFragment1()
        val bundle5 = Bundle()
        bundle5.putInt("Index", 4)
        frg5.arguments = bundle5
        /////////////
        val frags = listOf(frg1, frg2, frg3, frg4, frg5)
        val testADapter = TestAdapter(supportFragmentManager, frags)

        val viewPAger: ViewPager = findViewById(R.id.testPager)
        val tabLayout: CommonLyTabLayout = findViewById(R.id.customTabs)
        val tabLayout2: SegmentLyTabLayout = findViewById(R.id.customTabs2)
        val tabLayout3: SlidingLyTabLayout = findViewById(R.id.customTabs3)


        viewPAger.adapter = testADapter
        val icons = listOf(R.drawable.ic1, R.drawable.ic2, R.drawable.ic3, R.drawable.ic4, R.drawable.ic5)
        val icons2 = listOf(
            R.drawable.ic1_1,
            R.drawable.ic2_2,
            R.drawable.ic3_3,
            R.drawable.ic4_4,
            R.drawable.ic5_5
        )

        val tabs: ArrayList<CustomTabEntity> = ArrayList()


        //  tabLayout.
        for (i in frags.indices) {
            tabs.add(
                TabEntity(
                    "Page ${i + 1}",
                    icons[i],
                    icons2[i]
                )
            )
        }
        tabLayout.setTabData(tabs)
        tabLayout2.setTabData(arrayOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5"))
        tabLayout3.setViewPager(viewPAger)


        tabLayout.showMsg(0, 100)
        tabLayout.setMsgMargin(1, -5f, 5f)

        tabLayout2.showDot(2)

        tabLayout3.showDot(2)
        tabLayout3.setCurrentTab(0)

        tabLayout.showDot(2)

        val rtv_2_2: LyTextView? = tabLayout.getLyTextView(2)
        if (rtv_2_2 != null) {
            UnreadMsgUtils.setSize(rtv_2_2, dp2px(7.5f))
        }
        val rtv: LyTextView? = tabLayout2.getLyTextView(2)
        if (rtv != null) {
            UnreadMsgUtils.setSize(rtv, dp2px(7.5f))
        }



        viewPAger.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                tabLayout.currentTab = position
                tabLayout2.currentTab = position
            }


            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        val tabListener = object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                viewPAger.currentItem = position
            }

            override fun onTabReselect(position: Int) {
                if (position == 0) {
                    tabLayout.showMsg(0, Random().nextInt(100) + 1)
                    //                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                }
            }
        }

        tabLayout.setOnTabSelectListener(tabListener)
        tabLayout2.setOnTabSelectListener(tabListener)

    }

    fun dp2px(dp: Float): Int {
        val scale: Float = getResources().getDisplayMetrics().density
        return (dp * scale + 0.5f).toInt()
    }
}

class TabEntity(val title: String, var selectedIcon: Int, var unselectedIcon: Int) :
    CustomTabEntity {
    override fun getTabTitle() = title

    override fun getTabSelectedIcon() = selectedIcon

    override fun getTabUnselectedIcon() = unselectedIcon

}