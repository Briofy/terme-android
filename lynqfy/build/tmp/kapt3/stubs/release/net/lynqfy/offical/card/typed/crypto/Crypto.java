package net.lynqfy.offical.card.typed.crypto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lnet/lynqfy/offical/card/typed/crypto/Crypto;", "Lnet/lynqfy/offical/card/LyCardAction;", "addWallet", "", "item", "Lnet/lynqfy/offical/model/Item;", "addWallets", "wallets", "", "setHeaderInfo", "header", "Lnet/lynqfy/offical/model/Header;", "setHelperMessage", "helper", "", "lynqfy_release"})
public abstract interface Crypto extends net.lynqfy.offical.card.LyCardAction {
    
    public abstract void setHeaderInfo(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.model.Header header);
    
    public abstract void setHelperMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String helper);
    
    public abstract void addWallet(@org.jetbrains.annotations.NotNull()
    net.lynqfy.offical.model.Item item);
    
    public abstract void addWallets(@org.jetbrains.annotations.NotNull()
    java.util.List<net.lynqfy.offical.model.Item> wallets);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
        
        @java.lang.Override()
        public static void onBadgeClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.crypto.Crypto $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public static void onButtonClicked(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.crypto.Crypto $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public static void onOnItemClickListener(@org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.card.typed.crypto.Crypto $this, @org.jetbrains.annotations.NotNull()
        net.lynqfy.offical.callbacks.OnItemClickListener listener) {
        }
    }
}