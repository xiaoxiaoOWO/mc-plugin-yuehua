package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Set;

public final class DamageByEntity implements Listener {

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
                                    if (GetEntity.random.nextInt(100) < baoji) {
                                        attack = attack * baojixiaoguo / 100;
                                    }
                                    e.setDamage(attack);
                                    runZhan(player, zhanData, (Creature) e.getEntity());
                                } else {
                                    player.sendMessage(
                                            Component.translatable("notfull")
                                    );
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
                                    if (GetEntity.random.nextInt(100) < baoji) {
                                        attack = attack * baojixiaoguo / 100;
                                    }
                                    e.setDamage(attack);
                                    runZhan(player, zhanData, (Creature) e.getEntity());
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
                                player.sendMessage(
                                        Component.translatable("notfull")
                                );
                                e.setCancelled(true);
                            }
                        }
                        case 3 -> {
                            DanData danData = (DanData) data;
                            if (player.getAttackCooldown() > 0.99f) {
                                int attack = data.attack;
                                e.setDamage(attack);

                                runDan(player, danData, (Creature) e.getEntity());
                            } else {
                                player.sendMessage(
                                        Component.translatable("notfull")
                                );
                                e.setCancelled(true);
                            }
                        }
                        default -> e.setCancelled(true);
                    }
                } else {
                    player.sendMessage(
                            Component.translatable("not1a")
                    );
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
                    default -> {
                    }
                }

            }
        }
    }


    private void runZhan(Player player, ZhanData data, Creature creature) {
        switch (data.slot0.id) {

        }
    }

    private static void runGong(Player player, GongData data, Arrow arrow) {
        String id = data.slot0.id;
        if (!arrow.getScoreboardTags().contains(id)) {
            return;
        }
        switch (id) {

        }
    }

    private static void runDan(Player player, DanData data, Creature creature) {
        switch (data.slot0.id) {

        }
    }
}
