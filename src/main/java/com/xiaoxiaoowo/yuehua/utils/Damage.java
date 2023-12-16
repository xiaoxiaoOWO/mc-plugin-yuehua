package com.xiaoxiaoowo.yuehua.utils;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;
public final class Damage {
    public static void damage(Collection<Creature> creatures, Player player, int damage, int pofa) {
        for (Creature creature : creatures) {
            //仇恨
            if (creature.getTarget() == null) {
                creature.setTarget(player);
            }
            MonsterData monsterData = Yuehua.monsterData.get(creature.getUniqueId());
            //取数据
            int fakang;
            if (monsterData == null) {
                PersistentDataContainer pck = creature.getPersistentDataContainer();
                fakang = pck.get(DataContainer.fakang, PersistentDataType.INTEGER);
                int renxing = pck.get(DataContainer.renxing, PersistentDataType.INTEGER);
                int shengji = pck.get(DataContainer.shengji,PersistentDataType.INTEGER);
                String id = pck.get(DataContainer.id, PersistentDataType.STRING);
                Yuehua.monsterData.put(creature.getUniqueId(), new MonsterData(fakang,renxing,shengji,id));
            } else {
                fakang = monsterData.fakang;
            }
            int x = Math.max(0, fakang - pofa);
            int y = Math.min(100, x);
            //造成伤害设置杀死
            creature.setKiller(player);
            creature.damage(damage * (1 - y / 100.0));
        }
    }


    public static void damage(Player player, double damage) {
        //取数据
        int fakang = Yuehua.playerData.get(player.getUniqueId()).fakang;
        //伤害
        player.damage(damage * (1 - fakang / 100.0));
    }

    public static void damageHuo(Player player, double damage) {

        Data data = Yuehua.playerData.get(player.getUniqueId());
        if(data.race == 5){
            player.sendMessage(
                    Component.translatable("zhaneffect")
            );
            return;
        }

        //取数据
        int fakang = data.fakang;
        //伤害
        player.damage(damage * (1 - fakang / 100.0));
    }

    public static void damage(double damage, Player... players) {
        for (Player player : players) {
            //取数据
            int fakang = Yuehua.playerData.get(player.getUniqueId()).fakang;
            //伤害
            player.damage(damage * (1 - fakang / 100.0));
        }
    }

    public static void damageHuo(double damage, Player... players) {
        for (Player player : players) {
            Data data = Yuehua.playerData.get(player.getUniqueId());
            if(data.race == 5){
                player.sendMessage(
                        Component.translatable("zhaneffect")
                );
                return;
            }

            //取数据
            int fakang = data.fakang;
            //伤害
            player.damage(damage * (1 - fakang / 100.0));
        }
    }
}
