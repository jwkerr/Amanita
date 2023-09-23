package com.fwloopins.amanita.client.mixin.alterstars;

import com.fwloopins.amanita.client.AmanitaClient;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @ModifyConstant(method = "renderStars(Lnet/minecraft/client/render/BufferBuilder;)Lnet/minecraft/client/render/BufferBuilder$BuiltBuffer;", constant = @Constant(longValue = 10842L))
    private long alterStarSeed(long seed) {
        return AmanitaClient.getConfig().cosmetics.alterStars.seed;
    }

    @ModifyConstant(method = "renderStars(Lnet/minecraft/client/render/BufferBuilder;)Lnet/minecraft/client/render/BufferBuilder$BuiltBuffer;", constant = @Constant(intValue = 1500))
    private int modifyMaxStars(int count) {
        return AmanitaClient.getConfig().cosmetics.alterStars.maxStars;
    }
}
