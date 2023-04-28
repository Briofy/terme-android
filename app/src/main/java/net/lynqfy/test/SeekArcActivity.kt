package net.lynqfy.test

import android.os.Bundle
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.lynqfy.offical.LySeekArc
import net.lynqfy.offical.LyTextView


class SeekArcActivity : AppCompatActivity() {
    private lateinit var mSeekArc: LySeekArc
    private lateinit var mRotation: SeekBar
    private lateinit var mStartAngle: SeekBar
    private lateinit var mSweepAngle: SeekBar
    private lateinit var mArcWidth: SeekBar
    private lateinit var mProgressWidth: SeekBar
    private lateinit var mRoundedEdges: CheckBox
    private lateinit var mTouchInside: CheckBox
    private lateinit var mClockwise: CheckBox
    private lateinit var mSeekArcProgress: LyTextView
    private lateinit var mEnabled: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_arc)
        mSeekArc = findViewById(R.id.seekArc);
        mSeekArcProgress = findViewById(R.id.seekArcProgress);
        mRotation = findViewById(R.id.rotation);
        mStartAngle = findViewById(R.id.startAngle);
        mSweepAngle = findViewById(R.id.sweepAngle);
        mArcWidth = findViewById(R.id.arcWidth);
        mProgressWidth = findViewById(R.id.progressWidth);
        mRoundedEdges = findViewById(R.id.roundedEdges);
        mTouchInside = findViewById(R.id.touchInside);
        mClockwise = findViewById(R.id.clockwise);
        mEnabled = findViewById(R.id.enabled);

        mRotation.progress = mSeekArc.arcRotation
        mStartAngle.progress = mSeekArc.startAngle
        mSweepAngle.progress = mSeekArc.sweepAngle
        mArcWidth.progress = mSeekArc.arcWidth
        mProgressWidth.progress = mSeekArc.progressWidth

        mSeekArc.setOnLySeekArcChangeListener(object : LySeekArc.OnLySeekArcChangeListener {
            override fun onStopTrackingTouch(seekArc: LySeekArc?) {}
            override fun onStartTrackingTouch(seekArc: LySeekArc?) {}
            override fun onProgressChanged(
                seekArc: LySeekArc?, progress: Int,
                fromUser: Boolean
            ) {
                mSeekArcProgress.text = progress.toString()
            }
        })

        mRotation.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(arg0: SeekBar) {}
            override fun onStartTrackingTouch(arg0: SeekBar) {}
            override fun onProgressChanged(view: SeekBar, progress: Int, fromUser: Boolean) {
                mSeekArc.arcRotation = progress
                mSeekArc.invalidate()
            }
        })

        mStartAngle.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(arg0: SeekBar) {}
            override fun onStartTrackingTouch(arg0: SeekBar) {}
            override fun onProgressChanged(view: SeekBar, progress: Int, fromUser: Boolean) {
                mSeekArc.startAngle = progress
                mSeekArc.invalidate()
            }
        })

        mSweepAngle.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(arg0: SeekBar) {}
            override fun onStartTrackingTouch(arg0: SeekBar) {}
            override fun onProgressChanged(view: SeekBar, progress: Int, fromUser: Boolean) {
                mSeekArc.sweepAngle = progress
                mSeekArc.invalidate()
            }
        })

        mArcWidth.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(arg0: SeekBar) {}
            override fun onStartTrackingTouch(arg0: SeekBar) {}
            override fun onProgressChanged(view: SeekBar, progress: Int, fromUser: Boolean) {
                mSeekArc.arcWidth = progress
                mSeekArc.invalidate()
            }
        })

        mProgressWidth.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(arg0: SeekBar) {}
            override fun onStartTrackingTouch(arg0: SeekBar) {}
            override fun onProgressChanged(view: SeekBar, progress: Int, fromUser: Boolean) {
                mSeekArc.progressWidth = progress
                mSeekArc.invalidate()
            }
        })

        mRoundedEdges.setOnCheckedChangeListener { buttonView, isChecked ->
            mSeekArc.setRoundedEdges(isChecked)
            mSeekArc.invalidate()
        }

        mTouchInside.setOnCheckedChangeListener { buttonView, isChecked ->
            mSeekArc.setTouchInSide(
                isChecked
            )
        }

        mClockwise.setOnCheckedChangeListener { buttonView, isChecked ->
            mSeekArc.isClockwise = isChecked
            mSeekArc.invalidate()
        }

        mEnabled.setOnCheckedChangeListener { buttonView, isChecked ->
            mSeekArc.isEnabled = isChecked
            mSeekArc.invalidate()
        }
    }
}