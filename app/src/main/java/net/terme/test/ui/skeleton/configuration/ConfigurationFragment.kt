package net.terme.test.ui.skeleton.configuration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SeekBar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import net.terme.test.databinding.FragmentConfigurationBinding
import net.terme.test.R
import net.terme.test.ui.skeleton.MainPagerFragment

class ConfigurationFragment : BottomSheetDialogFragment() {

    private lateinit var configurationListener: ConfigurationListener
    private var _binding: FragmentConfigurationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentConfigurationBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadConfiguration()
        initMaskView()
        initShimmerView()
    }

    private fun loadConfiguration() {
        arguments?.apply {
            binding.maskColorView.selectColor(getInt(ARGUMENT_MASK_COLOR))

            val maskCornerRadius = getFloat(ARGUMENT_MASK_CORNER_RADIUS)
            val maskCornerRadiusProgress = ((maskCornerRadius / MAX_MASK_CORNER_RADIUS) * 100).toInt()
            binding.maskCornerRadiusView.progress = maskCornerRadiusProgress
            binding.maskCornerRadiusLabel.text = String.format(getString(R.string.mask_corner_radius), maskCornerRadius.toInt())
            binding.shimmerShowView.isChecked = getBoolean(ARGUMENT_SHOW_SHIMMER)
            binding.shimmerColorView.selectColor(getInt(ARGUMENT_SHIMMER_COLOR))

            val shimmerDuration = getLong(ARGUMENT_SHIMMER_DURATION_IN_MILLIS)
            val shimmerDurationProgress = ((shimmerDuration.toFloat() / MAX_SHIMMER_DURATION_IN_MILLIS) * 100).toInt()
            binding.shimmerDurationView.progress = shimmerDurationProgress
            binding.shimmerDurationLabel.text = String.format(getString(R.string.shimmer_duration), shimmerDuration)

            val shimmerDirection = getInt(ARGUMENT_SHIMMER_DIRECTION)
            binding.shimmerDirectionView.setSelection(shimmerDirection)

            val shimmerAngle = getInt(ARGUMENT_SHIMMER_ANGLE)
            val shimmerAngleProgress = ((shimmerAngle.toFloat() / MAX_SHIMMER_ANGLE) * 100).toInt()
            binding.shimmerAngleView.progress = shimmerAngleProgress
            binding.shimmerAngleLabel.text = String.format(getString(R.string.shimmer_angle), shimmerAngle)
        }
    }

    private fun initMaskView() {
       binding.maskColorView.setListener { _, color -> configurationListener.onMaskColorChanged(color) }
       binding.maskCornerRadiusView.onProgressChanged { progress ->
            val cornerRadius = (progress.toFloat() / 100) * MAX_MASK_CORNER_RADIUS
           binding. maskCornerRadiusLabel.text = String.format(getString(R.string.mask_corner_radius), cornerRadius.toInt())
            configurationListener.onMaskCornerRadiusChanged(cornerRadius)
        }
    }

    private fun initShimmerView() {
        binding.shimmerShowView.setOnCheckedChangeListener { _, isChecked -> configurationListener.onShowShimmerChanged(isChecked) }
        binding.shimmerColorView.setListener { _, color -> configurationListener.onShimmerColorChanged(color) }
        binding.shimmerDurationView.onProgressChanged { progress ->
            val durationInMillis = ((progress.toFloat() / 100) * MAX_SHIMMER_DURATION_IN_MILLIS).toLong()
            binding.shimmerDurationLabel.text = String.format(getString(R.string.shimmer_duration), durationInMillis)
            configurationListener.onShimmerDurationChanged(durationInMillis)
        }
        binding. shimmerDirectionView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                configurationListener.onShimmerDirectionChanged(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }
        binding. shimmerAngleView.onProgressChanged { progress ->
            val angle = ((progress.toFloat() / 100) * MAX_SHIMMER_ANGLE).toInt()
            binding.shimmerAngleLabel.text = String.format(getString(R.string.shimmer_angle), angle)
            configurationListener.onShimmerAngleChanged(angle)
        }
    }

    private fun SeekBar.onProgressChanged(onProgressChanged: (progress: Int) -> Unit) {
        setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                onProgressChanged(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
        })
    }

    companion object {

        private const val ARGUMENT_MASK_CORNER_RADIUS = "maskCornerRadius"
        private const val ARGUMENT_MASK_COLOR = "maskColor"
        private const val ARGUMENT_SHOW_SHIMMER = "showShimmer"
        private const val ARGUMENT_SHIMMER_COLOR = "shimmerColor"
        private const val ARGUMENT_SHIMMER_DURATION_IN_MILLIS = "shimmerDurationInMillis"
        private const val ARGUMENT_SHIMMER_DIRECTION = "shimmerDirection"
        private const val ARGUMENT_SHIMMER_ANGLE = "shimmerAngle"

        private const val MAX_MASK_CORNER_RADIUS = 100f
        private const val MAX_SHIMMER_DURATION_IN_MILLIS = 10000L
        private const val MAX_SHIMMER_ANGLE = 360

        fun newInstance(child: MainPagerFragment): ConfigurationFragment {
            val fragment = ConfigurationFragment()
            fragment.configurationListener = child

            val skeleton = child.skeleton

            val arguments = Bundle()
            arguments.putFloat(ARGUMENT_MASK_CORNER_RADIUS, skeleton.maskCornerRadius)
            arguments.putInt(ARGUMENT_MASK_COLOR, skeleton.maskColor)
            arguments.putBoolean(ARGUMENT_SHOW_SHIMMER, skeleton.showShimmer)
            arguments.putInt(ARGUMENT_SHIMMER_COLOR, skeleton.shimmerColor)
            arguments.putLong(ARGUMENT_SHIMMER_DURATION_IN_MILLIS, skeleton.shimmerDurationInMillis)
            arguments.putInt(ARGUMENT_SHIMMER_DIRECTION, skeleton.shimmerDirection.ordinal)
            arguments.putInt(ARGUMENT_SHIMMER_ANGLE, skeleton.shimmerAngle)
            fragment.arguments = arguments

            return fragment
        }
    }
}