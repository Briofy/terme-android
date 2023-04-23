package net.lynqfy.offical.datepicker.listeners

import java.util.Date

interface DateSelectListener {
    fun dateSelect(selectedDate: Date?)
    fun dateLongSelect(selectedDate: Date?)
}