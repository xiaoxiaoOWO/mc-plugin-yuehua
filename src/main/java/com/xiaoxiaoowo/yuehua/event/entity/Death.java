package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public final class Death implements Listener {
    private static final Random random = new Random();

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        e.setDroppedExp(0);
        LivingEntity entity = e.getEntity();
        if (entity.getScoreboardTags().contains("m")) {
            //给予战利品,经验
            Player player = entity.getKiller();
            switch (Yuehua.monsterData.get(entity.getUniqueId()).id) {
            }


        }
    }
}
