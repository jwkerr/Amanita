package com.fwloopins.amanita.client.cosmetic.particles;

import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.List;

public class ParticlesUtil {

    public static List<Vec3d> createCoordinateCircleFromVec3d(Vec3d pos, int numPoints, double radius, double offputY) {
        List<Vec3d> coordinates = new ArrayList<>();

        for (int i = 0; i < numPoints; i++) {
            double angle = (2.0 * Math.PI * i) / numPoints;

            double x = pos.x + radius * Math.cos(angle);
            double y = pos.y + offputY;
            double z = pos.z + radius * Math.sin(angle);

            coordinates.add(new Vec3d(x, y, z));
        }

        return coordinates;
    }
}
