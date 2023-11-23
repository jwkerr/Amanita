package com.fwloopins.amanita.client.cosmetic.particles.style;

import com.fwloopins.amanita.client.config.AmanitaConfig;
import com.fwloopins.amanita.client.cosmetic.particles.ParticlesUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class HaloStyle {

    public static void create(MinecraftClient client, AmanitaConfig.Cosmetics.Particles particlesConfig) {
        if (client.world != null && client.player != null) {
            if (!client.isPaused()) {
                Vec3d pos = client.player.getPos();

                List<Vec3d> coordinates = ParticlesUtil.createCoordinateCircleFromVec3d(pos, 30, 0.4, 2.10);

                for (Vec3d coordinate : coordinates) {
                    client.world.addParticle(particlesConfig.particleEffect.particle(), coordinate.x, coordinate.y, coordinate.z, 0, 0, 0);
                }
            }
        }
    }
}
