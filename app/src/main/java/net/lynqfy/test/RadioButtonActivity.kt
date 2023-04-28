package net.lynqfy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import net.lynqfy.offical.radio.LyRadio
import net.lynqfy.offical.radio.LyRadioGroup
import java.util.Timer

class RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        val radioGroup = findViewById<LyRadioGroup>(R.id.radioGroup)
        val radio1 = findViewById<LyRadio>(R.id.radio1)
        val radio2 = findViewById<LyRadio>(R.id.radio2)

        Log.e("FF" , " ${radio1.id} ,radio2 ${radio2.id}")
        Log.e("FF" , " ${radio1.getHelper()} ,radio2 ${radio2.getHelper()}")


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.e("FF" , "$group , $checkedId")
        }
    }
}