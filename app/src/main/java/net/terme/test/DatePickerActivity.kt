package net.terme.test

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.terme.offical.TermeButton
import net.terme.offical.base.TermeView
import net.terme.offical.datepicker.TermeDatePicker
import net.terme.offical.toast.TermeToast
import java.util.*

class DatePickerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)
        val rangeSelect = findViewById<TermeButton>(R.id.rangeSelect)
        val singleSelect = findViewById<TermeButton>(R.id.singleSelect)

        rangeSelect.onClickListener = object : TermeView.OnClickListener {
            override fun onButtonClick(button: View) {
                val ly =
                    TermeDatePicker(this@DatePickerActivity) { first: Calendar?, end: Calendar?, hours: Int, minutes: Int ->
                        val toast = TermeToast(
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
        singleSelect.onClickListener = object : TermeView.OnClickListener {
            override fun onButtonClick(button: View) {
                val ly =
                    TermeDatePicker(this@DatePickerActivity) { first: Calendar?, end: Calendar?, hours: Int, minutes: Int ->
                        val toast = TermeToast(
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