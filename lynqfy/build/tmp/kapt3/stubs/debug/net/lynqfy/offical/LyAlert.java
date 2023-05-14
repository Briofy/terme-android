package net.lynqfy.offical;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lnet/lynqfy/offical/LyAlert;", "Lnet/lynqfy/offical/base/BaseAlert;", "Lnet/lynqfy/offical/databinding/LyLayoutBinding;", "()V", "buttonText", "", "cancelable", "", "iconRes", "", "isIconEnable", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "message", "onClickListener", "Lnet/lynqfy/offical/AlertClickListener;", "title", "type", "Lnet/lynqfy/offical/AlertType;", "initDialog", "", "onClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Builder", "Companion", "lynqfy_debug"})
public final class LyAlert extends net.lynqfy.offical.base.BaseAlert<net.lynqfy.offical.databinding.LyLayoutBinding> {
    private java.lang.String title = "Title";
    private java.lang.String message = "Message";
    private int iconRes;
    private boolean cancelable = true;
    private net.lynqfy.offical.AlertType type = net.lynqfy.offical.AlertType.SUCCESS;
    private java.lang.String buttonText = "OK";
    private boolean isIconEnable = true;
    public android.content.Context mContext;
    private net.lynqfy.offical.AlertClickListener onClickListener;
    @org.jetbrains.annotations.NotNull()
    public static final net.lynqfy.offical.LyAlert.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DIALOG_TITLE = "DIALOG_TITLE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DIALOG_DESC = "DIALOG_DESC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SECOND_BUTTON = "SECOND_BUTTON";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TITLE_CONFIRM_BUTTON = "TITLE_CONFIRM_BUTTON";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TITLE_SECOND_BUTTON = "TITLE_SECOND_BUTTON";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CANCELABLE = "CANCELABLE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_RES_ID = "IMAGE_RES_ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DIALOG_TYPE = "DIALOG_TYPE";
    
    private LyAlert() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initDialog() {
    }
    
    private final void onClick() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lnet/lynqfy/offical/LyAlert$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buttonText", "", "cancelable", "", "getContext", "()Landroid/content/Context;", "iconRes", "", "isIconEnable", "message", "onClickListener", "Lnet/lynqfy/offical/AlertClickListener;", "title", "type", "Lnet/lynqfy/offical/AlertType;", "build", "Lnet/lynqfy/offical/LyAlert;", "enable", "setAlertClickListener", "setButtonText", "setCancelable", "setIconRes", "setMessage", "setTitle", "setType", "lynqfy_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        private java.lang.String title = "Title";
        private java.lang.String message = "Message";
        private int iconRes;
        private boolean cancelable = true;
        private net.lynqfy.offical.AlertType type = net.lynqfy.offical.AlertType.SUCCESS;
        private java.lang.String buttonText = "OK";
        private net.lynqfy.offical.AlertClickListener onClickListener;
        private boolean isIconEnable = true;
        
        public Builder(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert.Builder isIconEnable(boolean enable) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert.Builder setAlertClickListener(@org.jetbrains.annotations.Nullable()
        net.lynqfy.offical.AlertClickListener onClickListener) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert.Builder setButtonText(@org.jetbrains.annotations.NotNull()
        java.lang.String buttonText) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert.Builder setType(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.AlertType type) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert.Builder setTitle(@org.jetbrains.annotations.NotNull()
        java.lang.String title) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert.Builder setMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert.Builder setIconRes(int iconRes) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert.Builder setCancelable(boolean cancelable) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final net.lynqfy.offical.LyAlert build() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lnet/lynqfy/offical/LyAlert$Companion;", "", "()V", "CANCELABLE", "", "DIALOG_DESC", "DIALOG_TITLE", "DIALOG_TYPE", "IMAGE_RES_ID", "SECOND_BUTTON", "TITLE_CONFIRM_BUTTON", "TITLE_SECOND_BUTTON", "lynqfy_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}