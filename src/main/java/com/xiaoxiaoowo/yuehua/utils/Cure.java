package com.xiaoxiaoowo.yuehua.utils;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public final class Cure {

    public static void curePlayer(double amout, Player... players) {
        for (Player player : players) {
            int shengji = Yuehua.playerData.get(player.getUniqueId()).shengji;
            if (shengji == 0) {
                return;
            }
            double hp = player.getHealth();
            amout = amout * shengji / 100.0 + hp;
            double max_hp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            amout = Math.min(max_hp,amout);
            player.setHealth(amout);

        }
    }

    public static void cureMonster(double amout, Creature... creatures){
        for (Creature creature : creatures) {

            MonsterData monsterData = Yuehua.monsterData.get(creature.getUniqueId());
            //取数据
            int shengji;
            if (monsterData == null) {
                PersistentDataContainer pck = creature.getPersistentDataContainer();
                shengji = pck.get(DataContainer.shengji,PersistentDataType.INTEGER);
                int fakang = pck.get(DataContainer.fakang, PersistentDataType.INTEGER);
                int renxing = pck.get(DataContainer.renxing, PersistentDataType.INTEGER);
                String id = pck.get(DataContainer.id, PersistentDataType.STRING);
                Yuehua.monsterData.put(creature.getUniqueId(), new MonsterData(fakang,renxing,shengji,id));
            } else {
                shengji = monsterData.shengji;
            }
            if (shengji == 0) {
                return;
            }
            double hp = creature.getHealth();
            amout = amout * shengji / 100.0 + hp;
            double max_hp = creature.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            amout = Math.min(max_hp,amout);
            creature.setHealth(amout);
        }
    }
}
