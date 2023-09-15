package com.fwloopins.amanita.client.mixin.truexp;

import com.fwloopins.amanita.client.AmanitaClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Shadow @Final private MinecraftClient client;

    @ModifyVariable(method = "renderExperienceBar", at = @At("STORE"), ordinal = 0)
    private String modifyExperienceString(String experienceString) {
        if (AmanitaClient.getConfig().general.trueXP) {
            assert client.player != null;
            return experienceString + " (" + client.player.totalExperience + ")";
        }

        return experienceString;
    }
}
