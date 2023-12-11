package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;


public final class PotionSpLash implements Listener {
    @EventHandler
    public void onPotionSpLash(PotionSplashEvent e) {
        if (e.getPotion().getShooter() instanceof Player player) {
            if (Yuehua.playerData.get(player.getUniqueId()).job != 3) {
                e.setCancelled(true);
            }
        }
    }
}
