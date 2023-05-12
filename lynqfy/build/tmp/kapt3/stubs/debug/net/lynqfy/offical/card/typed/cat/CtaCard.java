package net.lynqfy.offical.card.typed.cat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lnet/lynqfy/offical/card/typed/cat/CtaCard;", "Lnet/lynqfy/offical/card/LyCardAction;", "setCatAction", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isGoogle", "setHeaderInfo", "header", "Lnet/lynqfy/offical/model/Header;", "lynqfy_debug"})
public abstract interface CtaCard extends net.lynqfy.offical.card.LyCardAction {
    
    public abstract void setHeaderInfo(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.model.Header header);
    
    public abstract void setCatAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
        
        @java.lang.Override()
        public static void onBadgeClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.cat.CtaCard $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public static void onButtonClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.cat.CtaCard $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public static void onOnItemClickListener(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.cat.CtaCard $this, @org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.callbacks.OnItemClickListener listener) {
        }
    }
}