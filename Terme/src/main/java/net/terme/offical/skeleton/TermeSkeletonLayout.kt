package net.terme.offical.skeleton

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import net.terme.offical.R
import net.terme.offical.base.views
import net.terme.offical.skeleton.mask.TermeSkeletonMask
import net.terme.offical.skeleton.mask.TermeSkeletonMaskFactory
import net.terme.offical.skeleton.mask.TermeSkeletonShimmerDirection
import timber.log.Timber

open class TermeSkeletonLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    originView: View? = null,
    private val config: TermeSkeletonConfig = TermeSkeletonConfig.default(context)
) : FrameLayout(context, attrs, defStyleAttr),
    TermeSkeleton, TermeSkeletonStyle by config {

    internal constructor(
        originView: View,
        config: TermeSkeletonConfig
    ) : this(originView.context, null, 0, originView, config)

    private var mask: TermeSkeletonMask? = null
    private var isSkeleton: Boolean = false
    private var isRendered: Boolean = false

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.TermeSkeletonLayout, 0, 0)
            this.maskColor = typedArray.getColor(R.styleable.TermeSkeletonLayout_maskColor, maskColor)
            this.maskCornerRadius = typedArray.getDimensionPixelSize(R.styleable.TermeSkeletonLayout_maskCornerRadius, maskCornerRadius.toInt()).toFloat()
            this.showShimmer = typedArray.getBoolean(R.styleable.TermeSkeletonLayout_showShimmer, showShimmer)
            this.shimmerColor = typedArray.getColor(R.styleable.TermeSkeletonLayout_shimmerColor, shimmerColor)
            this.shimmerDurationInMillis = typedArray.getInt(R.styleable.TermeSkeletonLayout_shimmerDurationInMillis, shimmerDurationInMillis.toInt()).toLong()
            this.shimmerDirection = TermeSkeletonShimmerDirection.valueOf(typedArray.getInt(R.styleable.TermeSkeletonLayout_shimmerDirection, shimmerDirection.ordinal)) ?: DEFAULT_SHIMMER_DIRECTION
            this.shimmerAngle = typedArray.getInt(R.styleable.TermeSkeletonLayout_shimmerAngle, shimmerAngle)
            typedArray.recycle()
        }
        config.addValueObserver(::invalidateMask)
        originView?.let { view -> addView(view) }
    }

    override fun showOriginal() {
        isSkeleton = false

        if (childCount > 0) {
            views().forEach { it.visibility = View.VISIBLE }
            mask?.stop()
            mask = null
        }
    }

    override fun showSkeleton() {
        isSkeleton = true

        if (isRendered) {
            if (childCount > 0) {
                views().forEach { it.visibility = View.INVISIBLE }
                setWillNotDraw(false)
                invalidateMask()
                mask?.invalidate()

            } else {
                Timber.i("No views to mask")
            }
        }
    }

    override fun isSkeleton(): Boolean = isSkeleton

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        isRendered = true

        if (isSkeleton) {
            showSkeleton()
        }
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        mask?.invalidate()
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        when (hasWindowFocus) {
            true -> mask?.start()
            false -> mask?.stop()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (isRendered) {
            invalidateMask()
            mask?.start()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mask?.stop()
    }

    override fun onDraw(canvas: Canvas) {
        mask?.draw(canvas)
    }

    private fun invalidateMask() {
        if (isRendered) {
            mask?.stop()
            mask = null
            if (isSkeleton) {
                if (width > 0 && height > 0) {
                    mask = TermeSkeletonMaskFactory
                        .createMask(this, config)
                        .also { mask -> mask.mask(this, maskCornerRadius) }
                } else {
                    Timber.e("Failed to mask view with invalid width and height")
                }
            }
        } else {
            Timber.e("Skipping invalidation until view is rendered")
        }
    }

    companion object {
        val DEFAULT_MASK_COLOR = R.color.skeleton_mask
        const val DEFAULT_MASK_CORNER_RADIUS = 8f
        const val DEFAULT_SHIMMER_SHOW = true
        val DEFAULT_SHIMMER_COLOR = R.color.skeleton_shimmer
        const val DEFAULT_SHIMMER_DURATION_IN_MILLIS = 2000L
        val DEFAULT_SHIMMER_DIRECTION = TermeSkeletonShimmerDirection.LEFT_TO_RIGHT
        const val DEFAULT_SHIMMER_ANGLE = 0
    }
}