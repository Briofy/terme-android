package net.lynqfy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import net.lynqfy.offical.LyButton
import net.lynqfy.offical.base.LyView
import net.lynqfy.offical.toast.LyToast

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
        val toastBtn = findViewById<LyButton>(R.id.btnToast)

        toastBtn.onClickListener = object : LyView.OnClickListener {
            override fun onButtonClick(button: View) {
                val toast = LyToast(
                    this@ToastActivity,
                    ResourcesCompat.getDrawable(resources,R.drawable.image_test , null),
                    "Ly Toast - Title ",
                    "This is LyToast, a Customizable Toast that is very easy to use."
                ) {
                }
                toast.show()
            }

        }
    }
}