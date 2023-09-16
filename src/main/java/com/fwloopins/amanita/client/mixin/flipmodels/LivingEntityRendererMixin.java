package com.fwloopins.amanita.client.mixin.flipmodels;

import com.fwloopins.amanita.client.AmanitaClient;
import com.fwloopins.amanita.client.config.AmanitaConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
    @Unique private static MinecraftClient client = MinecraftClient.getInstance();
    @Unique private static AmanitaConfig config = AmanitaClient.getConfig();

    @Inject(method = "shouldFlipUpsideDown", at = @At("RETURN"),cancellable = true)
    private static void shouldFlipUpsideDown(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        assert client.player != null;

        String clientName = client.player.getName().getString();
        String entityName = entity.getName().getString();
        if (config.cosmetics.flipModels.flipSelf) {
            if (entity instanceof PlayerEntity && clientName.equals(entityName)) {
                cir.setReturnValue(true);
            }
        }

        if (config.cosmetics.flipModels.flipOthers && entity instanceof PlayerEntity && !clientName.equals(entityName)) {
            cir.setReturnValue(true);
        }

        if (config.cosmetics.flipModels.flipMobs && !(entity instanceof PlayerEntity)) {
            cir.setReturnValue(true);
        }
    }
}
