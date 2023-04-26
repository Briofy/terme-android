package net.lynqfy.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import net.lynqfy.offical.LyButton
import net.lynqfy.offical.base.LyView

class MainActivity : AppCompatActivity() {
    val activityTabCommon by lazy { findViewById<LyButton>(R.id.tabActitivy1) }
    val activityTabSegment by lazy { findViewById<LyButton>(R.id.tabActitivy2) }
    val activityTabSliding by lazy { findViewById<LyButton>(R.id.tabActitivy3) }
    val activityButton by lazy { findViewById<LyButton>(R.id.tabButton) }
    val activityEditText by lazy { findViewById<LyButton>(R.id.tabEditText) }
    val activityTextView by lazy { findViewById<LyButton>(R.id.tabTextView) }
    val activityImageView by lazy { findViewById<LyButton>(R.id.tabImageView) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityTabCommon.onClickListener = clickListener
        activityTabSegment.onClickListener = clickListener
        activityTabSliding.onClickListener = clickListener
        activityButton.onClickListener = clickListener
        activityEditText.onClickListener = clickListener
        activityTextView.onClickListener = clickListener
        activityImageView.onClickListener = clickListener


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
                        activityTextView.button -> TabLayoutActivity3::class.java
                        activityImageView.button -> TabLayoutActivity3::class.java
                        else -> TabLayoutActivity3::class.java
                    },
                )
            )
        }
    }
}