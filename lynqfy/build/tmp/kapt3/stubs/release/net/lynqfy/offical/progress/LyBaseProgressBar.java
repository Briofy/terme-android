package net.lynqfy.offical.progress;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lnet/lynqfy/offical/progress/LyBaseProgressBar;", "Landroid/widget/ProgressBar;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lnet/lynqfy/offical/progress/LyBaseProgressBar$OnProgressBarChangeListener;", "setOnProgressBarChangeListener", "", "l", "setProgress", "progress", "OnProgressBarChangeListener", "lynqfy_release"})
public final class LyBaseProgressBar extends android.widget.ProgressBar {
    private net.lynqfy.offical.progress.LyBaseProgressBar.OnProgressBarChangeListener listener;
    
    public LyBaseProgressBar(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx) {
        super(null);
    }
    
    public LyBaseProgressBar(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr) {
        super(null);
    }
    
    public LyBaseProgressBar(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attr, int defStyleAttr) {
        super(null);
    }
    
    @java.lang.Override()
    public void setProgress(int progress) {
    }
    
    public final void setOnProgressBarChangeListener(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.progress.LyBaseProgressBar.OnProgressBarChangeListener l) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lnet/lynqfy/offical/progress/LyBaseProgressBar$OnProgressBarChangeListener;", "", "onProgressChanged", "", "progress", "", "lynqfy_release"})
    public static abstract interface OnProgressBarChangeListener {
        
        public abstract void onProgressChanged(int progress);
    }
}