package net.lynqfy.offical.datepicker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0015\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u0015\u0010!\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010\u0019J\u0015\u0010#\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010\u0019J\u0015\u0010%\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010\u0019J\u0015\u0010\'\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010\u0019J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020 J\u0010\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u001dJ\u0015\u0010-\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010\u0019J\u0015\u0010/\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lnet/lynqfy/offical/datepicker/LyCalendarDialog;", "Landroidx/fragment/app/DialogFragment;", "Lnet/lynqfy/offical/datepicker/listeners/DialogCompleteListener;", "()V", "calendarView", "Lnet/lynqfy/offical/datepicker/LyCalendarView;", "callback", "Lnet/lynqfy/offical/datepicker/LyCalendarDialog$Callback;", "slyCalendarData", "Lnet/lynqfy/offical/datepicker/LyCalendarData;", "complete", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "setBackgroundColor", "backgroundColor", "", "(Ljava/lang/Integer;)Lnet/lynqfy/offical/datepicker/LyCalendarDialog;", "setCallback", "setEndDate", "endDate", "Ljava/util/Date;", "setFirstMonday", "firsMonday", "", "setHeaderColor", "headerColor", "setHeaderTextColor", "headerTextColor", "setSelectedColor", "selectedColor", "setSelectedTextColor", "selectedTextColor", "setSingle", "single", "setStartDate", "startDate", "setTextColor", "textColor", "setTimeTheme", "themeResource", "Callback", "lynqfy_debug"})
public final class LyCalendarDialog extends androidx.fragment.app.DialogFragment implements net.lynqfy.offical.datepicker.listeners.DialogCompleteListener {
    private final net.lynqfy.offical.datepicker.LyCalendarData slyCalendarData = null;
    private net.lynqfy.offical.datepicker.LyCalendarDialog.Callback callback;
    private net.lynqfy.offical.datepicker.LyCalendarView calendarView;
    
    public LyCalendarDialog() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setStartDate(@org.jetbrains.annotations.Nullable()
    java.util.Date startDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setEndDate(@org.jetbrains.annotations.Nullable()
    java.util.Date endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setSingle(boolean single) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setFirstMonday(boolean firsMonday) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setCallback(@org.jetbrains.annotations.Nullable()
    net.lynqfy.offical.datepicker.LyCalendarDialog.Callback callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setTimeTheme(@org.jetbrains.annotations.Nullable()
    java.lang.Integer themeResource) {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void complete() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setBackgroundColor(@org.jetbrains.annotations.Nullable()
    java.lang.Integer backgroundColor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setHeaderColor(@org.jetbrains.annotations.Nullable()
    java.lang.Integer headerColor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setHeaderTextColor(@org.jetbrains.annotations.Nullable()
    java.lang.Integer headerTextColor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setTextColor(@org.jetbrains.annotations.Nullable()
    java.lang.Integer textColor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setSelectedColor(@org.jetbrains.annotations.Nullable()
    java.lang.Integer selectedColor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.lynqfy.offical.datepicker.LyCalendarDialog setSelectedTextColor(@org.jetbrains.annotations.Nullable()
    java.lang.Integer selectedTextColor) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J,\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lnet/lynqfy/offical/datepicker/LyCalendarDialog$Callback;", "", "onCancelled", "", "onDataSelected", "firstDate", "Ljava/util/Calendar;", "secondDate", "hours", "", "minutes", "showYearList", "date", "Ljava/util/Date;", "lynqfy_debug"})
    public static abstract interface Callback {
        
        public abstract void showYearList(@org.jetbrains.annotations.NotNull()
        java.util.Date date);
        
        public abstract void onCancelled();
        
        public abstract void onDataSelected(@org.jetbrains.annotations.Nullable()
        java.util.Calendar firstDate, @org.jetbrains.annotations.Nullable()
        java.util.Calendar secondDate, int hours, int minutes);
    }
}