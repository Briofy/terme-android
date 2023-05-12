package net.lynqfy.offical.card;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lnet/lynqfy/offical/card/LyCardAction;", "", "onBadgeClicked", "", "callback", "Lkotlin/Function0;", "onButtonClicked", "onOnItemClickListener", "listener", "Lnet/lynqfy/offical/callbacks/OnItemClickListener;", "lynqfy_release"})
public abstract interface LyCardAction {
    
    public abstract void onButtonClicked(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback);
    
    public abstract void onBadgeClicked(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback);
    
    public abstract void onOnItemClickListener(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.callbacks.OnItemClickListener listener);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
        
        public static void onButtonClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.LyCardAction $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        public static void onBadgeClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.LyCardAction $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        public static void onOnItemClickListener(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.LyCardAction $this, @org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.callbacks.OnItemClickListener listener) {
        }
    }
}