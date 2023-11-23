package com.fwloopins.amanita.client.tweak.bobberremoval;

import com.fwloopins.amanita.client.AmanitaClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BobberRemoval {

    public static void bobberRemovalTick(MinecraftClient client) {
        if (!AmanitaClient.getConfig().cosmetics.tweaks.bobberRemoval)
            return;

        World world = client.world;
        if (world == null)
            return;

        ClientPlayerEntity player = client.player;
        if (player == null)
            return;

        Vec3d headPos = new Vec3d(player.getX(), player.getEyeY(), player.getZ());

        for (Entity entity : world.getEntitiesByClass(FishingBobberEntity.class, new Box(headPos, headPos).expand(0.5), e -> true)) {
            if (entity instanceof FishingBobberEntity bobber) {
                if (headPos.distanceTo(bobber.getPos()) < 0.5) {
                    bobber.remove(Entity.RemovalReason.DISCARDED);
                }
            }
        }
    }
}
