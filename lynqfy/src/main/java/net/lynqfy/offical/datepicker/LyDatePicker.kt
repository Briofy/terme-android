package net.lynqfy.offical.datepicker

import androidx.appcompat.app.AppCompatActivity

class LyDatePicker (private  val ctx : AppCompatActivity){


    fun fggg() {
        LyCalendarDialog()
            .setSingle(false)
            //.setCallback(listener)
            .show(ctx.supportFragmentManager, "TAG_SLYCALENDAR")
    }
}
