package com.fwloopins.amanita.client.cosmetics.particles.styles;

import com.fwloopins.amanita.client.config.AmanitaConfig;
import com.fwloopins.amanita.client.cosmetics.particles.ParticlesUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class PulsatingAuraStyle {
    private static double radius = 0;
    private static final double DIFFERENCE = 0.05;
    private static final double MIN_RADIUS = 0;
    private static final double MAX_RADIUS = 2;
    private static boolean expanding = true;

    public static void create(MinecraftClient client, AmanitaConfig.Cosmetics.Particles particlesConfig) {
        if (client.world != null && client.player != null) {
            if (!client.isPaused()) {
                Vec3d pos = client.player.getPos();

                List<Vec3d> coordinates = ParticlesUtil.createCoordinateCircleFromVec3d(pos, 60, radius, 0.1);

                for (Vec3d coordinate : coordinates) {
                    client.world.addParticle(particlesConfig.particleEffect.particle(), coordinate.x, coordinate.y, coordinate.z, 0, 0, 0);
                }

                if (expanding) {
                    if (radius < MAX_RADIUS) {
                        radius += DIFFERENCE;
                    } else {
                        expanding = false;
                        radius -= DIFFERENCE;
                    }
                } else {
                    if (radius > MIN_RADIUS) {
                        radius -= DIFFERENCE;
                    } else {
                        expanding = true;
                        radius += DIFFERENCE;
                    }
                }
            }
        }
    }
}
