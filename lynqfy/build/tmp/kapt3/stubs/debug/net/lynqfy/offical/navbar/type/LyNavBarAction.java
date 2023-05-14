package net.lynqfy.offical.navbar.type;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R&\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u000bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u0018\u0010\u000e\u001a\u00020\u000fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lnet/lynqfy/offical/navbar/type/LyNavBarAction;", "", "onButtonAction", "Lkotlin/Function0;", "", "Lnet/lynqfy/offical/navbar/ButtonCallback;", "getOnButtonAction", "()Lkotlin/jvm/functions/Function0;", "setOnButtonAction", "(Lkotlin/jvm/functions/Function0;)V", "onMenuAction", "Lnet/lynqfy/offical/navbar/MenuCallback;", "getOnMenuAction", "setOnMenuAction", "type", "Lnet/lynqfy/offical/navbar/type/LyNavBarType;", "getType", "()Lnet/lynqfy/offical/navbar/type/LyNavBarType;", "setType", "(Lnet/lynqfy/offical/navbar/type/LyNavBarType;)V", "lynqfy_debug"})
public abstract interface LyNavBarAction {
    
    @org.jetbrains.annotations.Nullable()
    public abstract kotlin.jvm.functions.Function0<kotlin.Unit> getOnButtonAction();
    
    public abstract void setOnButtonAction(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract kotlin.jvm.functions.Function0<kotlin.Unit> getOnMenuAction();
    
    public abstract void setOnMenuAction(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract net.lynqfy.offical.navbar.type.LyNavBarType getType();
    
    public abstract void setType(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.navbar.type.LyNavBarType p0);
}