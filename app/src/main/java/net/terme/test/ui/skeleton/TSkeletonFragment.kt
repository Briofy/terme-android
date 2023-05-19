package net.terme.test.ui.skeleton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import net.terme.offical.skeleton.TermeSkeleton
import net.terme.test.databinding.FragmentGalleryBinding
import net.terme.test.ui.skeleton.configuration.ConfigurationFragment
import net.terme.test.ui.skeleton.recyclerview.RecyclerViewFragment
import net.terme.test.ui.skeleton.viewgroup.ViewGroupFragment
import net.terme.test.ui.skeleton.viewpager2.ViewPager2Fragment

class TSkeletonFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewPagerAdapter: MainPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initLayout()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun getSkeleton(): TermeSkeleton? {
        return (viewPagerAdapter.getItem(binding.viewPager.currentItem) as? MainPagerFragment)?.skeleton
    }
    private fun initLayout() {


        viewPagerAdapter = MainPagerAdapter(requireActivity().supportFragmentManager, arrayOf(RecyclerViewFragment(),
            ViewGroupFragment(), ViewPager2Fragment()
        ))
        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) = invalidateSkeleton()
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        })

        binding.fab.setOnClickListener { openConfiguration() }
    }

    private fun invalidateSkeleton() {
        val skeleton = getSkeleton() ?: return
        val shouldShow = binding.fab.visibility == View.VISIBLE
        val isShown = skeleton.isSkeleton()
        if (shouldShow != isShown) {
            if (shouldShow) {
                showSkeleton(skeleton)
            } else {
                hideSkeleton(skeleton)
            }
        }
    }

    private fun toggleSkeleton() {
        val skeleton = getSkeleton() ?: return
        if (skeleton.isSkeleton()) {
            hideSkeleton(skeleton)
        } else {
            showSkeleton(skeleton)
        }
    }

    private fun showSkeleton(skeleton: TermeSkeleton) {
        skeleton.showSkeleton()
        binding.fab.visibility = View.VISIBLE
    }

    private fun hideSkeleton(skeleton: TermeSkeleton) {
        skeleton.showOriginal()
        binding. fab.visibility = View.GONE
    }

    private fun openConfiguration() {
        val visibleFragment = viewPagerAdapter.getItem(binding.viewPager.currentItem)
        ConfigurationFragment.newInstance(visibleFragment).show(requireActivity().supportFragmentManager, "bottomSheet")
    }
}