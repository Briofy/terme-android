package net.terme.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.terme.offical.radio.TermeRadio
import net.terme.offical.radio.TermeRadioGroup

class RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        val radioGroup = findViewById<TermeRadioGroup>(R.id.radioGroup)
        val radio1 = findViewById<TermeRadio>(R.id.radio1)
        val radio2 = findViewById<TermeRadio>(R.id.radio2)

        Log.e("FF" , " ${radio1.id} ,radio2 ${radio2.id}")
        Log.e("FF" , " ${radio1.getHelper()} ,radio2 ${radio2.getHelper()}")


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.e("FF" , "$group , $checkedId")
        }
    }
}