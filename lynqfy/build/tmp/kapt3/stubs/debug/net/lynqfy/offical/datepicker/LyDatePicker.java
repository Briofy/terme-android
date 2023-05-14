package net.lynqfy.offical.datepicker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012h\b\u0002\u0010\u0004\u001ab\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0016J,\u0010\u001a\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016Rn\u0010\u0004\u001ab\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lnet/lynqfy/offical/datepicker/LyDatePicker;", "Lnet/lynqfy/offical/datepicker/LyCalendarDialog$Callback;", "ctx", "Landroidx/appcompat/app/AppCompatActivity;", "callback", "Lkotlin/Function4;", "Ljava/util/Calendar;", "Lkotlin/ParameterName;", "name", "firstDate", "secondDate", "", "hours", "minutes", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function4;)V", "fmTag", "", "getCalendarDialog", "Lnet/lynqfy/offical/datepicker/LyCalendarDialog;", "d", "Ljava/util/Date;", "isSingle", "", "hideCalender", "onCancelled", "onDataSelected", "showCalender", "showYearList", "date", "lynqfy_debug"})
public final class LyDatePicker implements net.lynqfy.offical.datepicker.LyCalendarDialog.Callback {
    private final androidx.appcompat.app.AppCompatActivity ctx = null;
    private final kotlin.jvm.functions.Function4<java.util.Calendar, java.util.Calendar, java.lang.Integer, java.lang.Integer, kotlin.Unit> callback = null;
    private final java.lang.String fmTag = "TAG_LY_CALENDAR";
    
    public LyDatePicker(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity ctx, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function4<? super java.util.Calendar, ? super java.util.Calendar, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> callback) {
        super();
    }
    
    private final net.lynqfy.offical.datepicker.LyCalendarDialog getCalendarDialog(java.util.Date d, boolean isSingle) {
        return null;
    }
    
    private final void hideCalender() {
    }
    
    public final void showCalender(boolean isSingle) {
    }
    
    @java.lang.Override()
    public void showYearList(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
    }
    
    @java.lang.Override()
    public void onCancelled() {
    }
    
    @java.lang.Override()
    public void onDataSelected(@org.jetbrains.annotations.Nullable()
    java.util.Calendar firstDate, @org.jetbrains.annotations.Nullable()
    java.util.Calendar secondDate, int hours, int minutes) {
    }
}