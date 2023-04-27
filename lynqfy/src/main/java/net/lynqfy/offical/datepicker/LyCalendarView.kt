package net.lynqfy.offical.datepicker

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import net.lynqfy.offical.R
import net.lynqfy.offical.datepicker.listeners.DateSelectListener
import net.lynqfy.offical.datepicker.listeners.DialogCompleteListener
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

internal class LyCalendarView : FrameLayout, DateSelectListener {
    private var slyCalendarData: LyCalendarData? = null
    private var callback: LyCalendarDialog.Callback? = null
    private var completeListener: DialogCompleteListener? = null
    private var attrs: AttributeSet? = null
    private var defStyleAttr = 0

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context, attrs
    ) {
        this.attrs = attrs
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    ) {
        this.attrs = attrs
        this.defStyleAttr = defStyleAttr
    }

    fun setCallback(callback: LyCalendarDialog.Callback?) {
        this.callback = callback
    }

    fun setCompleteListener(completeListener: DialogCompleteListener?) {
        this.completeListener = completeListener
    }

    fun setSlyCalendarData(slyCalendarData: LyCalendarData) {
        this.slyCalendarData = slyCalendarData
        init(attrs, defStyleAttr)
        showCalendar()
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        inflate(context, R.layout.ly_calendar_frame, this)
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.LyCalendarView, defStyle, 0)

        slyCalendarData?.apply {
            if (backgroundColor == null) {
                backgroundColor = typedArray.getColor(
                    R.styleable.LyCalendarView_backgroundColor,
                    ContextCompat.getColor(context, R.color.ly_calendar_background_color)
                )
            }
            if (headerColor == null) {
                headerColor = typedArray.getColor(
                    R.styleable.LyCalendarView_headerColor,
                    ContextCompat.getColor(context, R.color.slycalendar_defHeaderColor)
                )
            }
            if (headerTextColor == null) {
                headerTextColor = typedArray.getColor(
                    R.styleable.LyCalendarView_headerTextColor,
                    ContextCompat.getColor(context, R.color.slycalendar_defHeaderTextColor)
                )
            }
            if (textColor == null) {
                textColor = typedArray.getColor(
                    R.styleable.LyCalendarView_textColor,
                    ContextCompat.getColor(context, R.color.ly_calendar_text_color)
                )
            }
            if (selectedColor == null) {
                selectedColor = typedArray.getColor(
                    R.styleable.LyCalendarView_selectedColor,
                    ContextCompat.getColor(context, R.color.ly_calendar_selected_color)
                )
            }
            if (selectedTextColor == null) {
                selectedTextColor = typedArray.getColor(
                    R.styleable.LyCalendarView_selectedTextColor,
                    ContextCompat.getColor(context, R.color.ly_calendar_selected_text_color)
                )
            }

            val vpager = findViewById<ViewPager>(R.id.content)
            val mAdapter = MonthPagerAdapter(this, this@LyCalendarView) {
                callback?.showYearList(it)
            }
            vpager.adapter = mAdapter
            vpager.currentItem = mAdapter.count / 2
        }

        typedArray.recycle()

        showCalendar()
    }

    private fun showCalendar() {
        paintCalendar()
        findViewById<View>(R.id.txtCancel).setOnClickListener {
            callback?.onCancelled()
            completeListener?.complete()
        }
        findViewById<View>(R.id.txtToday).setOnClickListener {

            callback?.let {
                val start = Calendar.getInstance()
                val end = Calendar.getInstance()

                slyCalendarData?.run {
                    if (selectedStartDate != null) {
                        start.time = selectedStartDate
                    }
                    if (selectedEndDate != null) {
                        end.time = selectedEndDate
                    }
                    it.onDataSelected(start, end, selectedHour, selectedMinutes)
                }
            }

            completeListener?.complete()
        }

        val calendarStart = Calendar.getInstance()
        var calendarEnd: Calendar? = null

        if (slyCalendarData!!.selectedStartDate != null) {
            calendarStart.time = slyCalendarData!!.selectedStartDate
        } else {
            calendarStart.time = slyCalendarData!!.showDate
        }
        if (slyCalendarData!!.selectedEndDate != null) {
            calendarEnd = Calendar.getInstance()
            calendarEnd.time = slyCalendarData!!.selectedEndDate
        }
        (findViewById<View>(R.id.txtYear) as TextView).text =
            calendarStart[Calendar.YEAR].toString()
        if (calendarEnd == null) {
            (findViewById<View>(R.id.txtSelectedPeriod) as TextView).text =
                SimpleDateFormat("EE, dd MMMM", Locale.getDefault()).format(calendarStart.time)
        } else {
            if (calendarStart[Calendar.MONTH] == calendarEnd[Calendar.MONTH]) {
                (findViewById<View>(R.id.txtSelectedPeriod) as TextView).text = context.getString(
                    R.string.ly_calendar_dates_period,
                    SimpleDateFormat("EE, dd", Locale.getDefault()).format(calendarStart.time),
                    SimpleDateFormat("EE, dd MMM", Locale.getDefault()).format(calendarEnd.time)
                )
            } else {
                (findViewById<View>(R.id.txtSelectedPeriod) as TextView).text = context.getString(
                    R.string.ly_calendar_dates_period,
                    SimpleDateFormat("EE, dd MMM", Locale.getDefault()).format(calendarStart.time),
                    SimpleDateFormat("EE, dd MMM", Locale.getDefault()).format(calendarEnd.time)
                )
            }
        }
        findViewById<View>(R.id.btnMonthPrev).setOnClickListener {
            val vpager = findViewById<ViewPager>(R.id.content)
            vpager.currentItem = vpager.currentItem - 1
        }
        findViewById<View>(R.id.btnMonthNext).setOnClickListener {
            val vpager = findViewById<ViewPager>(R.id.content)
            vpager.currentItem = vpager.currentItem + 1
        }
        val vpager = findViewById<ViewPager>(R.id.content)
        vpager.adapter?.notifyDataSetChanged()
        vpager.invalidate()
    }

    override fun dateSelect(selectedDate: Date?) {
        slyCalendarData?.let {
            if (it.selectedStartDate == null || it.isSingle) {
                it.selectedStartDate = selectedDate
                showCalendar()
                return
            }

            if (it.selectedEndDate == null) {
                if (selectedDate!!.time < it.selectedStartDate.time) {
                    it.selectedEndDate = it.selectedStartDate
                    it.selectedStartDate = selectedDate
                    showCalendar()
                    return
                } else if (selectedDate.time == it.selectedStartDate.time) {
                    it.selectedEndDate = null
                    it.selectedStartDate = selectedDate
                    showCalendar()
                    return
                } else if (selectedDate.time > it.selectedStartDate.time) {
                    it.selectedEndDate = selectedDate
                    showCalendar()
                    return
                }
            }
            if (it.selectedEndDate != null) {
                it.selectedEndDate = null
                it.selectedStartDate = selectedDate
                showCalendar()
            }
        }

        /*val vpager = findViewById<ViewPager>(R.id.content)
        vpager.currentItem +=1
        vpager.adapter?.notifyDataSetChanged()
        vpager.invalidate()*/
    }

    override fun dateLongSelect(selectedDate: Date?) {
        slyCalendarData!!.selectedEndDate = null
        slyCalendarData!!.selectedStartDate = selectedDate
        showCalendar()
    }

    private fun paintCalendar() {
        findViewById<View>(R.id.mainFrame).setBackgroundColor(slyCalendarData!!.backgroundColor)
        findViewById<View>(R.id.headerView).setBackgroundColor(slyCalendarData!!.headerColor)
        (findViewById<View>(R.id.txtYear) as TextView).setTextColor(slyCalendarData!!.headerTextColor)
        (findViewById<View>(R.id.txtSelectedPeriod) as TextView).setTextColor(slyCalendarData!!.headerTextColor)
//        (findViewById<View>(R.id.txtTime) as TextView).setTextColor(slyCalendarData!!.headerColor)
    }

//    private fun showTime() {
//        val calendar = Calendar.getInstance()
//        calendar[Calendar.HOUR_OF_DAY] = slyCalendarData!!.selectedHour
//        calendar[Calendar.MINUTE] = slyCalendarData!!.selectedMinutes
//        (findViewById<View>(R.id.txtTime) as TextView).text =
//            SimpleDateFormat("HH:mm", Locale.getDefault()).format(calendar.time)
//    }
}