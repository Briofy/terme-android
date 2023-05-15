package net.terme.test.ui.slideshow

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.terme.offical.speeddial.TermeFabWithLabelView
import net.terme.offical.speeddial.TermeSpeedDialActionItem
import net.terme.offical.tooltips.TermeTooltip
import net.terme.test.R
import net.terme.test.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this)[SlideshowViewModel::class.java]

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.textviewSecond.also {
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabel("GGGGG")
                setLabelBackgroundColor(Color.RED)

            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabel("GGGGG")
            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabelClickable(false)
            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
            }.create())

            it.setOnActionSelectedListener { o ->
                true
            }
        }
        binding.textviewSecond1.also {
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabel("GGGGG")
                setLabelBackgroundColor(Color.RED)

            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabel("GGGGG")
            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabelClickable(false)
            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabelBackgroundColor(Color.TRANSPARENT)
            }.create())

            it.setOnActionSelectedListener { o ->
                true
            }
        }
        binding.textviewSecond2.also {
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabel("GGGGG")
                setLabelBackgroundColor(Color.RED)

            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabel("GGGGG")
            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabelClickable(false)
            }.create())
            it.addActionItem(TermeSpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).apply {
                setLabelBackgroundColor(Color.TRANSPARENT)
            }.create())

            it.setOnActionSelectedListener { o ->
                true
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}