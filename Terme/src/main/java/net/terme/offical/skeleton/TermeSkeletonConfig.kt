package net.terme.offical.skeleton

import android.content.Context
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import net.terme.offical.skeleton.mask.TermeSkeletonShimmerDirection
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

class TermeSkeletonConfig(
    @ColorInt maskColor: Int,
    maskCornerRadius: Float,
    showShimmer: Boolean,
    @ColorInt shimmerColor: Int,
    shimmerDurationInMillis: Long,
    shimmerDirection: TermeSkeletonShimmerDirection,
    shimmerAngle: Int,
) : TermeSkeletonStyle {

    @get:ColorInt override var maskColor: Int by observable(maskColor)
    override var maskCornerRadius: Float by observable(maskCornerRadius)
    override var showShimmer: Boolean by observable(showShimmer)
    @get:ColorInt override var shimmerColor: Int by observable(shimmerColor)
    override var shimmerDurationInMillis: Long by observable(shimmerDurationInMillis)
    override var shimmerDirection: TermeSkeletonShimmerDirection by observable(shimmerDirection)
    override var shimmerAngle: Int by observable(shimmerAngle)

    private val valueObservers = mutableListOf<(() -> Unit)>()

    private fun onValueChanged() {
        valueObservers.forEach { it.invoke() }
    }

    fun addValueObserver(onValueChanged: () -> Unit) {
        valueObservers.add(onValueChanged)
    }

    private fun <T> observable(value: T): ReadWriteProperty<Any?, T> {
        return Delegates.observable(value) { _, _, _ -> onValueChanged() }
    }

    companion object {

        fun default(context: Context): TermeSkeletonConfig {
            return TermeSkeletonConfig(
                maskColor = ContextCompat.getColor(context, TermeTermeTermeSkeletonLayout.DEFAULT_MASK_COLOR),
                maskCornerRadius = TermeTermeTermeSkeletonLayout.DEFAULT_MASK_CORNER_RADIUS,
                showShimmer = TermeTermeTermeSkeletonLayout.DEFAULT_SHIMMER_SHOW,
                shimmerColor = ContextCompat.getColor(context, TermeTermeTermeSkeletonLayout.DEFAULT_SHIMMER_COLOR),
                shimmerDurationInMillis = TermeTermeTermeSkeletonLayout.DEFAULT_SHIMMER_DURATION_IN_MILLIS,
                shimmerDirection = TermeTermeTermeSkeletonLayout.DEFAULT_SHIMMER_DIRECTION,
                shimmerAngle = TermeTermeTermeSkeletonLayout.DEFAULT_SHIMMER_ANGLE
            )
        }
    }
}