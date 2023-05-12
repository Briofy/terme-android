package net.terme.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import net.terme.offical.TermeButton
import net.terme.offical.base.TermeView
import net.terme.offical.toast.TermeToast

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
        val toastBtn = findViewById<TermeButton>(R.id.btnToast)

        toastBtn.onClickListener = object : TermeView.OnClickListener {
            override fun onButtonClick(button: View) {
                val toast = TermeToast(
                    this@ToastActivity,
                    ResourcesCompat.getDrawable(resources,R.drawable.image_test , null),
                    "Ly Toast - Title ",
                    "This is TermeToast, a Customizable Toast that is very easy to use."
                ) {
                }
                toast.show()
            }

        }
    }
}