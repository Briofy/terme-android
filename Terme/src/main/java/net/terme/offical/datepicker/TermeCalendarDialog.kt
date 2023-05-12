package net.terme.offical.datepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import net.terme.offical.R
import net.terme.offical.datepicker.listeners.DialogCompleteListener
import java.util.Calendar
import java.util.Date

internal class TermeCalendarDialog : DialogFragment(), DialogCompleteListener {
    private val slyCalendarData =
        TermeCalendarData()
    private var callback: Callback? = null

    private var  calendarView : TermeCalendarView? = null
    fun setStartDate(startDate: Date?): TermeCalendarDialog {
        slyCalendarData.selectedStartDate = startDate
        return this
    }

    fun setEndDate(endDate: Date?): TermeCalendarDialog {
        slyCalendarData.selectedEndDate = endDate
        return this
    }

    fun setSingle(single: Boolean): TermeCalendarDialog {
        slyCalendarData.isSingle = single
        return this
    }

    fun setFirstMonday(firsMonday: Boolean): TermeCalendarDialog {
        slyCalendarData.isFirstMonday = firsMonday
        return this
    }

    fun setCallback(callback: Callback?): TermeCalendarDialog {
        this.callback = callback
        return this
    }

    fun setTimeTheme(themeResource: Int?): TermeCalendarDialog {
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
        ) as TermeCalendarView
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

    fun setBackgroundColor(backgroundColor: Int?): TermeCalendarDialog {
        slyCalendarData.backgroundColor = backgroundColor
        return this
    }

    fun setHeaderColor(headerColor: Int?): TermeCalendarDialog {
        slyCalendarData.headerColor = headerColor
        return this
    }

    fun setHeaderTextColor(headerTextColor: Int?): TermeCalendarDialog {
        slyCalendarData.headerTextColor = headerTextColor
        return this
    }

    fun setTextColor(textColor: Int?): TermeCalendarDialog {
        slyCalendarData.textColor = textColor
        return this
    }

    fun setSelectedColor(selectedColor: Int?): TermeCalendarDialog {
        slyCalendarData.selectedColor = selectedColor
        return this
    }

    fun setSelectedTextColor(selectedTextColor: Int?): TermeCalendarDialog {
        slyCalendarData.selectedTextColor = selectedTextColor
        return this
    }
}