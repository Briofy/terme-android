package net.lynqfy.offical.datepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import net.lynqfy.offical.R
import net.lynqfy.offical.datepicker.listeners.DialogCompleteListener
import timber.log.Timber
import java.util.Calendar
import java.util.Date

internal class LyCalendarDialog : DialogFragment(), DialogCompleteListener {
    private val slyCalendarData = LyCalendarData()
    private var callback: Callback? = null

    private var  calendarView : LyCalendarView? = null
    fun setStartDate(startDate: Date?): LyCalendarDialog {
        slyCalendarData.selectedStartDate = startDate
        return this
    }

    fun setEndDate(endDate: Date?): LyCalendarDialog {
        slyCalendarData.selectedEndDate = endDate
        return this
    }

    fun setSingle(single: Boolean): LyCalendarDialog {
        slyCalendarData.isSingle = single
        return this
    }

    fun setFirstMonday(firsMonday: Boolean): LyCalendarDialog {
        slyCalendarData.isFirstMonday = firsMonday
        return this
    }

    fun setCallback(callback: Callback?): LyCalendarDialog {
        this.callback = callback
        return this
    }

    fun setTimeTheme(themeResource: Int?): LyCalendarDialog {
        slyCalendarData.timeTheme = themeResource
        return this
    }
    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.SlyCalendarDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         calendarView = requireActivity().layoutInflater.inflate(
            R.layout.ly_calendar_main,
            container
        ) as LyCalendarView
        calendarView?.setSlyCalendarData(slyCalendarData)
        calendarView?.setCallback(callback)
        calendarView?.setCompleteListener(this)
        // make dialog itself transparent
        return calendarView!!
    }

    override fun complete() {
        dismiss()
    }

  interface Callback {

        fun showYearList(date: Date)
        fun onCancelled()
        fun onDataSelected(firstDate: Calendar?, secondDate: Calendar?, hours: Int, minutes: Int)
    }

    fun setBackgroundColor(backgroundColor: Int?): LyCalendarDialog {
        slyCalendarData.backgroundColor = backgroundColor
        return this
    }

    fun setHeaderColor(headerColor: Int?): LyCalendarDialog {
        slyCalendarData.headerColor = headerColor
        return this
    }

    fun setHeaderTextColor(headerTextColor: Int?): LyCalendarDialog {
        slyCalendarData.headerTextColor = headerTextColor
        return this
    }

    fun setTextColor(textColor: Int?): LyCalendarDialog {
        slyCalendarData.textColor = textColor
        return this
    }

    fun setSelectedColor(selectedColor: Int?): LyCalendarDialog {
        slyCalendarData.selectedColor = selectedColor
        return this
    }

    fun setSelectedTextColor(selectedTextColor: Int?): LyCalendarDialog {
        slyCalendarData.selectedTextColor = selectedTextColor
        return this
    }
}