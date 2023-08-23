package org.xiaoxiao.yuehua.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public final class Death implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        e.setDroppedExp(0);
    }
}
