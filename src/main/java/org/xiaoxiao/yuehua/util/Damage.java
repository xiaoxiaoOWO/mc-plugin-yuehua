package org.xiaoxiao.yuehua.util;

import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.system.Scores;

import java.util.Objects;

public final class Damage {
    public static void damage(Creature creature, Player player, double damage) {
        Data data = Yuehua.playerData.get(player.getUniqueId());

        //判断是否同队
        if (Objects.equals(Scores.scoreboard.getEntityTeam(creature), data.team)) {
            return;
        }
        //仇恨
        if(creature.getTarget() == null){
            creature.setTarget(player);
        }

        //取数据
        int fakang = Scores.getFakang(creature);
        int pofa = data.pofa;
        int x = Math.max(0,fakang-pofa);
        int y = Math.min(100, x);

        //造成伤害
        creature.damage(damage * (1 - y / 100.0));
    }

    public static void damage(Player player,double damage){
        //取数据
        int fakang = Yuehua.playerData.get(player.getUniqueId()).fakang;
        //伤害
        player.damage(damage * (1 - fakang / 100.0));
    }
}
