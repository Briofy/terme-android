package net.terme.offical.datepicker

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import timber.log.Timber
import java.util.Calendar
import java.util.Date

class TermeDatePicker(
    private val ctx: AppCompatActivity, private val callback: (( firstDate: Calendar?,
                                                                 secondDate: Calendar?,
                                                                 hours: Int,
                                                                 minutes: Int) -> Unit)? = null
) : TermeCalendarDialog.Callback {

    private val fmTag = "TAG_LY_CALENDAR"
    private fun getCalendarDialog(d: Date? = null , isSingle : Boolean = true): TermeCalendarDialog {
        var date = d
        if (date == null){
            val cal = Calendar.getInstance()
            date = cal.time
        }

        return TermeCalendarDialog()
            .setSingle(isSingle)
            .setFirstMonday(false)
            .setCallback(this)
            .setStartDate(date)
    }



    private fun hideCalender() {
        (ctx.supportFragmentManager.findFragmentByTag(fmTag) as DialogFragment?)?.dismissAllowingStateLoss()
    }

    fun showCalender(isSingle : Boolean = false) {
        Timber.plant(Timber.DebugTree())
        getCalendarDialog(isSingle = isSingle).show(ctx.supportFragmentManager, fmTag)
    }


    override fun showYearList(date: Date) {
        hideCalender()
        MonthYearPickerDialog.createDialogWithoutDateField(
            date
        ) { dialog, year, month ->
            Timber.e("MonthYearPickerDialog $year , $month")
            val cal = Calendar.getInstance()
            cal.set(year, month, cal.get(Calendar.DAY_OF_MONTH))
            getCalendarDialog(cal.time).show(ctx.supportFragmentManager, fmTag)
            dialog.dismissAllowingStateLoss()
            MonthYearPickerDialog.released()
        }.show(ctx.supportFragmentManager, "YearLis")
    }

    override fun onCancelled() {
        Timber.e("onCancelled")
        hideCalender()
    }

    override fun onDataSelected(
        firstDate: Calendar?,
        secondDate: Calendar?,
        hours: Int,
        minutes: Int
    ) {
        callback?.invoke(firstDate, secondDate, hours, minutes)
        Timber.e(
            "onDataSelected " +
                    "${firstDate?.get(Calendar.YEAR)} , " +
                    "${firstDate?.get(Calendar.MONTH)?.plus(1)} ," +
                    "${firstDate?.get(Calendar.DAY_OF_MONTH)}"
        )
    }
}
