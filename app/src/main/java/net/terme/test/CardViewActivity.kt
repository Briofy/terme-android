package net.terme.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import net.terme.offical.callbacks.OnItemClickListener
import net.terme.offical.card.TermeCardView
import net.terme.offical.model.Item
import net.terme.offical.toast.TermeToast

class CardViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        val tt = findViewById<TermeCardView>(R.id.card_button_card)
        val cc = findViewById<TermeCardView>(R.id.crypto_card)

        tt.getLyAction().onButtonClicked {
            Toast.makeText(this, "ButtonClicked", Toast.LENGTH_LONG).show()
        }
        cc.getLyAction().onBadgeClicked {
            Toast.makeText(this, "BadgeClicked", Toast.LENGTH_LONG).show()
        }

        cc.getLyAction().onOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(index: Int, item: Item) {
                val toast = TermeToast(
                    this@CardViewActivity, item.logo, "ItemClicked ",
                    "ItemClicked Index $index , ${item.name}"
                ) {
                    Toast.makeText(this@CardViewActivity, "replay", Toast.LENGTH_LONG).show()
                }
                toast.show()

            }
        })
    }
}