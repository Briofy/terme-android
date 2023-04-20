package net.lynqfy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import net.lynqfy.offical.callbacks.OnItemClickListener
import net.lynqfy.offical.card.LyCardView
import net.lynqfy.offical.card.typed.crypto.Crypto
import net.lynqfy.offical.model.Item

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tt = findViewById<LyCardView>(R.id.card_button_card)
        val cc = findViewById<LyCardView>(R.id.crypto_card)

        cc.getLyAction().onBadgeClicked {
            Toast.makeText(this,"BadgeClicked" ,Toast.LENGTH_LONG).show()
        }
        tt.getLyAction().onButtonClicked {
            Toast.makeText(this,"ButtonClicked" ,Toast.LENGTH_LONG).show()
        }
        cc.getLyAction().onOnItemClickListener(object : OnItemClickListener{
            override fun onItemClicked(index: Int, item: Item) {
                Toast.makeText(this@MainActivity,"ItemClicked Index $index , ${item.name}" ,Toast.LENGTH_LONG).show()
            }
        })
    }
}