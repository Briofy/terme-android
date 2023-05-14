package net.lynqfy.offical.timeline;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001BB\u00b9\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0018J(\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J \u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020@2\u0006\u0010:\u001a\u00020;2\u0006\u0010A\u001a\u00020=H\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b#\u0010\u001fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b)\u0010\u001aR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b*\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b+\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b.\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001d\u00a8\u0006C"}, d2 = {"Lnet/lynqfy/offical/timeline/TimelineDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "indicatorStyle", "Lnet/lynqfy/offical/timeline/LyTimelineView$IndicatorStyle;", "indicatorDrawable", "Landroid/graphics/drawable/Drawable;", "indicatorDrawableRes", "", "indicatorSize", "", "indicatorYPosition", "checkedIndicatorSize", "checkedIndicatorStrokeWidth", "lineStyle", "Lnet/lynqfy/offical/timeline/LyTimelineView$LineStyle;", "linePadding", "lineDashLength", "lineDashGap", "lineWidth", "padding", "position", "Lnet/lynqfy/offical/timeline/TimelineDecorator$Position;", "indicatorColor", "lineColor", "(Lnet/lynqfy/offical/timeline/LyTimelineView$IndicatorStyle;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;FFLjava/lang/Float;FLnet/lynqfy/offical/timeline/LyTimelineView$LineStyle;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;FLnet/lynqfy/offical/timeline/TimelineDecorator$Position;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCheckedIndicatorSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getCheckedIndicatorStrokeWidth", "()F", "getIndicatorColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIndicatorDrawable", "()Landroid/graphics/drawable/Drawable;", "getIndicatorDrawableRes", "getIndicatorSize", "getIndicatorStyle", "()Lnet/lynqfy/offical/timeline/LyTimelineView$IndicatorStyle;", "getIndicatorYPosition", "getLineColor", "getLineDashGap", "getLineDashLength", "getLinePadding", "getLineStyle", "()Lnet/lynqfy/offical/timeline/LyTimelineView$LineStyle;", "getLineWidth", "getPadding", "getPosition", "()Lnet/lynqfy/offical/timeline/TimelineDecorator$Position;", "width", "getWidth", "getItemOffsets", "", "rect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "state", "Position", "lynqfy_debug"})
public final class TimelineDecorator extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    @org.jetbrains.annotations.NotNull()
    private final net.lynqfy.offical.timeline.LyTimelineView.IndicatorStyle indicatorStyle = null;
    @org.jetbrains.annotations.Nullable()
    private final android.graphics.drawable.Drawable indicatorDrawable = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer indicatorDrawableRes = null;
    private final float indicatorSize = 0.0F;
    private final float indicatorYPosition = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float checkedIndicatorSize = null;
    private final float checkedIndicatorStrokeWidth = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private final net.lynqfy.offical.timeline.LyTimelineView.LineStyle lineStyle = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float linePadding = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float lineDashLength = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float lineDashGap = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float lineWidth = null;
    private final float padding = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final net.lynqfy.offical.timeline.TimelineDecorator.Position position = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer indicatorColor = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer lineColor = null;
    private final float width = 0.0F;
    
    public TimelineDecorator() {
        super();
    }
    
    public TimelineDecorator(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.timeline.LyTimelineView.IndicatorStyle indicatorStyle, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable indicatorDrawable, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.DrawableRes()
    java.lang.Integer indicatorDrawableRes, float indicatorSize, float indicatorYPosition, @org.jetbrains.annotations.Nullable()
    java.lang.Float checkedIndicatorSize, float checkedIndicatorStrokeWidth, @org.jetbrains.annotations.Nullable()
    net.lynqfy.offical.timeline.LyTimelineView.LineStyle lineStyle, @org.jetbrains.annotations.Nullable()
    java.lang.Float linePadding, @org.jetbrains.annotations.Nullable()
    java.lang.Float lineDashLength, @org.jetbrains.annotations.Nullable()
    java.lang.Float lineDashGap, @org.jetbrains.annotations.Nullable()
    java.lang.Float lineWidth, float padding, @org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.timeline.TimelineDecorator.Position position, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.ColorInt()
    java.lang.Integer indicatorColor, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.ColorInt()
    java.lang.Integer lineColor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.timeline.LyTimelineView.IndicatorStyle getIndicatorStyle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable getIndicatorDrawable() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getIndicatorDrawableRes() {
        return null;
    }
    
    public final float getIndicatorSize() {
        return 0.0F;
    }
    
    public final float getIndicatorYPosition() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getCheckedIndicatorSize() {
        return null;
    }
    
    public final float getCheckedIndicatorStrokeWidth() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final net.lynqfy.offical.timeline.LyTimelineView.LineStyle getLineStyle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getLinePadding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getLineDashLength() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getLineDashGap() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getLineWidth() {
        return null;
    }
    
    public final float getPadding() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.timeline.TimelineDecorator.Position getPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getIndicatorColor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLineColor() {
        return null;
    }
    
    public final float getWidth() {
        return 0.0F;
    }
    
    @java.lang.Override()
    public void getItemOffsets(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect rect, @org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.State s) {
    }
    
    @java.lang.Override()
    public void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas c, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.State state) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lnet/lynqfy/offical/timeline/TimelineDecorator$Position;", "", "(Ljava/lang/String;I)V", "Left", "Right", "lynqfy_debug"})
    public static enum Position {
        /*public static final*/ Left /* = new Left() */,
        /*public static final*/ Right /* = new Right() */;
        
        Position() {
        }
    }
}