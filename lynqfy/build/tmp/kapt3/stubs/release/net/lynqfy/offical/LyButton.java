package net.lynqfy.offical;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\'()B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\"\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020#H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lnet/lynqfy/offical/LyButton;", "Lnet/lynqfy/offical/base/LyView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundType", "Lnet/lynqfy/offical/LyButton$ButtonBackgroundType;", "bgColor", "button", "Landroidx/appcompat/widget/AppCompatButton;", "getButton", "()Landroidx/appcompat/widget/AppCompatButton;", "setButton", "(Landroidx/appcompat/widget/AppCompatButton;)V", "buttonEnable", "", "buttonShape", "Lnet/lynqfy/offical/LyButton$ButtonShape;", "buttonText", "", "buttonTextColorRes", "buttonType", "Lnet/lynqfy/offical/LyButton$ButtonType;", "icon", "leftIcon", "rightIcon", "getLayoutId", "getMainView", "init", "", "mContext", "defStyleAttr", "setValues", "ButtonBackgroundType", "ButtonShape", "ButtonType", "lynqfy_release"})
public final class LyButton extends net.lynqfy.offical.base.LyView {
    private java.lang.String buttonText = "Ly Button";
    private boolean buttonEnable = true;
    private int buttonTextColorRes;
    private net.lynqfy.offical.LyButton.ButtonBackgroundType backgroundType = net.lynqfy.offical.LyButton.ButtonBackgroundType.FILLED;
    private net.lynqfy.offical.LyButton.ButtonType buttonType = net.lynqfy.offical.LyButton.ButtonType.TEXT;
    private net.lynqfy.offical.LyButton.ButtonShape buttonShape = net.lynqfy.offical.LyButton.ButtonShape.Rect;
    private int bgColor;
    private int icon;
    private int leftIcon = -1;
    private int rightIcon = -1;
    public androidx.appcompat.widget.AppCompatButton button;
    
    public LyButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public LyButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr) {
        super(null);
    }
    
    public LyButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr, int style) {
        super(null);
    }
    
    @java.lang.Override()
    public int getLayoutId() {
        return 0;
    }
    
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attr, int defStyleAttr) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.appcompat.widget.AppCompatButton getMainView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.AppCompatButton getButton() {
        return null;
    }
    
    public final void setButton(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatButton p0) {
    }
    
    private final void setValues() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lnet/lynqfy/offical/LyButton$ButtonType;", "", "(Ljava/lang/String;I)V", "TEXT", "IMAGE", "lynqfy_release"})
    public static enum ButtonType {
        /*public static final*/ TEXT /* = new TEXT() */,
        /*public static final*/ IMAGE /* = new IMAGE() */;
        
        ButtonType() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lnet/lynqfy/offical/LyButton$ButtonShape;", "", "(Ljava/lang/String;I)V", "Circle", "Rect", "lynqfy_release"})
    public static enum ButtonShape {
        /*public static final*/ Circle /* = new Circle() */,
        /*public static final*/ Rect /* = new Rect() */;
        
        ButtonShape() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lnet/lynqfy/offical/LyButton$ButtonBackgroundType;", "", "(Ljava/lang/String;I)V", "FILLED", "BORDERED", "lynqfy_release"})
    public static enum ButtonBackgroundType {
        /*public static final*/ FILLED /* = new FILLED() */,
        /*public static final*/ BORDERED /* = new BORDERED() */;
        
        ButtonBackgroundType() {
        }
    }
}