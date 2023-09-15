package com.fwloopins.amanita.client.mixin.clientbrand;

import com.fwloopins.amanita.client.AmanitaClient;
import net.minecraft.client.ClientBrandRetriever;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientBrandRetriever.class)
public class ClientBrandRetrieverMixin {
    @Inject(method = "getClientModName", at = @At("RETURN"), cancellable = true, remap = false)
    private static void modifyClientBrand(CallbackInfoReturnable<String> cir) {
        String clientBrand = AmanitaClient.getConfig().general.clientBrand;

        if (!clientBrand.isEmpty()) {
            cir.setReturnValue(clientBrand);
        }
    }
}
