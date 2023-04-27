package net.lynqfy.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Button
import android.widget.Toast
import net.lynqfy.offical.callbacks.OnItemClickListener
import net.lynqfy.offical.card.LyCardView
import net.lynqfy.offical.datepicker.LyDatePicker
import net.lynqfy.offical.model.Item
import net.lynqfy.offical.toast.LyToast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    val activityTabCommon by lazy { findViewById<LyButton>(R.id.tabActitivy1) }
    val activityTabSegment by lazy { findViewById<LyButton>(R.id.tabActitivy2) }
    val activityTabSliding by lazy { findViewById<LyButton>(R.id.tabActitivy3) }
    val activityButton by lazy { findViewById<LyButton>(R.id.tabButton) }
    val activityEditText by lazy { findViewById<LyButton>(R.id.tabEditText) }
    val activityTextView by lazy { findViewById<LyButton>(R.id.tabTextView) }
    val activityImageView by lazy { findViewById<LyButton>(R.id.tabImageView) }
    val activityAlert by lazy { findViewById<LyButton>(R.id.tabAlert) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityTabCommon.onClickListener = clickListener
        activityTabSegment.onClickListener = clickListener
        activityTabSliding.onClickListener = clickListener
        activityButton.onClickListener = clickListener
        activityEditText.onClickListener = clickListener
        activityTextView.onClickListener = clickListener
        activityAlert.onClickListener = clickListener
        activityImageView.onClickListener = clickListener
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

    val clickListener = object : LyView.OnClickListener {
        override fun onButtonClick(button: View) {

            startActivity(
                Intent(
                    this@MainActivity,
                    when (button) {
                        activityTabCommon.button -> TabLayoutActivity1::class.java
                        activityTabSegment.button -> TabLayoutActivity2::class.java
                        activityTabSliding.button -> TabLayoutActivity3::class.java
                        activityButton.button -> ButtonActivity::class.java
                        activityEditText.button -> EditTextActivity::class.java
                        activityTextView.button -> TextViewActivity::class.java
                        activityImageView.button -> ImageViewActivity::class.java
                        activityAlert.button -> AlertActivity::class.java
                        else -> TabLayoutActivity3::class.java
                    },
                )
            )
        }
    }
}