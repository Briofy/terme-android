package net.lynqfy.offical.card.typed.cardlink;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lnet/lynqfy/offical/card/typed/cardlink/CardLink;", "Lnet/lynqfy/offical/card/LyCardAction;", "setExternalLinkInfo", "", "title", "", "callback", "Lkotlin/Function0;", "setHeaderInfo", "header", "Lnet/lynqfy/offical/model/Header;", "lynqfy_release"})
public abstract interface CardLink extends net.lynqfy.offical.card.LyCardAction {
    
    public abstract void setHeaderInfo(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.model.Header header);
    
    public abstract void setExternalLinkInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
        
        @java.lang.Override()
        public static void onBadgeClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.cardlink.CardLink $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public static void onButtonClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.cardlink.CardLink $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public static void onOnItemClickListener(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.cardlink.CardLink $this, @org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.callbacks.OnItemClickListener listener) {
        }
    }
}