package net.terme.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.terme.offical.TermeTextView


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
        val card_title_tv: TermeTextView = v.findViewById(R.id.tvTest)
        card_title_tv.text = mTitle
        return v
    }
}