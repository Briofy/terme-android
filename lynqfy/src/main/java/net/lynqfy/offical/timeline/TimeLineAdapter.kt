import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import net.lynqfy.offical.timeline.LyTimelineView

interface TimelineAdapter {
    fun getTimelineViewType(position: Int): LyTimelineView.ViewType? = null
    fun getIndicatorDrawable(position: Int): Drawable? = null
    @DrawableRes
    fun getIndicatorDrawableRes(position: Int): Int? = null
    fun getIndicatorStyle(position: Int): LyTimelineView.IndicatorStyle? = null
    fun getIndicatorColor(position: Int): Int? = null
    fun getLineColor(position: Int): Int? = null
    fun getLineStyle(position: Int): LyTimelineView.LineStyle? = null
    fun getLinePadding(position: Int): Float? = null
}