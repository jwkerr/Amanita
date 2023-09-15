package com.fwloopins.amanita.client.cosmetics.particles;

import com.fwloopins.amanita.client.AmanitaClient;
import com.fwloopins.amanita.client.config.AmanitaConfig;
import com.fwloopins.amanita.client.cosmetics.particles.styles.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.GameMode;

public class ClientParticles {
    static boolean warned = false;

    public static void clientParticlesTick(MinecraftClient client) {
        AmanitaConfig.Cosmetics.Particles particlesConfig = AmanitaClient.getConfig().cosmetics.particles;

        if (particlesConfig.isEnabled && client.interactionManager != null && client.interactionManager.getCurrentGameMode() != GameMode.SPECTATOR) {
            switch (particlesConfig.particleStyle.style()) {
                case "aura" -> AuraStyle.create(client, particlesConfig);
                case "halo" -> HaloStyle.create(client, particlesConfig);
                case "orbit" -> OrbitStyle.create(client, particlesConfig);
                case "pulsating_aura" -> PulsatingAuraStyle.create(client, particlesConfig);
                case "scanning_aura" -> ScanningAuraStyle.create(client, particlesConfig);
                case "trail" -> TrailStyle.create(client, particlesConfig);
                case "twin_orbit" -> TwinOrbitStyle.create(client, particlesConfig);
                default -> {
                    TrailStyle.create(client, particlesConfig);

                    if (!warned) {
                        AmanitaClient.logError("Switch case " + particlesConfig.particleStyle.style() + " failed, defaulting to trail style");

                        warned = true;
                    }
                }
            }
        }
    }
}
