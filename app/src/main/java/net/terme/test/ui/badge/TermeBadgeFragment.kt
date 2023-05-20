package net.terme.test.ui.badge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.terme.offical.dropdown.TermeDropItem
import net.terme.test.R
import net.terme.test.databinding.FragmentHomeBinding

class TermeBadgeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val list = mutableListOf<TermeDropItem>()
       val icon =  resources.getDrawable(R.drawable.ic3 ,null)
        for (i in 0 .. 10){
            list.add(TermeDropItem(text = "Item $i" , icon = icon))
        }
        binding.dropdownMenu.add("GGG" , list)

        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}