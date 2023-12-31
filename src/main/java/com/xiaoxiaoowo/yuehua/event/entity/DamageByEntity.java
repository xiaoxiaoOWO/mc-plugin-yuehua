package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;
import java.util.Set;

public final class DamageByEntity implements Listener {

    private static final Random random = new Random();

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent e) {
        Entity entity = e.getDamager();
        switch (entity.getType()) {
            case PLAYER -> {
                Player player = (Player) entity;
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
                                    if (random.nextInt(100) < baoji) {
                                        attack = attack * baojixiaoguo / 100;
                                    }
                                    e.setDamage(attack);
                                    runZhan(zhanData, (Mob) e.getEntity());
                                } else {
                                    Yuehua.async(() -> player.sendMessage(
                                            Component.translatable("notfull")
                                    ));
                                    e.setCancelled(true);
                                }
                            } else {
                                float cool = player.getAttackCooldown();
                                //天巧
                                if (cool < 0.2f) {
                                    e.setCancelled(true);
                                } else if (cool < 0.4f) {
                                    //妙手一段，造成正常伤害
                                    int attack = data.attack;
                                    int baoji = data.baoji;
                                    int baojixiaoguo = data.baojixiaoguo;
                                    //判断是否暴击
                                    if (random.nextInt(100) < baoji) {
                                        attack = attack * baojixiaoguo / 100;
                                    }
                                    e.setDamage(attack);
                                    runZhan(zhanData, (Mob) e.getEntity());
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
                                Yuehua.async(() -> player.sendMessage(
                                        Component.translatable("notfull")
                                ));
                                e.setCancelled(true);
                            }
                        }
                        case 3 -> {
                            DanData danData = (DanData) data;
                            if (player.getAttackCooldown() > 0.99f) {
                                int attack = data.attack;
                                e.setDamage(attack);

                                runDan(danData, (Mob) e.getEntity());
                            } else {
                                Yuehua.async(() -> player.sendMessage(
                                        Component.translatable("notfull")
                                ));
                                e.setCancelled(true);
                            }
                        }
                        default -> e.setCancelled(true);
                    }
                } else {
                    Yuehua.async(() -> player.sendMessage(
                            Component.translatable("not1a")
                    ));
                    e.setCancelled(true);
                }
            }
            case ARROW -> {
                Arrow arrow = (Arrow) entity;
                Set<String> tags = arrow.getScoreboardTags();
                if (tags.isEmpty()) {
                    return;
                }
                switch (tags.iterator().next()) {
                }

            }
        }
    }


    private void runZhan(ZhanData data, Mob mob) {
        switch (data.slot0.id) {

        }
    }


    private static void runDan(DanData data, Mob mob) {
        switch (data.slot0.id) {

        }
    }
}
