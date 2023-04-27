package net.lynqfy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import com.larswerkman.lobsterpicker.OnColorListener
import com.larswerkman.lobsterpicker.sliders.LobsterShadeSlider
import net.lynqfy.offical.LyImageView

class ImageViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ImageViewAc", "onCreate: CALLED")
        setContentView(R.layout.activity_image_view)
        val circularImageView = findViewById<LyImageView>(R.id.circularImageView)
        findViewById<SeekBar>(R.id.seekBarBorderWidth).onProgressChanged { circularImageView.borderWidth = it.toDp() }
        findViewById<SeekBar>(R.id.seekBarShadowRadius).onProgressChanged { circularImageView.shadowRadius = it.toDp() }
        findViewById<LobsterShadeSlider>(R.id.shadeSlider).onColorChanged {
            circularImageView.borderColor = it
            circularImageView.shadowColor = it
        }
    }

    //region Extensions
    private fun Int.toDp(): Float =
        this * resources.displayMetrics.density

    private fun SeekBar.onProgressChanged(onProgressChanged: (Int) -> Unit) {
        setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                onProgressChanged(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Nothing
            }
        })
    }

    private fun LobsterShadeSlider.onColorChanged(onColorChanged: (Int) -> Unit) {
        addOnColorListener(object : OnColorListener {
            override fun onColorChanged(color: Int) {
                onColorChanged(color)
            }

            override fun onColorSelected(color: Int) {
                // Nothing
            }
        })
    }
    //endregion

}