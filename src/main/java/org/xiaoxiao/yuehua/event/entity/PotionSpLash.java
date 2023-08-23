package org.xiaoxiao.yuehua.event.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.xiaoxiao.yuehua.util.Scores;

public final class PotionSpLash implements Listener {
    @EventHandler
    public void onPotionSpLash(PotionSplashEvent e) {
        if (e.getPotion().getShooter() instanceof Player player) {
            if (Scores.getJob(player.getName()) != 3) {
                e.setCancelled(true);
            }
        }
    }
}
