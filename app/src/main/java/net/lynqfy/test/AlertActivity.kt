package net.lynqfy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import net.lynqfy.offical.AlertType
import net.lynqfy.offical.LyAlert
import net.lynqfy.offical.LyButton
import net.lynqfy.offical.base.LyView

class AlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
        val message = findViewById<LyButton>(R.id.ly_message)
        val info = findViewById<LyButton>(R.id.ly_info)
        val error = findViewById<LyButton>(R.id.ly_error)
        val success = findViewById<LyButton>(R.id.ly_success)
        val warning = findViewById<LyButton>(R.id.ly_warning)

        message.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                val alert = LyAlert.Builder(this@AlertActivity)
                    .setTitle("Message Alert Title")
                    .setMessage("This Is Message Alert test.The Lorem ipsum text is derived from sections 1.10.32 and 1.10.33 of Cicero's 'De finibus bonorum et malorum")
                    .setButtonText("Message Button")
                    .setIconRes(net.lynqfy.offical.R.drawable.ic_alert_icon)
                    .setCancelable(true)
                    .setType(AlertType.MESSAGE)
                    .build()
                alert.show(supportFragmentManager, "")
            }
        }
        info.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                val alert = LyAlert.Builder(this@AlertActivity)
                    .setTitle("Info Alert Title")
                    .setMessage("This Is Info Alert test.The Lorem ipsum text is derived from sections 1.10.32 and 1.10.33 of Cicero's 'De finibus bonorum et malorum")
                    .setButtonText("Info Button")
                    .setIconRes(net.lynqfy.offical.R.drawable.ic_alert_icon)
                    .setCancelable(true)
                    .setType(AlertType.INFO)
                    .build()
                alert.show(supportFragmentManager, "")
            }
        }
        error.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                val alert = LyAlert.Builder(this@AlertActivity)
                    .setTitle("ERROR Alert Title")
                    .setMessage("This Is ERROR Alert test.The Lorem ipsum text is derived from sections 1.10.32 and 1.10.33 of Cicero's 'De finibus bonorum et malorum")
                    .setButtonText("ERROR Button")
                    .setIconRes(net.lynqfy.offical.R.drawable.ic_alert_icon)
                    .setCancelable(true)
                    .setType(AlertType.ERROR)
                    .build()
                alert.show(supportFragmentManager, "")
            }
        }
        success.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                val alert = LyAlert.Builder(this@AlertActivity)
                    .setTitle("SUCCESS Alert Title")
                    .setMessage("This Is SUCCESS Alert test.The Lorem ipsum text is derived from sections 1.10.32 and 1.10.33 of Cicero's 'De finibus bonorum et malorum")
                    .setButtonText("SUCCESS Button")
                    .setIconRes(net.lynqfy.offical.R.drawable.ic_alert_icon)
                    .setCancelable(true)
                    .setType(AlertType.SUCCESS)
                    .build()
                alert.show(supportFragmentManager, "")
            }
        }
        warning.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                val alert = LyAlert.Builder(this@AlertActivity)
                    .setTitle("Warning Alert Title")
                    .setMessage("This Is Warning Alert test.The Lorem ipsum text is derived from sections 1.10.32 and 1.10.33 of Cicero's 'De finibus bonorum et malorum")
                    .setButtonText("Warning Button")
                    .setIconRes(net.lynqfy.offical.R.drawable.ic_alert_icon)
                    .setCancelable(true)
                    .setType(AlertType.WARNING)
                    .build()
                alert.show(supportFragmentManager, "")
            }
        }

    }
}