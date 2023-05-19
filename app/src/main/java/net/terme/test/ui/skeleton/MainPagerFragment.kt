package net.terme.test.ui.skeleton


import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import net.terme.offical.skeleton.TermeSkeleton
import net.terme.offical.skeleton.mask.TermeSkeletonShimmerDirection
import net.terme.test.ui.skeleton.configuration.ConfigurationListener

abstract class MainPagerFragment(
    @LayoutRes private val layoutResId: Int,
    val title: String
) : Fragment(layoutResId), ConfigurationListener {

    abstract var skeleton: TermeSkeleton

    override fun onMaskColorChanged(value: Int) {
        skeleton.maskColor = value
    }

    override fun onMaskCornerRadiusChanged(value: Float) {
        skeleton.maskCornerRadius = value
    }

    override fun onShowShimmerChanged(value: Boolean) {
        skeleton.showShimmer = value
    }

    override fun onShimmerColorChanged(value: Int) {
        skeleton.shimmerColor = value
    }

    override fun onShimmerDurationChanged(value: Long) {
        skeleton.shimmerDurationInMillis = value
    }

    override fun onShimmerDirectionChanged(value: Int) {
        skeleton.shimmerDirection = TermeSkeletonShimmerDirection.valueOf(value) ?: TermeSkeletonShimmerDirection.LEFT_TO_RIGHT
    }

    override fun onShimmerAngleChanged(value: Int) {
        skeleton.shimmerAngle = value
    }
}