package net.lynqfy.offical.utils;

import java.lang.System;

/**
 * The drawable that scales the contained drawable
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lnet/lynqfy/offical/utils/ScalingDrawable;", "Landroid/graphics/drawable/LayerDrawable;", "d", "Landroid/graphics/drawable/Drawable;", "scale", "", "(Landroid/graphics/drawable/Drawable;F)V", "scaleX", "scaleY", "(Landroid/graphics/drawable/Drawable;FF)V", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "getIntrinsicHeight", "", "getIntrinsicWidth", "setScale", "", "lynqfy_debug"})
public final class ScalingDrawable extends android.graphics.drawable.LayerDrawable {
    
    /**
     * X scale
     */
    private float scaleX = 0.0F;
    
    /**
     * Y scale
     */
    private float scaleY = 0.0F;
    
    public ScalingDrawable(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable d, float scaleX, float scaleY) {
        super(null);
    }
    
    public final float getScaleX() {
        return 0.0F;
    }
    
    public final void setScaleX(float p0) {
    }
    
    public final float getScaleY() {
        return 0.0F;
    }
    
    public final void setScaleY(float p0) {
    }
    
    public ScalingDrawable(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable d, float scale) {
        super(null);
    }
    
    /**
     * set the scales
     */
    public final void setScale(float scaleX, float scaleY) {
    }
    
    /**
     * set the scale -- proportional scaling
     */
    public final void setScale(float scale) {
    }
    
    @java.lang.Override()
    public int getIntrinsicWidth() {
        return 0;
    }
    
    @java.lang.Override()
    public int getIntrinsicHeight() {
        return 0;
    }
}