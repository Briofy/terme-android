package net.terme.test

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import net.terme.offical.TermeTextView
import net.terme.offical.tablayout.TermeTabLayoutCommon
import net.terme.offical.tablayout.listener.CustomTabEntity
import net.terme.offical.tablayout.listener.OnTabSelectListener
import net.terme.offical.tablayout.utils.UnreadMsgUtils
import java.util.*


class TabLayoutActivity1 : AppCompatActivity() {
    private val mFragments: ArrayList<Fragment> = ArrayList()
    private val mFragments2: ArrayList<Fragment> = ArrayList()

    private val mTitles = arrayOf("Page 1", "Page 2", "Page 3", "Page 4")

    private val mIconUnselectIds = intArrayOf(
        R.drawable.ic1, R.drawable.ic2,
        R.drawable.ic3, R.drawable.ic4
    )
    private val mIconSelectIds = intArrayOf(
        R.drawable.ic1_1, R.drawable.ic2_2,
        R.drawable.ic3_3, R.drawable.ic4_4
    )
    private val mTabEntities: ArrayList<CustomTabEntity> = ArrayList()

    private lateinit var mDecorView: View
    private lateinit var mViewPager: ViewPager
    private lateinit var mTabLayout_7: TermeTabLayoutCommon
    private lateinit var mTabLayout_1: TermeTabLayoutCommon
    private lateinit var mTabLayout_2: TermeTabLayoutCommon
    private lateinit var mTabLayout_3: TermeTabLayoutCommon
    private lateinit var mTabLayout_4: TermeTabLayoutCommon
    private lateinit var mTabLayout_5: TermeTabLayoutCommon
    private lateinit var mTabLayout_6: TermeTabLayoutCommon
    private lateinit var mTabLayout_8: TermeTabLayoutCommon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tablayout_activity_1)

        for (title in mTitles) {
            mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager $title"))
            mFragments2.add(SimpleCardFragment.getInstance("Switch Fragment $title"))
        }


        for (i in mTitles.indices) {
            mTabEntities.add(TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]))
        }

        mViewPager = findViewById(R.id.vp_2)
        mViewPager.adapter = MyPagerAdapter(supportFragmentManager)
        /** with nothing */
        /** with nothing  */
        mTabLayout_1 = findViewById(R.id.tl_1)
        /** with ViewPager */
        /** with ViewPager  */
        mTabLayout_2 = findViewById(R.id.tl_2)
        /** with Fragments */
        /** with Fragments  */
        mTabLayout_3 = findViewById(R.id.tl_3)
        /** indicator固定宽度 */
        /** indicator固定宽度  */
        mTabLayout_4 = findViewById(R.id.tl_4)
        /** indicator固定宽度 */
        /** indicator固定宽度  */
        mTabLayout_5 = findViewById(R.id.tl_5)
        /** indicator矩形圆角 */
        /** indicator矩形圆角  */
        mTabLayout_6 = findViewById(R.id.tl_6)
        /** indicator三角形 */
        /** indicator三角形  */
        mTabLayout_7 = findViewById(R.id.tl_7)
        /** indicator圆角色块 */
        /** indicator圆角色块  */
        mTabLayout_8 = findViewById(R.id.tl_8)

        mTabLayout_1.setTabData(mTabEntities)
        tl_2()
        mTabLayout_3.setTabData(mTabEntities, this, R.id.fl_change, mFragments2)
        mTabLayout_4.setTabData(mTabEntities)
        mTabLayout_5.setTabData(mTabEntities)
        mTabLayout_6.setTabData(mTabEntities)
        mTabLayout_7.setTabData(mTabEntities)
        mTabLayout_8.setTabData(mTabEntities)

        mTabLayout_3.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                mTabLayout_1.currentTab = position
                mTabLayout_2.currentTab = position
                mTabLayout_4.currentTab = position
                mTabLayout_5.currentTab = position
                mTabLayout_6.currentTab = position
                mTabLayout_7.currentTab = position
                mTabLayout_8.currentTab = position
            }

            override fun onTabReselect(position: Int) {}
        })
        mTabLayout_8.currentTab = 2
        mTabLayout_3.currentTab = 1

        //显示未读红点

        //显示未读红点
        mTabLayout_1.showDot(2)
        mTabLayout_3.showDot(1)
        mTabLayout_4.showDot(1)

        //两位数

        //两位数
        mTabLayout_2.showMsg(0, 55)
        mTabLayout_2.setMsgMargin(0, -5f, 5f)

        //三位数

        //三位数
        mTabLayout_2.showMsg(1, 100)
        mTabLayout_2.setMsgMargin(1, -5f, 5f)

        //设置未读消息红点

        //设置未读消息红点
        mTabLayout_2.showDot(2)
        val rtv_2_2: TermeTextView? = mTabLayout_2.getLyTextView(2)
        if (rtv_2_2 != null) {
            UnreadMsgUtils.setSize(rtv_2_2, dp2px(7.5f))
        }

        //设置未读消息背景

        //设置未读消息背景
        mTabLayout_2.showMsg(3, 5)
        mTabLayout_2.setMsgMargin(3, 0f, 5f)
        val rtv_2_3: TermeTextView? = mTabLayout_2.getLyTextView(3)
        if (rtv_2_3 != null) {
            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"))
        }
    }

    var mRandom = Random()

    private fun tl_2() {
        mTabLayout_2.setTabData(mTabEntities)
        mTabLayout_2.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                mViewPager.currentItem = position
            }

            override fun onTabReselect(position: Int) {
                if (position == 0) {
                    mTabLayout_2.showMsg(0, mRandom.nextInt(100) + 1)
                    //                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                }
            }
        })
        mViewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                mTabLayout_2.currentTab = position
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        mViewPager.currentItem = 1
    }

    inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
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

    fun dp2px(dp: Float): Int {
        val scale: Float = resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }


    class TabEntity(val title: String, var selectedIcon: Int, var unselectedIcon: Int) :
        CustomTabEntity {
        override fun getTabTitle() = title

        override fun getTabSelectedIcon() = selectedIcon

        override fun getTabUnselectedIcon() = unselectedIcon

    }

}