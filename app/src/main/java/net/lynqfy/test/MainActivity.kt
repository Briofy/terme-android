package net.lynqfy.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import net.lynqfy.offical.LyButton
import net.lynqfy.offical.base.LyView


class MainActivity : AppCompatActivity() {
    private val activityTabCommon by lazy { findViewById<LyButton>(R.id.tabActitivy1) }
    private val activityTabSegment by lazy { findViewById<LyButton>(R.id.tabActitivy2) }
    private val activityTabSliding by lazy { findViewById<LyButton>(R.id.tabActitivy3) }
    private val activityButton by lazy { findViewById<LyButton>(R.id.tabButton) }
    private val activityEditText by lazy { findViewById<LyButton>(R.id.tabEditText) }
    private val activityTextView by lazy { findViewById<LyButton>(R.id.tabTextView) }
    private val activityImageView by lazy { findViewById<LyButton>(R.id.tabImageView) }
    private val activityAlert by lazy { findViewById<LyButton>(R.id.tabAlert) }
    private val activityCardView by lazy { findViewById<LyButton>(R.id.tabCardView) }
    private val activityDatePicker by lazy { findViewById<LyButton>(R.id.tabDatePicker) }
    private val activityTag by lazy { findViewById<LyButton>(R.id.tabTag) }
    private val activityProgressBar by lazy { findViewById<LyButton>(R.id.tabProgress) }
    private val activitySpinner by lazy { findViewById<LyButton>(R.id.tabSpinner) }
    private val activityRadioButton by lazy { findViewById<LyButton>(R.id.tabRadioButton) }
    private val activityToast by lazy { findViewById<LyButton>(R.id.tabToast) }
    private val activityCheckBox by lazy { findViewById<LyButton>(R.id.tabCheckBox) }
    private val activitySeekArc by lazy { findViewById<LyButton>(R.id.tabSeekArc) }
    private val activityNavBar by lazy { findViewById<LyButton>(R.id.NavBar) }
    private val activitytimeLine by lazy { findViewById<LyButton>(R.id.timeLine) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityTabCommon.onClickListener = clickListener
        activityTabSegment.onClickListener = clickListener
        activityTabSliding.onClickListener = clickListener
        activityButton.onClickListener = clickListener
        activityEditText.onClickListener = clickListener
        activityTextView.onClickListener = clickListener
        activityAlert.onClickListener = clickListener
        activityImageView.onClickListener = clickListener
        activityCardView.onClickListener = clickListener
        activityDatePicker.onClickListener = clickListener
        activityTag.onClickListener = clickListener
        activityProgressBar.onClickListener = clickListener
        activityRadioButton.onClickListener = clickListener
        activitySpinner.onClickListener = clickListener
        activityToast.onClickListener = clickListener
        activityCheckBox.onClickListener = clickListener
        activitySeekArc.onClickListener = clickListener
        activityNavBar.onClickListener = clickListener
        activitytimeLine.onClickListener = clickListener
    }

   private val clickListener = object : LyView.OnClickListener {
        override fun onButtonClick(button: View) {

            startActivity(
                Intent(
                    this@MainActivity,
                    when (button) {
                        activityTabCommon.button -> TabLayoutActivity1::class.java
                        activityTabSegment.button -> TabLayoutActivity2::class.java
                        activityTabSliding.button -> TabLayoutActivity3::class.java
                        activityButton.button -> ButtonActivity::class.java
                        activityEditText.button -> EditTextActivity::class.java
                        activityTextView.button -> TextViewActivity::class.java
                        activityImageView.button -> ImageViewActivity::class.java
                        activityAlert.button -> AlertActivity::class.java
                        activityCardView.button -> CardViewActivity::class.java
                        activityDatePicker.button -> DatePickerActivity::class.java
                        activityTag.button -> TagActivity::class.java
                        activityProgressBar.button -> ProgressBarActivity::class.java
                        activitySpinner.button -> SpinnerActivity::class.java
                        activityRadioButton.button -> RadioButtonActivity::class.java
                        activityToast.button -> ToastActivity::class.java
                        activityCheckBox.button -> CheckBoxActivity::class.java
                        activitySeekArc.button -> SeekArcActivity::class.java
                        activityNavBar.button -> NavBarActivity::class.java
                        activitytimeLine.button -> TimelineActivity::class.java

                        else -> TabLayoutActivity3::class.java
                    },
                )
            )
        }
    }
}