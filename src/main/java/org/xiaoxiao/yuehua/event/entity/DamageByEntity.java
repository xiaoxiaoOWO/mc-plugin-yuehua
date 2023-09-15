package org.xiaoxiao.yuehua.event.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.DanData;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.data.ZhanData;
import org.xiaoxiao.yuehua.system.Attack.DanAttack;
import org.xiaoxiao.yuehua.system.Attack.ZhanAttack;
import org.xiaoxiao.yuehua.util.GetEntity;

import java.util.HashMap;

public final class DamageByEntity implements Listener {
    private static final HashMap<String, ZhanAttack> tasksZhan = new HashMap<>(70);
    private static final HashMap<String, DanAttack> tasksDan = new HashMap<>(30);

    public static void init() {

    }


    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player player) {
            if (player.getInventory().getHeldItemSlot() == 0) {
                Data data = Yuehua.playerData.get(player.getUniqueId());
                switch (data.job) {
                    case 1 -> {
                        //未进阶，刹那
                        ZhanData zhanData = (ZhanData) data;
                        if (zhanData.branch != 2) {
                            if (player.getAttackCooldown() > 0.99f) {
                                int attack = data.attack;
                                int baoji = data.baoji;
                                int baojixiaoguo = data.baojixiaoguo;
                                //判断是否暴击
                                if (GetEntity.random.nextInt(100) < baoji) {
                                    attack = attack * baojixiaoguo / 100;
                                }
                                e.setDamage(attack);
                                tasksZhan.get(zhanData.slot0).run(zhanData, player);
                            } else {
                                e.setCancelled(true);
                            }
                        } else {
                            float cool = player.getAttackCooldown();
                            //天巧
                            if (cool < 0.2f) {
                                e.setCancelled(true);
                            } else if (cool < 0.4f) {
                                //妙手一段，造成正常伤害
                                int attack = data.attack ;
                                int baoji = data.baoji;
                                int baojixiaoguo = data.baojixiaoguo;
                                //判断是否暴击
                                if (GetEntity.random.nextInt(100) < baoji) {
                                    attack = attack * baojixiaoguo / 100;
                                }
                                e.setDamage(attack);
                                tasksZhan.get(zhanData.slot0).run(zhanData, player);
                            } else if (cool < 0.6f) {
                                //妙手二段,必定暴击
                            } else if (cool < 0.8f) {
                                //妙手三段，额外造成百分比已损生命值伤害
                            } else {
                                //妙手四段，额外造成范围群体伤害和短暂眩晕
                            }
                        }
                    }
                    case 2 -> {
                        if (player.getAttackCooldown() > 0.99f) {
                            int attack = data.attack;
                            e.setDamage(attack);
                        } else {
                            e.setCancelled(true);
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;
                        if (player.getAttackCooldown() > 0.99f) {
                            int attack = data.attack;
                            e.setDamage(attack);
                            //
                            tasksDan.get(danData.slot0).run(player, danData);
                        } else {
                            e.setCancelled(true);
                        }
                    }
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
