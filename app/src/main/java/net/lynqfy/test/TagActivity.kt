package net.lynqfy.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import net.lynqfy.offical.navbar.LyNavBar
import net.lynqfy.offical.tag.LyTag
import net.lynqfy.offical.toast.LyToast
import net.lynqfy.offical.tooltips.LyTooltip


class TagActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)

        val tag3 = findViewById<LyTag>(R.id.tag3)
        val tag2 = findViewById<LyNavBar>(R.id.navbar1)
        val navbar2 = findViewById<LyNavBar>(R.id.navbar2)

        tag2.onMenuAction {
           Log.e("TEST" , "LyNavBar is clicked : onMenuAction")
        }
        navbar2.onMenuAction {
           Log.e("TEST" , "LyNavBar is clicked : onMenuAction")
        }
        navbar2.onButtonAction {
           Log.e("TEST" , "LyNavBar is clicked : onButtonAction")
        }

        LyTooltip
            .on(this, tag3)
            .autoHide(false, 1000)
            .position(LyTooltip.Position.BOTTOM)
            .corner(30)
            .title("Navigational")
            .text("The users wants to find a specific page or site.")
            .show()
    }
}