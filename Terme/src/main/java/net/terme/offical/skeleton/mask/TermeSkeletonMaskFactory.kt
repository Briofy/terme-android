package net.terme.offical.skeleton.mask

import android.view.View
import net.terme.offical.skeleton.TermeSkeletonConfig

internal object TermeSkeletonMaskFactory {

    fun createMask(
        view: View,
        config: TermeSkeletonConfig
    ): TermeTermeSkeletonMask {
        return when (config.showShimmer) {
            true -> TermeTermeSkeletonMaskShimmer(view, config.maskColor, config.shimmerColor, config.shimmerDurationInMillis, config.shimmerDirection, config.shimmerAngle)
            false -> TermeTermeSkeletonMaskSolid(view, config.maskColor)
        }
    }
}