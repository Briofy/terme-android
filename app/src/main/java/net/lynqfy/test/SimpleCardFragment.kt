package net.lynqfy.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import net.lynqfy.offical.LyTextView


class SimpleCardFragment : Fragment() {
    private var mTitle: String? = null

    companion object {
        fun getInstance(title: String?): SimpleCardFragment {
            val sf = SimpleCardFragment()
            sf.mTitle = title
            return sf
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_test, null)
        val card_title_tv: LyTextView = v.findViewById(R.id.tvTest)
        card_title_tv.text = mTitle
        return v
    }
}