package net.lynqfy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import net.lynqfy.offical.callbacks.OnItemClickListener
import net.lynqfy.offical.card.LyCardView
import net.lynqfy.offical.datepicker.LyDatePicker
import net.lynqfy.offical.model.Item
import net.lynqfy.offical.toast.LyToast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tt = findViewById<LyCardView>(R.id.card_button_card)
        val cc = findViewById<LyCardView>(R.id.crypto_card)
        findViewById<Button>(R.id.datePicker).setOnClickListener {
            val ly =
                LyDatePicker(this@MainActivity) { first: Calendar?, end: Calendar?, hours: Int, minutes: Int ->
                    val toast = LyToast(
                        this,getDrawable(R.drawable.tt) ,"onDataSelected " ,
                                "${first?.get(Calendar.YEAR)} , " +
                                "${first?.get(Calendar.MONTH)?.plus(1)} ," +
                                "${first?.get(Calendar.DAY_OF_MONTH)}"
                    ) {
                        Toast.makeText(this, "replay", Toast.LENGTH_LONG).show()
                    }
                    toast.show()
                }
            ly.showCalender()
        }

        cc.getLyAction().onBadgeClicked {
            Toast.makeText(this, "BadgeClicked", Toast.LENGTH_LONG).show()
        }
        tt.getLyAction().onButtonClicked {
            Toast.makeText(this, "ButtonClicked", Toast.LENGTH_LONG).show()
        }
        cc.getLyAction().onOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(index: Int, item: Item) {
                val toast = LyToast(
                    this@MainActivity,item.logo ,"ItemClicked " ,
                    "ItemClicked Index $index , ${item.name}"
                ) {
                    Toast.makeText(this@MainActivity, "replay", Toast.LENGTH_LONG).show()
                }
                toast.show()

            }
        })
    }
}