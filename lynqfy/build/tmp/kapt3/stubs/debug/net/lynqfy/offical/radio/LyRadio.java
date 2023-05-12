package net.lynqfy.offical.radio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2 = {"Lnet/lynqfy/offical/radio/LyRadio;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radioBtn", "Lcom/google/android/material/radiobutton/MaterialRadioButton;", "ui", "Lnet/lynqfy/offical/databinding/LyRadioUiBinding;", "getUi", "()Lnet/lynqfy/offical/databinding/LyRadioUiBinding;", "ui$delegate", "Lkotlin/Lazy;", "getHelper", "", "initTheme", "", "attrs", "isChecked", "", "setChecked", "v", "setOnCheckedChangeListener", "l", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "lynqfy_debug"})
public final class LyRadio extends android.widget.LinearLayout {
    private com.google.android.material.radiobutton.MaterialRadioButton radioBtn;
    private final kotlin.Lazy ui$delegate = null;
    
    public LyRadio(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx) {
        super(null);
    }
    
    public LyRadio(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr) {
        super(null);
    }
    
    public LyRadio(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attr, int defStyleAttr) {
        super(null);
    }
    
    public final void setOnCheckedChangeListener(@org.jetbrains.annotations.NotNull()
    android.widget.CompoundButton.OnCheckedChangeListener l) {
    }
    
    private final void initTheme(android.util.AttributeSet attrs, int defStyleAttr) {
    }
    
    public final boolean isChecked() {
        return false;
    }
    
    public final void setChecked(boolean v) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.CharSequence getHelper() {
        return null;
    }
    
    private final net.lynqfy.offical.databinding.LyRadioUiBinding getUi() {
        return null;
    }
}