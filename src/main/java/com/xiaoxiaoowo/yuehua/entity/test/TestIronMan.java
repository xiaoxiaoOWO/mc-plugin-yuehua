package com.xiaoxiaoowo.yuehua.entity.test;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.system.Team;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import com.xiaoxiaoowo.yuehua.utils.MyLootTable;
import org.bukkit.Location;
import org.bukkit.entity.IronGolem;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public final class TestIronMan {

    public static void spawn(Location location) {
        GetEntity.world.spawn(location, IronGolem.class, false, it -> {
                    //特殊类型实体属性
                    //NOAI
                    it.setAI(false);
                    //通用实体属性

                    //怪物实体属性
                    //队伍
                    Team.monsterTeam.addEntity(it);
                    //Tags
                    it.addScoreboardTag("m");
                    //战利品表
                    it.setLootTable(MyLootTable.empty);

                    //法抗与韧性
                    PersistentDataContainer pdc = it.getPersistentDataContainer();
                    pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    pdc.set(DataContainer.id, PersistentDataType.STRING, "testiron");

                }
        );

    }
}
