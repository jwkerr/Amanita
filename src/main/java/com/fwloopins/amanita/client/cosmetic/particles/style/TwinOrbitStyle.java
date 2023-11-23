package com.fwloopins.amanita.client.cosmetic.particles.style;

import com.fwloopins.amanita.client.config.AmanitaConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class TwinOrbitStyle {
    private static int iteration = 0;
    private static final int NUM_ITERATIONS = 180;

    public static void create(MinecraftClient client, AmanitaConfig.Cosmetics.Particles particlesConfig) {
        if (client.world != null && client.player != null) {
            if (!client.isPaused()) {
                Vec3d pos = client.player.getPos();

                double angle = (2.0 * Math.PI * iteration) / NUM_ITERATIONS;

                double x = pos.x + 0.45 * Math.cos(angle);
                double y = pos.y + 2.10;
                double z = pos.z + 0.45 * Math.sin(angle);

                client.world.addParticle(particlesConfig.particleEffect.particle(), x, y, z, 0, 0, 0);

                double oppositeAngle = angle + Math.PI;

                double oppositeX = pos.x + 0.45 * Math.cos(oppositeAngle);
                double oppositeY = pos.y + 2.05;
                double oppositeZ = pos.z + 0.45 * Math.sin(oppositeAngle);

                client.world.addParticle(particlesConfig.particleEffect.particle(), oppositeX, oppositeY, oppositeZ, 0, 0, 0);

                iteration++;

                if (iteration > NUM_ITERATIONS)
                    iteration = 0;
            }
        }
    }
}
