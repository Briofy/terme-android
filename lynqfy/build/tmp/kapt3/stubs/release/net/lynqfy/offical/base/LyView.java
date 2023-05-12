package net.lynqfy.offical.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\"#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001e\u001a\u00020\tH\'J\b\u0010\u001f\u001a\u00020\fH&J&\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0018@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lnet/lynqfy/offical/base/LyView;", "Landroid/widget/FrameLayout;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "value", "Lnet/lynqfy/offical/base/LyView$OnClickListener;", "onClickListener", "getOnClickListener", "()Lnet/lynqfy/offical/base/LyView$OnClickListener;", "setOnClickListener", "(Lnet/lynqfy/offical/base/LyView$OnClickListener;)V", "Lnet/lynqfy/offical/base/LyView$OnLongClickListener;", "onLongClickListener", "getOnLongClickListener", "()Lnet/lynqfy/offical/base/LyView$OnLongClickListener;", "setOnLongClickListener", "(Lnet/lynqfy/offical/base/LyView$OnLongClickListener;)V", "getLayoutId", "getMainView", "init", "", "OnClickListener", "OnLongClickListener", "lynqfy_release"})
public abstract class LyView extends android.widget.FrameLayout {
    public android.view.View mView;
    @org.jetbrains.annotations.Nullable()
    private net.lynqfy.offical.base.LyView.OnClickListener onClickListener;
    @org.jetbrains.annotations.Nullable()
    private net.lynqfy.offical.base.LyView.OnLongClickListener onLongClickListener;
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getMView() {
        return null;
    }
    
    public final void setMView(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    public LyView(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext) {
        super(null);
    }
    
    @androidx.annotation.LayoutRes()
    public abstract int getLayoutId();
    
    public LyView(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr) {
        super(null);
    }
    
    public LyView(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr, int defStyleAttr) {
        super(null);
    }
    
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr, int defStyleAttr) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View getMainView();
    
    @org.jetbrains.annotations.Nullable()
    public final net.lynqfy.offical.base.LyView.OnClickListener getOnClickListener() {
        return null;
    }
    
    public final void setOnClickListener(@org.jetbrains.annotations.Nullable()
    net.lynqfy.offical.base.LyView.OnClickListener value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final net.lynqfy.offical.base.LyView.OnLongClickListener getOnLongClickListener() {
        return null;
    }
    
    public final void setOnLongClickListener(@org.jetbrains.annotations.Nullable()
    net.lynqfy.offical.base.LyView.OnLongClickListener value) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lnet/lynqfy/offical/base/LyView$OnClickListener;", "", "onButtonClick", "", "button", "Landroid/view/View;", "lynqfy_release"})
    public static abstract interface OnClickListener {
        
        public abstract void onButtonClick(@org.jetbrains.annotations.NotNull()
        android.view.View button);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lnet/lynqfy/offical/base/LyView$OnLongClickListener;", "", "onButtonLongClick", "", "button", "Landroid/view/View;", "lynqfy_release"})
    public static abstract interface OnLongClickListener {
        
        public abstract boolean onButtonLongClick(@org.jetbrains.annotations.NotNull()
        android.view.View button);
    }
}