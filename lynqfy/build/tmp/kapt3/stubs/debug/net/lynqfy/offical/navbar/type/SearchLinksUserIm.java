package net.lynqfy.offical.navbar.type;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u001a\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0010X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0016X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lnet/lynqfy/offical/navbar/type/SearchLinksUserIm;", "Lnet/lynqfy/offical/navbar/type/SearchLinksUser;", "parent", "Landroid/view/ViewGroup;", "typedArray", "Landroid/content/res/TypedArray;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "type", "Lnet/lynqfy/offical/navbar/type/LyNavBarType;", "(Landroid/view/ViewGroup;Landroid/content/res/TypedArray;Landroid/util/AttributeSet;ILnet/lynqfy/offical/navbar/type/LyNavBarType;)V", "onButtonAction", "Lkotlin/Function0;", "", "Lnet/lynqfy/offical/navbar/ButtonCallback;", "getOnButtonAction", "()Lkotlin/jvm/functions/Function0;", "setOnButtonAction", "(Lkotlin/jvm/functions/Function0;)V", "onMenuAction", "Lnet/lynqfy/offical/navbar/MenuCallback;", "getOnMenuAction", "setOnMenuAction", "getType", "()Lnet/lynqfy/offical/navbar/type/LyNavBarType;", "setType", "(Lnet/lynqfy/offical/navbar/type/LyNavBarType;)V", "ui", "Lnet/lynqfy/offical/databinding/LyNavBarSearchLinkUserUiBinding;", "getUi", "()Lnet/lynqfy/offical/databinding/LyNavBarSearchLinkUserUiBinding;", "ui$delegate", "Lkotlin/Lazy;", "initTheme", "attrs", "initUI", "lynqfy_debug"})
public final class SearchLinksUserIm implements net.lynqfy.offical.navbar.type.SearchLinksUser {
    private final android.view.ViewGroup parent = null;
    private final android.content.res.TypedArray typedArray = null;
    private final android.util.AttributeSet attr = null;
    private final int defStyleAttr = 0;
    @org.jetbrains.annotations.NotNull()
    private net.lynqfy.offical.navbar.type.LyNavBarType type;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onButtonAction;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onMenuAction;
    private final kotlin.Lazy ui$delegate = null;
    
    public SearchLinksUserIm(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, @org.jetbrains.annotations.NotNull()
    android.content.res.TypedArray typedArray, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attr, int defStyleAttr, @org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.navbar.type.LyNavBarType type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public net.lynqfy.offical.navbar.type.LyNavBarType getType() {
        return null;
    }
    
    @java.lang.Override()
    public void setType(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.navbar.type.LyNavBarType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<kotlin.Unit> getOnButtonAction() {
        return null;
    }
    
    @java.lang.Override()
    public void setOnButtonAction(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<kotlin.Unit> getOnMenuAction() {
        return null;
    }
    
    @java.lang.Override()
    public void setOnMenuAction(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    public void initTheme(@org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
    }
    
    @java.lang.Override()
    public void initUI() {
    }
    
    private final net.lynqfy.offical.databinding.LyNavBarSearchLinkUserUiBinding getUi() {
        return null;
    }
}