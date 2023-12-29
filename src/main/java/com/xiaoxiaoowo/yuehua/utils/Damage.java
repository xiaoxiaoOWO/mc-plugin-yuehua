package com.xiaoxiaoowo.yuehua.utils;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public final class Damage {
    public static void damage(Player player, int damage, int pofa, Mob mob) {

        //仇恨
        if (mob.getTarget() == null) {
            mob.setTarget(player);
        }

        //取数据
        int fakang = Yuehua.monsterData.get(mob.getUniqueId()).fakang;
        int x = Math.max(0, fakang - pofa);
        int y = Math.min(100, x);
        //造成伤害设置杀死
        mob.setKiller(player);
        mob.damage(damage * (1 - y / 100.0));

    }


    public static void damage(Player player, int damage, int pofa, ArrayList<Mob> mobs) {
        for (Mob mob : mobs) {
            //仇恨
            if (mob.getTarget() == null) {
                mob.setTarget(player);
            }
            MonsterData monsterData = Yuehua.monsterData.get(mob.getUniqueId());
            //取数据
            int fakang = Yuehua.monsterData.get(mob.getUniqueId()).fakang;
            int x = Math.max(0, fakang - pofa);
            int y = Math.min(100, x);
            //造成伤害设置杀死
            mob.setKiller(player);
            mob.damage(damage * (1 - y / 100.0));
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
        if (data.race == 5) {
            Yuehua.sendMes(Component.translatable("zhaneffect"),player);
            return;
        }

        //取数据
        int fakang = data.fakang;
        //伤害
        player.damage(damage * (1 - fakang / 100.0));
    }

    public static void damage(double damage, ArrayList<Player> players) {
        for (Player player : players) {
            //取数据
            int fakang = Yuehua.playerData.get(player.getUniqueId()).fakang;
            //伤害
            player.damage(damage * (1 - fakang / 100.0));
        }
    }

    public static void damageHuo(double damage, ArrayList<Player> players) {
        for (Player player : players) {
            Data data = Yuehua.playerData.get(player.getUniqueId());
            if (data.race == 5) {
                Yuehua.sendMes(Component.translatable("zhaneffect"),player);
                return;
            }

            //取数据
            int fakang = data.fakang;
            //伤害
            player.damage(damage * (1 - fakang / 100.0));
        }
    }
}
