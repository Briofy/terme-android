package net.lynqfy.offical.datepicker

import android.app.TimePickerDialog
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

class LyCalendarView : FrameLayout, DateSelectListener {
    private var slyCalendarData: LyCalendarData? = null
    private var callback: LyCalendarDialog.Callback? = null
    private var completeListener: DialogCompleteListener? = null
    private var attrs: AttributeSet? = null
    private var defStyleAttr = 0

    constructor(context: Context?) : super(context!!) {
        init(null, 0)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
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

    fun setSlyCalendarData(slyCalendarData: LyCalendarData?) {
        this.slyCalendarData = slyCalendarData
        init(attrs, defStyleAttr)
        showCalendar()
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        inflate(context, R.layout.slycalendar_frame, this)
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.SlyCalendarView, defStyle, 0)
        if (slyCalendarData!!.backgroundColor == null) {
            slyCalendarData!!.backgroundColor = typedArray.getColor(
                R.styleable.SlyCalendarView_backgroundColor,
                ContextCompat.getColor(context, R.color.slycalendar_defBackgroundColor)
            )
        }
        if (slyCalendarData!!.headerColor == null) {
            slyCalendarData!!.headerColor = typedArray.getColor(
                R.styleable.SlyCalendarView_headerColor,
                ContextCompat.getColor(context, R.color.slycalendar_defHeaderColor)
            )
        }
        if (slyCalendarData!!.headerTextColor == null) {
            slyCalendarData!!.headerTextColor = typedArray.getColor(
                R.styleable.SlyCalendarView_headerTextColor,
                ContextCompat.getColor(context, R.color.slycalendar_defHeaderTextColor)
            )
        }
        if (slyCalendarData!!.textColor == null) {
            slyCalendarData!!.textColor = typedArray.getColor(
                R.styleable.SlyCalendarView_textColor,
                ContextCompat.getColor(context, R.color.slycalendar_defTextColor)
            )
        }
        if (slyCalendarData!!.selectedColor == null) {
            slyCalendarData!!.selectedColor = typedArray.getColor(
                R.styleable.SlyCalendarView_selectedColor,
                ContextCompat.getColor(context, R.color.slycalendar_defSelectedColor)
            )
        }
        if (slyCalendarData!!.selectedTextColor == null) {
            slyCalendarData!!.selectedTextColor = typedArray.getColor(
                R.styleable.SlyCalendarView_selectedTextColor,
                ContextCompat.getColor(context, R.color.slycalendar_defSelectedTextColor)
            )
        }
        typedArray.recycle()
        val vpager = findViewById<ViewPager>(R.id.content)
        vpager.adapter = MonthPagerAdapter(slyCalendarData, this)
        vpager.currentItem = vpager.adapter!!.count / 2
        showCalendar()
    }

    private fun showCalendar() {
        paintCalendar()
        showTime()
        findViewById<View>(R.id.txtCancel).setOnClickListener {
            if (callback != null) {
                callback!!.onCancelled()
            }
            if (completeListener != null) {
                completeListener!!.complete()
            }
        }
        findViewById<View>(R.id.txtSave).setOnClickListener {
            if (callback != null) {
                var start: Calendar? = null
                var end: Calendar? = null
                if (slyCalendarData!!.selectedStartDate != null) {
                    start = Calendar.getInstance()
                    start.time = slyCalendarData!!.selectedStartDate
                }
                if (slyCalendarData!!.selectedEndDate != null) {
                    end = Calendar.getInstance()
                    end.time = slyCalendarData!!.selectedEndDate
                }
                callback!!.onDataSelected(
                    start,
                    end,
                    slyCalendarData!!.selectedHour,
                    slyCalendarData!!.selectedMinutes
                )
            }
            if (completeListener != null) {
                completeListener!!.complete()
            }
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
                    R.string.slycalendar_dates_period,
                    SimpleDateFormat("EE, dd", Locale.getDefault()).format(calendarStart.time),
                    SimpleDateFormat("EE, dd MMM", Locale.getDefault()).format(calendarEnd.time)
                )
            } else {
                (findViewById<View>(R.id.txtSelectedPeriod) as TextView).text = context.getString(
                    R.string.slycalendar_dates_period,
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
        findViewById<View>(R.id.txtTime).setOnClickListener {
            var style = R.style.SlyCalendarTimeDialogTheme
            if (slyCalendarData!!.timeTheme != null) {
                style = slyCalendarData!!.timeTheme
            }
            val tpd = TimePickerDialog(context, style, { view, hourOfDay, minute ->
                slyCalendarData!!.selectedHour = hourOfDay
                slyCalendarData!!.selectedMinutes = minute
                showTime()
            }, slyCalendarData!!.selectedHour, slyCalendarData!!.selectedMinutes, true)
            tpd.show()
        }
        val vpager = findViewById<ViewPager>(R.id.content)
        vpager.adapter!!.notifyDataSetChanged()
        vpager.invalidate()
    }

    override fun dateSelect(selectedDate: Date?) {
        if (slyCalendarData!!.selectedStartDate == null || slyCalendarData!!.isSingle) {
            slyCalendarData!!.selectedStartDate = selectedDate
            showCalendar()
            return
        }
        if (slyCalendarData!!.selectedEndDate == null) {
            if (selectedDate!!.time < slyCalendarData!!.selectedStartDate.time) {
                slyCalendarData!!.selectedEndDate = slyCalendarData!!.selectedStartDate
                slyCalendarData!!.selectedStartDate = selectedDate
                showCalendar()
                return
            } else if (selectedDate.time == slyCalendarData!!.selectedStartDate.time) {
                slyCalendarData!!.selectedEndDate = null
                slyCalendarData!!.selectedStartDate = selectedDate
                showCalendar()
                return
            } else if (selectedDate.time > slyCalendarData!!.selectedStartDate.time) {
                slyCalendarData!!.selectedEndDate = selectedDate
                showCalendar()
                return
            }
        }
        if (slyCalendarData!!.selectedEndDate != null) {
            slyCalendarData!!.selectedEndDate = null
            slyCalendarData!!.selectedStartDate = selectedDate
            showCalendar()
        }
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
        (findViewById<View>(R.id.txtSelectedPeriod) as TextView).setTextColor(
            slyCalendarData!!.headerTextColor
        )
        (findViewById<View>(R.id.txtTime) as TextView).setTextColor(slyCalendarData!!.headerColor)
    }

    private fun showTime() {
        val calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = slyCalendarData!!.selectedHour
        calendar[Calendar.MINUTE] = slyCalendarData!!.selectedMinutes
        (findViewById<View>(R.id.txtTime) as TextView).text =
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(calendar.time)
    }
}