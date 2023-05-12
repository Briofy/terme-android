package net.lynqfy.offical.card.typed.ecommerce;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lnet/lynqfy/offical/card/typed/ecommerce/Ecommerce;", "Lnet/lynqfy/offical/card/LyCardAction;", "setAddCartAction", "", "action", "Lkotlin/Function0;", "setEcommerceInfo", "info", "Lnet/lynqfy/offical/model/EcommerceInfo;", "lynqfy_debug"})
public abstract interface Ecommerce extends net.lynqfy.offical.card.LyCardAction {
    
    public abstract void setEcommerceInfo(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.model.EcommerceInfo info);
    
    public abstract void setAddCartAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> action);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
        
        @java.lang.Override()
        public static void onBadgeClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.ecommerce.Ecommerce $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public static void onButtonClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.ecommerce.Ecommerce $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public static void onOnItemClickListener(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.ecommerce.Ecommerce $this, @org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.callbacks.OnItemClickListener listener) {
        }
    }
}