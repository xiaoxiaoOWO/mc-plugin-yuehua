package com.xiaoxiaoowo.yuehua.entity.test;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.system.Team;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import com.xiaoxiaoowo.yuehua.utils.MyLootTable;
import org.bukkit.Location;
import org.bukkit.entity.Slime;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Set;

public final class TestSlime {
    public static void spawn1(Location location) {
        GetEntity.world.spawn(location, Slime.class, false, it -> {
                    //特殊类型实体属性
                    //NOAI
                    it.setAI(false);
                    it.setSize(1);
                    //通用实体属性
                    //怪物实体属性
                    //队伍
                    Team.monsterTeam.addEntity(it);
                    //Tags
                    Set<String> tags = it.getScoreboardTags();
                    tags.add("m");
                    //战利品表
                    it.setLootTable(MyLootTable.empty);

                    //法抗与韧性
                    PersistentDataContainer pdc = it.getPersistentDataContainer();
                    pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    pdc.set(DataContainer.id, PersistentDataType.STRING, "testslime");

                }
        );

    }

    public static void spawn2(Location location) {
        GetEntity.world.spawn(location, Slime.class, false, it -> {
                    //特殊类型实体属性
                    //NOAI
                    it.setAI(false);
                    it.setSize(2);
                    //通用实体属性
                    //怪物实体属性
                    //队伍
                    Team.monsterTeam.addEntity(it);
                    //Tags
                    it.addScoreboardTag("monster");
                    //战利品表
                    it.setLootTable(MyLootTable.empty);

                    //法抗与韧性
                    PersistentDataContainer pdc = it.getPersistentDataContainer();
                    pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    pdc.set(DataContainer.id, PersistentDataType.STRING, "testslime");
                    Yuehua.monsterData.put(it.getUniqueId(), new MonsterData(0, 0, 100, "testslime"));

                }
        );

    }

    public static void spawn3(Location location) {
        GetEntity.world.spawn(location, Slime.class, false, it -> {
                    //特殊类型实体属性
                    //NOAI
                    it.setAI(false);
                    it.setSize(3);
                    //通用实体属性
                    //怪物实体属性
                    //队伍
                    Team.monsterTeam.addEntity(it);
                    //Tags
                    it.addScoreboardTag("monster");
                    //战利品表
                    it.setLootTable(MyLootTable.empty);

                    //法抗与韧性
                    PersistentDataContainer pdc = it.getPersistentDataContainer();
                    pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    pdc.set(DataContainer.id, PersistentDataType.STRING, "testslime");
                    Yuehua.monsterData.put(it.getUniqueId(), new MonsterData(0, 0, 100, "testslime"));

                }
        );

    }

    public static void spawn4(Location location) {
        GetEntity.world.spawn(location, Slime.class, false, it -> {
                    //特殊类型实体属性
                    //NOAI
                    it.setAI(false);
                    it.setSize(4);
                    //通用实体属性
                    //怪物实体属性
                    //队伍
                    Team.monsterTeam.addEntity(it);
                    //Tags
                    it.addScoreboardTag("monster");
                    //战利品表
                    it.setLootTable(MyLootTable.empty);

                    //法抗与韧性
                    PersistentDataContainer pdc = it.getPersistentDataContainer();
                    pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    pdc.set(DataContainer.id, PersistentDataType.STRING, "testslime");
                    Yuehua.monsterData.put(it.getUniqueId(), new MonsterData(0, 0, 100, "testslime"));

                }
        );

    }

    public static void spawn5(Location location) {
        GetEntity.world.spawn(location, Slime.class, false, it -> {
                    //特殊类型实体属性
                    //NOAI
                    it.setAI(false);
                    it.setSize(5);
                    //通用实体属性
                    //怪物实体属性
                    //队伍
                    Team.monsterTeam.addEntity(it);
                    //Tags
                    it.addScoreboardTag("monster");
                    //战利品表
                    it.setLootTable(MyLootTable.empty);

                    //法抗与韧性
                    PersistentDataContainer pdc = it.getPersistentDataContainer();
                    pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    pdc.set(DataContainer.id, PersistentDataType.STRING, "testslime");
                    Yuehua.monsterData.put(it.getUniqueId(), new MonsterData(0, 0, 100, "testslime"));

                }
        );

    }

    public static void spawn100(Location location) {
        GetEntity.world.spawn(location, Slime.class, false, it -> {
                    //特殊类型实体属性
                    //NOAI
                    it.setAI(false);
                    it.setSize(100);
                    //通用实体属性
                    //怪物实体属性
                    //队伍
                    Team.monsterTeam.addEntity(it);
                    //Tags
                    it.addScoreboardTag("monster");
                    //战利品表
                    it.setLootTable(MyLootTable.empty);

                    //法抗与韧性
                    PersistentDataContainer pdc = it.getPersistentDataContainer();
                    pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    pdc.set(DataContainer.id, PersistentDataType.STRING, "testslime");
                    Yuehua.monsterData.put(it.getUniqueId(), new MonsterData(0, 0, 100, "testslime"));

                }
        );

    }


}
