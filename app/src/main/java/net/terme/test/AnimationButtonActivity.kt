package net.terme.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import net.terme.offical.TermeButton
import net.terme.offical.base.TermeView

class AnimationButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_button)
        findViewById<TermeButton>(R.id.btn1).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }

        findViewById<TermeButton>(R.id.btn2).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn3).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn4).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn5).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn6).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn7).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn8).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn9).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn10).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn11).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn12).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
        findViewById<TermeButton>(R.id.btn13).let {
            it.onClickListener = object : TermeView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isAnimated)
                        it.showAnimation()
                    else
                        it.hideAnimation()
                }

            }
        }
    }
}