package net.lynqfy.offical.datepicker

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import java.util.Calendar
import java.util.Date

class LyDatePicker (private  val ctx : AppCompatActivity) : LyCalendarDialog.Callback {


    fun fggg() {
        LyCalendarDialog()
            .setSingle(false)
            .setFirstMonday(false)
            .setCallback(this)
            .show(ctx.supportFragmentManager, "TAG_LY_CALENDAR")
    }

    override fun showYearList(date: Date) {
        Toast.makeText(ctx, "WE Must show year list ui ", Toast.LENGTH_LONG)
            .show()
        MonthYearPickerDialog.createDialogWithoutDateField(date).show(ctx.supportFragmentManager,"dgfg")
    }

    override fun onCancelled() {
        Timber.e("onCancelled")
    }

    override fun onDataSelected(
        firstDate: Calendar?,
        secondDate: Calendar?,
        hours: Int,
        minutes: Int
    ) {
        Toast.makeText(ctx,"onDataSelected $firstDate , $secondDate" , Toast.LENGTH_LONG).show()
        Timber.e("onDataSelected $firstDate , $secondDate")
    }
}
