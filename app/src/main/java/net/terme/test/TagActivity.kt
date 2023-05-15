package net.terme.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import net.terme.offical.navbar.TermeNavBar
import net.terme.offical.tag.TermeTag
import net.terme.offical.tooltips.TermeTooltip


class TagActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)

        val tag3 = findViewById<TermeTag>(R.id.tag3)
        val tag2 = findViewById<TermeNavBar>(R.id.navbar1)
        val navbar2 = findViewById<TermeNavBar>(R.id.navbar2)

//        tag2.onMenuAction {
//           Log.e("TEST" , "TermeNavBar is clicked : onMenuAction")
//        }
//        navbar2.onMenuAction {
//           Log.e("TEST" , "TermeNavBar is clicked : onMenuAction")
//        }
//        navbar2.onButtonAction {
//           Log.e("TEST" , "TermeNavBar is clicked : onButtonAction")
//        }

        TermeTooltip
            .on(this, tag3)
            .autoHide(false, 1000)
            .position(TermeTooltip.Position.BOTTOM)
            .corner(30)
            .title("Navigational")
            .text("The users wants to find a specific page or site.")
            .show()
    }
}