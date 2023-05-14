package net.terme.test.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.terme.offical.speeddial.SpeedDialActionItem
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
            it.addActionItem(SpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).create())
            it.addActionItem(SpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).create())
            it.addActionItem(SpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).create())
            it.addActionItem(SpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).create())
            it.addActionItem(SpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).create())
            it.addActionItem(SpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).create())
            it.addActionItem(SpeedDialActionItem.Builder(View.generateViewId(), R.drawable.ic1).create())

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}