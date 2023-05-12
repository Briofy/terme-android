package net.lynqfy.offical.datepicker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\bH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\bH\u0016J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lnet/lynqfy/offical/datepicker/GridAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "calendarData", "Lnet/lynqfy/offical/datepicker/LyCalendarData;", "shiftMonth", "", "listener", "Lnet/lynqfy/offical/datepicker/listeners/DateSelectListener;", "gridListener", "Lnet/lynqfy/offical/datepicker/listeners/GridChangeListener;", "(Landroid/content/Context;Lnet/lynqfy/offical/datepicker/LyCalendarData;ILnet/lynqfy/offical/datepicker/listeners/DateSelectListener;Lnet/lynqfy/offical/datepicker/listeners/GridChangeListener;)V", "inflater", "Landroid/view/LayoutInflater;", "monthlyDates", "Ljava/util/ArrayList;", "Ljava/util/Date;", "getCount", "getItem", "position", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "init", "", "lynqfy_debug"})
public final class GridAdapter extends android.widget.ArrayAdapter<java.lang.Object> {
    private final net.lynqfy.offical.datepicker.LyCalendarData calendarData = null;
    private final net.lynqfy.offical.datepicker.listeners.DateSelectListener listener = null;
    private final int shiftMonth = 0;
    private java.util.ArrayList<java.util.Date> monthlyDates;
    private final android.view.LayoutInflater inflater = null;
    private final net.lynqfy.offical.datepicker.listeners.GridChangeListener gridListener = null;
    
    public GridAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.datepicker.LyCalendarData calendarData, int shiftMonth, @org.jetbrains.annotations.Nullable()
    net.lynqfy.offical.datepicker.listeners.DateSelectListener listener, @org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.datepicker.listeners.GridChangeListener gridListener) {
        super(null, 0);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable()
    android.view.View convertView, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.Date getItem(int position) {
        return null;
    }
    
    private final void init() {
    }
}