package net.lynqfy.offical.checkbox;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\nH\u0016R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lnet/lynqfy/offical/checkbox/LyCheckBox;", "Lcom/google/android/material/checkbox/MaterialCheckBox;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeTextColor", "checkImg", "Lnet/lynqfy/offical/utils/ScalingDrawable;", "height", "", "isIndeterminate", "", "isInvalid", "isRequired", "origHeight", "origPadLeft", "tintColor", "getDefaultCheckBoxDrawable", "Landroid/graphics/drawable/Drawable;", "initTheme", "", "scale", "value", "setEnabled", "enabled", "setHeight", "setTextColor", "color", "lynqfy_debug"})
public final class LyCheckBox extends com.google.android.material.checkbox.MaterialCheckBox {
    private boolean isInvalid = false;
    private boolean isIndeterminate = false;
    private boolean isRequired = false;
    private int activeTextColor = android.graphics.Color.BLACK;
    private int tintColor = android.graphics.Color.BLACK;
    
    /**
     * the check image
     */
    private net.lynqfy.offical.utils.ScalingDrawable checkImg;
    
    /**
     * original height of the check-box image
     */
    private int origHeight = 0;
    
    /**
     * original padding-left
     */
    private int origPadLeft = 0;
    
    /**
     * height set by the user directly
     */
    private float height = 0.0F;
    
    public LyCheckBox(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx) {
        super(null);
    }
    
    public LyCheckBox(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attr) {
        super(null);
    }
    
    public LyCheckBox(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attr, int defStyleAttr) {
        super(null);
    }
    
    private final void initTheme(android.util.AttributeSet attr, int defStyleAttr) {
    }
    
    private final void scale(float value) {
    }
    
    /**
     * set checkbox height in pixels directly
     */
    @java.lang.Override()
    public void setHeight(int height) {
    }
    
    @java.lang.Override()
    public void setTextColor(int color) {
    }
    
    @java.lang.Override()
    public void setEnabled(boolean enabled) {
    }
    
    /**
     * get the default drawable for the check box
     */
    private final android.graphics.drawable.Drawable getDefaultCheckBoxDrawable() {
        return null;
    }
}