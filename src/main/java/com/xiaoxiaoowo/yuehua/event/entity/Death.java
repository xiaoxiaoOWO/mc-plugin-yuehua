package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public final class Death implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        e.setDroppedExp(0);
        LivingEntity entity = e.getEntity();
        if (entity.getScoreboardTags().contains("monster")) {
            Yuehua.monsterData.remove(entity.getUniqueId());
        }


    }
}
