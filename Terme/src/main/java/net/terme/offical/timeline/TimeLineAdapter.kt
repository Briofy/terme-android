import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import net.terme.offical.timeline.TermeTimelineView

interface TimelineAdapter {
    fun getTimelineViewType(position: Int): TermeTimelineView.ViewType? = null
    fun getIndicatorDrawable(position: Int): Drawable? = null
    @DrawableRes
    fun getIndicatorDrawableRes(position: Int): Int? = null
    fun getIndicatorStyle(position: Int): TermeTimelineView.IndicatorStyle? = null
    fun getIndicatorColor(position: Int): Int? = null
    fun getLineColor(position: Int): Int? = null
    fun getLineStyle(position: Int): TermeTimelineView.LineStyle? = null
    fun getLinePadding(position: Int): Float? = null
}