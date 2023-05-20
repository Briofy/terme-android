package net.terme.offical.dropdown

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import net.terme.offical.R

class TermeDropdownMenu @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private val mTabTextSize: Int
    private val mTabTextColorNormal: Int
    private val mTabTextColorSelected: Int
    private val mDividerColor: Int
    private val mDividerPadding: Int
    private val mBorderColor: Int
//    private val mTabIconNormal: Int
//    private val mTabIconSelected: Int
    private val mContext: Context
    private var mCurrentTabIndex = 0
    private val mOnMenuOpenListeners: MutableList<OnMenuOpenListener>
    private var mCurrentPopupWindow: PopupWindow? = null

    init {
        setWillNotDraw(false)
        mContext = context
        mOnMenuOpenListeners = ArrayList()
        val t = context.obtainStyledAttributes(attrs, R.styleable.TermeDropdownMenu)
        mTabTextSize = t.getDimensionPixelSize(R.styleable.TermeDropdownMenu_ddmTabTextSize, spToPx(mContext, 13))
        mTabTextColorNormal = t.getColor(R.styleable.TermeDropdownMenu_ddmTabTextColorNormal, -0x99999a)
        mTabTextColorSelected =  t.getColor(R.styleable.TermeDropdownMenu_ddmTabTextColorSelected, -0xff720e)
        mDividerColor = t.getColor(R.styleable.TermeDropdownMenu_ddmDividerColor, -0x222223)
        mDividerPadding = t.getDimensionPixelSize(
            R.styleable.TermeDropdownMenu_ddmDividerPadding,
            dpToPx(mContext, 13)
        )
        mBorderColor = t.getColor(R.styleable.TermeDropdownMenu_ddmBorderColor, -0x111112)
//        mTabIconNormal =
//            t.getResourceId(R.styleable.TermeDropdownMenu_ddmTabIconNormal, R.drawable.ic_arrow_down)
//        mTabIconSelected =
//            t.getResourceId(R.styleable.TermeDropdownMenu_ddmTabIconSelected, R.drawable.ic_arrow_up)
        t.recycle()
    }

    interface OnMenuOpenListener {
        fun onOpen(tabView: View?, tabIndex: Int)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val w = width
        val h = height
        val paint = Paint()
        paint.isAntiAlias = true

        paint.color = mDividerColor
        for (i in 0 until childCount - 1) {
            val child = getChildAt(i)
            if (child == null || child.visibility == GONE) {
                continue
            }
            canvas.drawLine(
                child.right.toFloat(),
                mDividerPadding.toFloat(),
                child.right.toFloat(),
                (h - mDividerPadding).toFloat(),
                paint
            )
        }

        val lineHeight = 1
        paint.color = mBorderColor
        canvas.drawRect(0f, 0f, w.toFloat(), lineHeight.toFloat(), paint)
        canvas.drawRect(0f, (h - lineHeight).toFloat(), w.toFloat(), h.toFloat(), paint)
    }

    fun add(title: String, onMenuOpenListener: OnMenuOpenListener) {
        addTab(title)
        mOnMenuOpenListeners.add(onMenuOpenListener)
    }

    fun add(title: String, list: List<TermeDropItem>) {
        val listView = ListView(mContext)
        listView.layoutParams = LayoutParams(-1, -2)
        listView.scrollBarStyle = SCROLLBARS_OUTSIDE_OVERLAY
        val popupWindow = createPopupWindow(title, listView)
        val defaultAdapter = TermeDropdownListAdapter(mContext,  list)
        listView.adapter = defaultAdapter
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                /*defaultAdapter.setSelectedItem(position)
                setCurrentTitle(defaultAdapter.getSelectedItemString())*/
                popupWindow.dismiss()
            }
    }

    fun add(title: String, contentView: View) {
        createPopupWindow(title, contentView)
    }

    fun notifyMenuClosed() {
        setTabNormal(mCurrentTabIndex, null)
    }

    fun dismissCurrentPopupWindow() {
        if (mCurrentPopupWindow != null) {
            mCurrentPopupWindow!!.dismiss()
        }
    }

    private fun createPopupWindow(title: String, contentView: View): PopupWindow {
        val popupWindowView: View =
            LayoutInflater.from(mContext).inflate(R.layout.popup_window, null, false)
        val popupWindow =
            PopupWindow(popupWindowView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true)
        popupWindow.setBackgroundDrawable(ColorDrawable(0x00000000))
        popupWindow.isFocusable = true
        popupWindow.isOutsideTouchable = true
        popupWindow.setOnDismissListener {
            notifyMenuClosed()
            mCurrentPopupWindow = null
        }

        // Fix PopupWindow showAsDropDown problem in android 7.x.
        if (Build.VERSION.SDK_INT >= 24) {
            val vto = viewTreeObserver
            vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    viewTreeObserver.removeGlobalOnLayoutListener(this)
                    val location = IntArray(2)
                    getLocationOnScreen(location)
                    val x = location[0]
                    val y = location[1]
                    val screenHeight =
                        (mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.height
                    popupWindow.height = screenHeight - y - height
                }
            })
        }
        val contentContainer =
            popupWindowView.findViewById<View>(R.id.popup_window_content_container) as FrameLayout
        contentContainer.addView(contentView)
        val overlay = popupWindowView.findViewById<View>(R.id.popup_window_overlay)
        overlay.setOnClickListener { popupWindow.dismiss() }
        add(title, object : OnMenuOpenListener {
            override fun onOpen(tabView: View?, tabIndex: Int) {
                popupWindow.showAsDropDown(this@TermeDropdownMenu)
                mCurrentPopupWindow = popupWindow
            }
        })
        return popupWindow
    }

    private fun addTab(title: String): View {
        val titleTV = TextView(mContext)
        titleTV.gravity = Gravity.CENTER
        titleTV.text = title
        titleTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTabTextSize.toFloat())
        titleTV.setTextColor(mTabTextColorNormal)
        titleTV.setSingleLine()
        titleTV.ellipsize = TextUtils.TruncateAt.END
        // titleTV.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.level_filter), null);
