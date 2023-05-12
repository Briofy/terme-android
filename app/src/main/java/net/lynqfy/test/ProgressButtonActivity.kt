package net.lynqfy.test

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import net.lynqfy.offical.LyButton
import net.lynqfy.offical.base.LyView

class ProgressButtonActivity : AppCompatActivity() {
    lateinit var btn1: LyButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_button)

        findViewById<LyButton>(R.id.btn1).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }

        findViewById<LyButton>(R.id.btn2).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn3).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn4).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn5).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn6).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn7).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn8).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn9).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn10).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn11).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn12).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }
        findViewById<LyButton>(R.id.btn13).let {
            it.onClickListener = object : LyView.OnClickListener {
                override fun onButtonClick(button: View) {
                    if (!it.isProgress)
                        it.startProgress()
                    else
                        it.stopProgress()
                }

            }
        }

    }

}