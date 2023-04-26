package net.lynqfy.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.lynqfy.offical.LyTextView

class TestFragment1 : Fragment() {

    val index by lazy { arguments?.getInt("Index") ?: -1 }

    lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mView = LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_test, container, false)
        return mView

    }

    lateinit var tv: LyTextView
    lateinit var root: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv = mView.findViewById(R.id.tvTest)
        root = mView.findViewById(R.id.root)
        tv.text = " Index=$index "

        when (index) {
            0 -> {
                root.setBackgroundColor(requireContext().getColor(R.color.purple_200))
            }
            1 -> {
                root.setBackgroundColor(requireContext().getColor(R.color.purple_500))
            }
            2 -> {
                root.setBackgroundColor(requireContext().getColor(R.color.purple_700))
            }
            3 -> {
                root.setBackgroundColor(requireContext().getColor(R.color.teal_200))
            }
            4 -> {
                root.setBackgroundColor(requireContext().getColor(R.color.teal_700))
            }
            else -> {
                root.setBackgroundColor(requireContext().getColor(R.color.black))
            }
        }
    }
}