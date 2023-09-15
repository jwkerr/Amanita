package com.fwloopins.amanita.client.mixin.spectatorcrosshair;

import com.fwloopins.amanita.client.AmanitaClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Inject(method = "shouldRenderSpectatorCrosshair", at = @At("RETURN"), cancellable = true)
    private void renderSpectatorCrosshair(HitResult hitResult, CallbackInfoReturnable<Boolean> cir) {
        if (AmanitaClient.getConfig().general.spectatorCrosshair) {
            cir.setReturnValue(true);
        }
    }
}
