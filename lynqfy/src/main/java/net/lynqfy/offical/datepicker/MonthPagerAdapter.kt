package net.lynqfy.offical.datepicker

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import net.lynqfy.offical.R
import net.lynqfy.offical.datepicker.listeners.DateSelectListener
import net.lynqfy.offical.datepicker.listeners.GridChangeListener
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MonthPagerAdapter internal constructor(
    private val lyCalendarData: LyCalendarData,
    private val listener: DateSelectListener, private val showYearList: (date: Date) -> Unit
) : PagerAdapter() {
    private val tags = ArrayList<String>()
    private val TAG_PREFIX = "LY_CAL_TAG"
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        tags.remove((`object` as View).tag.toString())
        container.removeView(`object`)
    }

    override fun getCount(): Int {
        return Int.MAX_VALUE
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    @SuppressLint("SetTextI18n")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val indexShift = position - count / 2
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.ly_calendar_ui, container, false) as ViewGroup
        val adapter = GridAdapter(
            container.context,
            lyCalendarData,
            indexShift,
            listener,
            object : GridChangeListener {
                override fun gridChanged() {
                    tags.add(TAG_PREFIX + (position + 1))
                    tags.add(TAG_PREFIX + (position - 1))
                    notifyDataSetChanged()
                }
            })
        (view.findViewById<View>(R.id.calendarGrid) as GridView).adapter = adapter
        val currentDate = Calendar.getInstance()
        currentDate.time = lyCalendarData.showDate
        currentDate.add(Calendar.MONTH, indexShift)
        (view.findViewById<View>(R.id.txtSelectedMonth) as TextView).apply {
            text =
                SimpleDateFormat("LLLL yyyy", Locale.getDefault())
                    .format(currentDate.time)

            setOnClickListener {
                showYearList.invoke(currentDate.time)
            }
        }

        view.tag = TAG_PREFIX + position
        container.addView(view)
        val weekDays = Calendar.getInstance()
        weekDays[Calendar.DAY_OF_WEEK] = if (lyCalendarData.isFirstMonday) 2 else 1
        (view.findViewById<View>(R.id.day1) as TextView).text =
            SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time)
                .substring(0, 1).uppercase(Locale.getDefault()) + SimpleDateFormat(
                "EE",
                Locale.getDefault()
            ).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (lyCalendarData.isFirstMonday) 3 else 2
        (view.findViewById<View>(R.id.day2) as TextView).text =
            SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time)
                .substring(0, 1).uppercase(Locale.getDefault()) + SimpleDateFormat(
                "EE",
                Locale.getDefault()
            ).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (lyCalendarData.isFirstMonday) 4 else 3
        (view.findViewById<View>(R.id.day3) as TextView).text =
            SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time)
                .substring(0, 1).uppercase(Locale.getDefault()) + SimpleDateFormat(
                "EE",
                Locale.getDefault()
            ).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (lyCalendarData.isFirstMonday) 5 else 4
        (view.findViewById<View>(R.id.day4) as TextView).text =
            SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time)
                .substring(0, 1).uppercase(Locale.getDefault()) + SimpleDateFormat(
                "EE",
                Locale.getDefault()
            ).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (lyCalendarData.isFirstMonday) 6 else 5
        (view.findViewById<View>(R.id.day5) as TextView).text =
            SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time)
                .substring(0, 1).uppercase(Locale.getDefault()) + SimpleDateFormat(
                "EE",
                Locale.getDefault()
            ).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (lyCalendarData.isFirstMonday) 7 else 6
        (view.findViewById<View>(R.id.day6) as TextView).text =
            SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time)
                .substring(0, 1).uppercase(Locale.getDefault()) + SimpleDateFormat(
                "EE",
                Locale.getDefault()
            ).format(weekDays.time).substring(1)
        weekDays[Calendar.DAY_OF_WEEK] = if (lyCalendarData.isFirstMonday) 1 else 7
        (view.findViewById<View>(R.id.day7) as TextView).text =
            SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.time)
                .substring(0, 1).uppercase(Locale.getDefault()) + SimpleDateFormat(
                "EE",
                Locale.getDefault()
            ).format(weekDays.time).substring(1)
        return view
    }

    override fun getItemPosition(`object`: Any): Int {
        val tag = (`object` as ViewGroup).tag.toString()
        if (tags.contains(tag)) {
            tags.remove(tag)
            return POSITION_NONE
        }
        return POSITION_UNCHANGED
    }
}