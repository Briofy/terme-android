package net.lynqfy.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import net.lynqfy.offical.LyButton
import net.lynqfy.offical.base.LyView

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        val btn1 = findViewById<LyButton>(R.id.btn1)
        btn1.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                startActivity(Intent(this@ButtonActivity, EditTextActivity::class.java))
            }

        }
    }
}