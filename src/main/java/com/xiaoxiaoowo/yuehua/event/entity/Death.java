package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public final class Death implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        e.setDroppedExp(0);
        LivingEntity entity = e.getEntity();
        if (entity.getScoreboardTags().contains("monster")) {
            UUID uuid = entity.getUniqueId();
            MonsterData monsterData = Yuehua.monsterData.get(uuid);
            String id;
            if (monsterData == null) {
                id = entity.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING);
            } else {
                id = monsterData.id;
                Yuehua.monsterData.remove(uuid);
            }
            //给予凋落物
            Player player = entity.getKiller();
            switch (id) {
            }


        }
    }
}
