package com.xiaoxiaoowo.yuehua.utils;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public final class Cure {

    public static void curePlayer(double amout, Player player) {

        int shengji = Yuehua.playerData.get(player.getUniqueId()).shengji;
        if (shengji == 0) {
            return;
        }
        double hp = player.getHealth();
        amout = amout * shengji / 100.0 + hp;
        double max_hp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        amout = Math.min(max_hp, amout);
        player.setHealth(amout);

    }

    public static void curePlayer(double amout, ArrayList<Player> players) {
        for (Player player : players) {
            int shengji = Yuehua.playerData.get(player.getUniqueId()).shengji;
            if (shengji == 0) {
                return;
            }
            double hp = player.getHealth();
            amout = amout * shengji / 100.0 + hp;
            double max_hp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            amout = Math.min(max_hp, amout);
            player.setHealth(amout);

        }
    }

    public static void cureMonster(double amout, ArrayList<Mob> mobs) {
        for (Mob mob : mobs) {
            //取数据
            int shengji = Yuehua.monsterData.get(mob.getUniqueId()).shengji;
            if (shengji == 0) {
                return;
            }
            double hp = mob.getHealth();
            amout = amout * shengji / 100.0 + hp;
            double max_hp = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            amout = Math.min(max_hp, amout);
            mob.setHealth(amout);
        }
    }

    public static void cureMonster(double amout, Mob mob) {

        int shengji = Yuehua.monsterData.get(mob.getUniqueId()).shengji;
        if (shengji == 0) {
            return;
        }
        double hp = mob.getHealth();
        amout = amout * shengji / 100.0 + hp;
        double max_hp = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        amout = Math.min(max_hp, amout);
        mob.setHealth(amout);
    }

}
