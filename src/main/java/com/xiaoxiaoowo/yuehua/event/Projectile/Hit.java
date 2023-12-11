package com.xiaoxiaoowo.yuehua.event.Projectile;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Set;

public final class Hit implements Listener {
    @EventHandler
    public void onHit(ProjectileHitEvent e) {
        Set<String> tags = e.getEntity().getScoreboardTags();
        if (tags.isEmpty()) {
            return;
        }

        Block block = e.getHitBlock();
        if (block == null) {
            return;
        }

        switch (tags.iterator().next()) {
            default -> {
            }
        }

    }
}
