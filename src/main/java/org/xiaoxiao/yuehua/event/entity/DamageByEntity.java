package org.xiaoxiao.yuehua.event.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.util.GetEntity;

import java.util.UUID;

public final class DamageByEntity implements Listener {
    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player player) {
            if (player.getAttackCooldown() > 0.99f) {
                UUID uuid = player.getUniqueId();
                Data data = Yuehua.playerData.get(uuid);
                int attack = data.attack;
                int baoji = data.baoji;
                int baojixiaoguo = data.baojixiaoguo;
                //判断是否暴击
                if (GetEntity.random.nextInt(100) < baoji) {
                    attack = attack * baojixiaoguo / 100;
                }
                e.setDamage(attack);
            } else {
                e.setCancelled(true);
            }
        }
    }
}
