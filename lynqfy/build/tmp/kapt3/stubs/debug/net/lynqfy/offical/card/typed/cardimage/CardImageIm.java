package net.lynqfy.offical.card.typed.cardimage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lnet/lynqfy/offical/card/typed/cardimage/CardImageIm;", "Lnet/lynqfy/offical/card/typed/cardimage/CardImage;", "parent", "Landroid/view/ViewGroup;", "typedArray", "Landroid/content/res/TypedArray;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/view/ViewGroup;Landroid/content/res/TypedArray;Landroid/util/AttributeSet;I)V", "ui", "Lnet/lynqfy/offical/databinding/LyCardImageUiBinding;", "getUi", "()Lnet/lynqfy/offical/databinding/LyCardImageUiBinding;", "ui$delegate", "Lkotlin/Lazy;", "disableButton", "", "initCardImageTheme", "attrs", "onButtonClicked", "callback", "Lkotlin/Function0;", "setHeaderInfo", "header", "Lnet/lynqfy/offical/model/Header;", "setImage", "url", "", "lynqfy_debug"})
public final class CardImageIm implements net.lynqfy.offical.card.typed.cardimage.CardImage {
    private final android.view.ViewGroup parent = null;
    private final android.content.res.TypedArray typedArray = null;
    private final kotlin.Lazy ui$delegate = null;
    
    public CardImageIm(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, @org.jetbrains.annotations.NotNull()
    android.content.res.TypedArray typedArray, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attr, int defStyleAttr) {
        super();
    }
    
    @java.lang.Override()
    public void setHeaderInfo(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.model.Header header) {
    }
    
    @java.lang.Override()
    public void onButtonClicked(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    @java.lang.Override()
    public void setImage(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    private final void initCardImageTheme(android.util.AttributeSet attrs, int defStyleAttr) {
    }
    
    public final void disableButton() {
    }
    
    private final net.lynqfy.offical.databinding.LyCardImageUiBinding getUi() {
        return null;
    }
    
    @java.lang.Override()
    public void onBadgeClicked(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    @java.lang.Override()
    public void onOnItemClickListener(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.callbacks.OnItemClickListener listener) {
    }
}