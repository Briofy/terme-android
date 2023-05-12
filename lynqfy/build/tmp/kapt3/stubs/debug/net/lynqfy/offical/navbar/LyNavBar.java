package net.lynqfy.offical.navbar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00100\u0014j\u0002`\u0015J\u0018\u0010\u0016\u001a\u00020\u00102\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00100\u0014j\u0002`\u0017R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lnet/lynqfy/offical/navbar/LyNavBar;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLyNavBarAction", "Lnet/lynqfy/offical/navbar/type/LyNavBarAction;", "mLyNavBarUiType", "initNavBarTheme", "", "attrs", "onButtonAction", "callback", "Lkotlin/Function0;", "Lnet/lynqfy/offical/navbar/ButtonCallback;", "onMenuAction", "Lnet/lynqfy/offical/navbar/MenuCallback;", "lynqfy_debug"})
public final class LyNavBar extends androidx.appcompat.widget.LinearLayoutCompat {
    private int mLyNavBarUiType = 1;
    private net.lynqfy.offical.navbar.type.LyNavBarAction mLyNavBarAction;
    
    public LyNavBar(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx) {
        super(null);
    }
    
    public LyNavBar(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr) {
        super(null);
    }
    
    public LyNavBar(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attr, int defStyleAttr) {
        super(null);
    }
    
    public final void onButtonAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void onMenuAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    private final void initNavBarTheme(android.util.AttributeSet attrs, int defStyleAttr) {
    }
}