//        titleTV.setCompoundDrawablesWithIntrinsicBounds(
//            null,
//            null,
//            resources.getDrawable(mTabIconNormal),
//            null
//        )
        titleTV.compoundDrawablePadding = dpToPx(mContext, 5)
        val tabLayout = RelativeLayout(mContext)
        val titleParams = RelativeLayout.LayoutParams(-2, -2)
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        tabLayout.addView(titleTV, titleParams)
        tabLayout.setPaddingRelative(dpToPx(mContext, 5), 0, dpToPx(mContext, 5), 0)
        val tabParams = LayoutParams(-1, -1/*, 1f*/)
        tabParams.gravity = Gravity.CENTER
        tabLayout.layoutParams = tabParams
        tabLayout.setOnClickListener(MyTabClickedListener(childCount))
        addView(tabLayout)

        // postInvalidate();
        return tabLayout
    }

    private fun getTabTextViewAt(index: Int): TextView {
        return (getChildAt(index) as ViewGroup).getChildAt(0) as TextView
    }

    fun setCurrentTitle(text: String?) {
        setTabNormal(mCurrentTabIndex, text)
    }

    private fun setTabNormal(index: Int, title: String?) {
        val tv = getTabTextViewAt(index)
        tv.setTextColor(mTabTextColorNormal)
        //tv.getCompoundDrawables()[2].setLevel(0);
//        tv.setCompoundDrawablesWithIntrinsicBounds(
//            null,
//            null,
//            resources.getDrawable(mTabIconNormal),
//            null
//        )
        if (title != null && title !== "") {
            tv.text = title
        }
    }

    private fun setTabSelected(index: Int) {
        val tv = getTabTextViewAt(index)
        tv.setTextColor(mTabTextColorSelected)
        //tabTextView.getCompoundDrawables()[2].setLevel(1);
//        tv.setCompoundDrawablesWithIntrinsicBounds(
//            null,
//            null,
//            resources.getDrawable(mTabIconSelected),
//            null
//        )
    }

    private inner class MyTabClickedListener(private val mIndex: Int) : OnClickListener {
        override fun onClick(view: View) {
            setTabNormal(mCurrentTabIndex, null)
            setTabSelected(mIndex)
            mCurrentTabIndex = mIndex
            for (i in mOnMenuOpenListeners.indices) {
                if (i == mCurrentTabIndex) {
                    mOnMenuOpenListeners[i].onOpen(view, i)
                    break
                }
            }
        }
    }

    private fun dpToPx(context: Context, dp: Int): Int {
        return (TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ) + 0.5f).toInt()
    }

    private fun spToPx(context: Context, sp: Int): Int {
        return (TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            sp.toFloat(),
            context.resources.displayMetrics
        ) + 0.5f).toInt()
    }
}