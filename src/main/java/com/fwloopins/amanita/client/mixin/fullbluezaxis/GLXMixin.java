package com.fwloopins.amanita.client.mixin.fullbluezaxis;

import com.fwloopins.amanita.client.AmanitaClient;
import com.mojang.blaze3d.platform.GLX;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GLX.class)
public class GLXMixin {
    @ModifyConstant(method = "_renderCrosshair", constant = @Constant(intValue = 127))
    private static int modifyZAxisColour(int value) {
        if (AmanitaClient.getConfig().cosmetics.tweaks.fullBlueZAxis) {
            return 0;
        }

        return value;
    }
}
