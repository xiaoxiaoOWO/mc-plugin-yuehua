package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public final class RegainHealth implements Listener {
    @EventHandler
    public void onRegainHealth(EntityRegainHealthEvent e) {
        if (e.getEntity() instanceof Player player) {
            Data data = Yuehua.playerData.get(player.getUniqueId());
            int shengji = data.shengji;
            if (shengji == 0) {
                e.setCancelled(true);
            } else {
                e.setAmount(e.getAmount() * shengji / 100);
            }
        }
    }
}
