package net.lynqfy.offical.datepicker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001b\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lnet/lynqfy/offical/datepicker/LyCalendarView;", "Landroid/widget/FrameLayout;", "Lnet/lynqfy/offical/datepicker/listeners/DateSelectListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lnet/lynqfy/offical/datepicker/LyCalendarDialog$Callback;", "completeListener", "Lnet/lynqfy/offical/datepicker/listeners/DialogCompleteListener;", "slyCalendarData", "Lnet/lynqfy/offical/datepicker/LyCalendarData;", "dateLongSelect", "", "selectedDate", "Ljava/util/Date;", "dateSelect", "init", "defStyle", "paintCalendar", "setCallback", "setCompleteListener", "setSlyCalendarData", "showCalendar", "lynqfy_debug"})
public final class LyCalendarView extends android.widget.FrameLayout implements net.lynqfy.offical.datepicker.listeners.DateSelectListener {
    private net.lynqfy.offical.datepicker.LyCalendarData slyCalendarData;
    private net.lynqfy.offical.datepicker.LyCalendarDialog.Callback callback;
    private net.lynqfy.offical.datepicker.listeners.DialogCompleteListener completeListener;
    private android.util.AttributeSet attrs;
    private int defStyleAttr = 0;
    
    public LyCalendarView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public LyCalendarView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public LyCalendarView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public final void setCallback(@org.jetbrains.annotations.Nullable()
    net.lynqfy.offical.datepicker.LyCalendarDialog.Callback callback) {
    }
    
    public final void setCompleteListener(@org.jetbrains.annotations.Nullable()
    net.lynqfy.offical.datepicker.listeners.DialogCompleteListener completeListener) {
    }
    
    public final void setSlyCalendarData(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.datepicker.LyCalendarData slyCalendarData) {
    }
    
    private final void init(android.util.AttributeSet attrs, int defStyle) {
    }
    
    private final void showCalendar() {
    }
    
    @java.lang.Override()
    public void dateSelect(@org.jetbrains.annotations.Nullable()
    java.util.Date selectedDate) {
    }
    
    @java.lang.Override()
    public void dateLongSelect(@org.jetbrains.annotations.Nullable()
    java.util.Date selectedDate) {
    }
    
    private final void paintCalendar() {
    }
}