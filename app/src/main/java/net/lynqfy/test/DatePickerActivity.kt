package net.lynqfy.test

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.lynqfy.offical.LyButton
import net.lynqfy.offical.base.LyView
import net.lynqfy.offical.datepicker.LyDatePicker
import net.lynqfy.offical.toast.LyToast
import java.util.*

class DatePickerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)
        val rangeSelect = findViewById<LyButton>(R.id.rangeSelect)
        val singleSelect = findViewById<LyButton>(R.id.singleSelect)

        rangeSelect.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                val ly =
                    LyDatePicker(this@DatePickerActivity) { first: Calendar?, end: Calendar?, hours: Int, minutes: Int ->
                        val toast = LyToast(
                            this@DatePickerActivity, getDrawable(R.drawable.tt), "onDataSelected ",
                            "${first?.get(Calendar.YEAR)} , " +
                                    "${first?.get(Calendar.MONTH)?.plus(1)} ," +
                                    "${first?.get(Calendar.DAY_OF_MONTH)}"
                        ) {
                            Toast.makeText(this@DatePickerActivity, "replay", Toast.LENGTH_LONG)
                                .show()
                        }
                        toast.show()
                    }
                ly.showCalender()
            }

        }
        singleSelect.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                val ly =
                    LyDatePicker(this@DatePickerActivity) { first: Calendar?, end: Calendar?, hours: Int, minutes: Int ->
                        val toast = LyToast(
                            this@DatePickerActivity, getDrawable(R.drawable.tt), "onDataSelected ",
                            "${first?.get(Calendar.YEAR)} , " +
                                    "${first?.get(Calendar.MONTH)?.plus(1)} ," +
                                    "${first?.get(Calendar.DAY_OF_MONTH)}"
                        ) {
                            Toast.makeText(this@DatePickerActivity, "replay", Toast.LENGTH_LONG)
                                .show()
                        }
                        toast.show()
                    }
                ly.showCalender(true)
            }
        }

    }

}