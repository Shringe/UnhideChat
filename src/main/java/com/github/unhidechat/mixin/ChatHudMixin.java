package com.github.unhidechat.mixin;

import com.github.unhidechat.ChatHandler;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.network.message.SentMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatHud.class)
public class ChatHudMixin {
    @Inject(method = "isChatHidden", at = @At("HEAD"), cancellable = true)
    void unhidechat$isChatHidden(CallbackInfoReturnable<Boolean> callbackInfo) {
        if (ChatHandler.isHidden()) {
            callbackInfo.setReturnValue(true);
        }
    }

    @Inject(method = "isChatFocused", at = @At("HEAD"), cancellable = true)
    void unhidechat$isChatFocused(CallbackInfoReturnable<Boolean> callbackInfo) {
        if (ChatHandler.isExpanded()) {
            callbackInfo.setReturnValue(true);
        }
    }
}
