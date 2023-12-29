package com.xiaoxiaoowo.yuehua.display.test;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public final class TestRay {


    public static void run(Player player) {
        Yuehua.async(() -> {
            Location location = player.getEyeLocation();
            Location location2 = location.clone();
            Location location3 = location.clone();
            Vector direction = location.getDirection();
            Vector direction2 = direction.clone().rotateAroundY(Math.PI / 6).multiply(4);
            Vector direction3 = direction.clone().rotateAroundY(-Math.PI / 6).multiply(4);
            direction.multiply(2);
            World world = GetEntity.world;
            for (int i = 0; i < 5; i++) {
                location.add(direction);
                location2.add(direction2);
                location3.add(direction3);
                world.spawnParticle(Particle.FLAME, location, 1, 0, 0, 0, 0.005);
                world.spawnParticle(Particle.FLAME, location2, 1, 0, 0, 0, 0.005);
                world.spawnParticle(Particle.FLAME, location3, 1, 0, 0, 0, 0.005);

            }
        });
    }
}
