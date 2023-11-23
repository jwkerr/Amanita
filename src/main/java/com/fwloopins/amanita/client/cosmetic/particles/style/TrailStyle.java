package com.fwloopins.amanita.client.cosmetic.particles.style;

import com.fwloopins.amanita.client.config.AmanitaConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class TrailStyle {
    private static final Random RANDOM = new Random();

    public static void create(MinecraftClient client, AmanitaConfig.Cosmetics.Particles particlesConfig) {
        if (client.world != null && client.player != null) {
            if (!client.isPaused() && client.player.getVelocity().lengthSquared() > 0.01) {
                Vec3d pos = client.player.getPos();
                double yaw = Math.toRadians(client.player.getYaw());

                double x = (pos.x + 0.5 * Math.sin(yaw)) + RANDOM.nextDouble(-0.25, 0.25);
                double y = pos.y + 0.1;
                double z = (pos.z - 0.5 * Math.cos(yaw)) + RANDOM.nextDouble(-0.25, 0.25);

                client.world.addParticle(particlesConfig.particleEffect.particle(), x, y, z, 0, 0, 0);
            }
        }
    }
}
