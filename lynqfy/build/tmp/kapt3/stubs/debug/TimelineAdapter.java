
import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0017\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0002\u0010\u0005J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0013"}, d2 = {"LTimelineAdapter;", "", "getIndicatorColor", "", "position", "(I)Ljava/lang/Integer;", "getIndicatorDrawable", "Landroid/graphics/drawable/Drawable;", "getIndicatorDrawableRes", "getIndicatorStyle", "Lnet/lynqfy/offical/timeline/LyTimelineView$IndicatorStyle;", "getLineColor", "getLinePadding", "", "(I)Ljava/lang/Float;", "getLineStyle", "Lnet/lynqfy/offical/timeline/LyTimelineView$LineStyle;", "getTimelineViewType", "Lnet/lynqfy/offical/timeline/LyTimelineView$ViewType;", "lynqfy_debug"})
public abstract interface TimelineAdapter {
    
    @org.jetbrains.annotations.Nullable()
    public abstract net.lynqfy.offical.timeline.LyTimelineView.ViewType getTimelineViewType(int position);
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.graphics.drawable.Drawable getIndicatorDrawable(int position);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.DrawableRes()
    public abstract java.lang.Integer getIndicatorDrawableRes(int position);
    
    @org.jetbrains.annotations.Nullable()
    public abstract net.lynqfy.offical.timeline.LyTimelineView.IndicatorStyle getIndicatorStyle(int position);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Integer getIndicatorColor(int position);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Integer getLineColor(int position);
    
    @org.jetbrains.annotations.Nullable()
    public abstract net.lynqfy.offical.timeline.LyTimelineView.LineStyle getLineStyle(int position);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Float getLinePadding(int position);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable()
        public static net.lynqfy.offical.timeline.LyTimelineView.ViewType getTimelineViewType(@org.jetbrains.annotations.NotNull()
        TimelineAdapter $this, int position) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public static android.graphics.drawable.Drawable getIndicatorDrawable(@org.jetbrains.annotations.NotNull()
        TimelineAdapter $this, int position) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @androidx.annotation.DrawableRes()
        public static java.lang.Integer getIndicatorDrawableRes(@org.jetbrains.annotations.NotNull()
        TimelineAdapter $this, int position) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public static net.lynqfy.offical.timeline.LyTimelineView.IndicatorStyle getIndicatorStyle(@org.jetbrains.annotations.NotNull()
        TimelineAdapter $this, int position) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Integer getIndicatorColor(@org.jetbrains.annotations.NotNull()
        TimelineAdapter $this, int position) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Integer getLineColor(@org.jetbrains.annotations.NotNull()
        TimelineAdapter $this, int position) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public static net.lynqfy.offical.timeline.LyTimelineView.LineStyle getLineStyle(@org.jetbrains.annotations.NotNull()
        TimelineAdapter $this, int position) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Float getLinePadding(@org.jetbrains.annotations.NotNull()
        TimelineAdapter $this, int position) {
            return null;
        }
    }
}