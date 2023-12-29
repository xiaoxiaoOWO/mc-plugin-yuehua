package com.xiaoxiaoowo.yuehua.event.entity;

import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import com.xiaoxiaoowo.yuehua.Yuehua;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public final class RemoveFromWorld implements Listener {
    @EventHandler
    public void onRemoveFromWorld(EntityRemoveFromWorldEvent e) {
        Entity entity = e.getEntity();
        if (!entity.getScoreboardTags().contains("m")) {
            return;
        }
        UUID uuid = entity.getUniqueId();
        Yuehua.monsterData.get(uuid).taskIds.forEach(it -> Yuehua.scheduler.cancelTask(it));
        Yuehua.monsterData.remove(uuid);
        entity = null;
    }
}
