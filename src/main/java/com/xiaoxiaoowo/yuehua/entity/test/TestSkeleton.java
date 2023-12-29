package com.xiaoxiaoowo.yuehua.entity.test;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.system.Team;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import com.xiaoxiaoowo.yuehua.utils.MyLootTable;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public final class TestSkeleton {
    //从脚到头
    private static final ItemStack[] armor = new ItemStack[4];
    private static final ItemStack hand = null;
    private static final ItemStack offHand = null;

    static {
        armor[0] = null;
        armor[1] = null;
        armor[2] = null;
        armor[3] = null;
    }

    public static void spawn(Location location) {
        GetEntity.world.spawn(location, Skeleton.class, false, it -> {
                    //特殊类型实体属性
                    //静音
                    it.setSilent(true);
                    //NOAI
                    it.setAI(false);
                    //不在日光下着火
                    it.setShouldBurnInDay(false);


                    //通用实体属性
                    //名称
                    it.customName(Component.translatable("testskeleton"));
                    it.setCustomNameVisible(true);

                    //怪物实体属性
                    //队伍
                    Team.monsterTeam.addEntity(it);
                    //Tags
                    it.addScoreboardTag("m");
                    //不能拾取
                    it.setCanPickupItems(false);
                    //战利品表
                    it.setLootTable(MyLootTable.empty);

                    //法抗与韧性
                    PersistentDataContainer pdc = it.getPersistentDataContainer();
                    pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    pdc.set(DataContainer.id, PersistentDataType.STRING, "test");


                    //装备，默认没有可以不设置
                    EntityEquipment equipment = it.getEquipment();

                    equipment.setArmorContents(armor);
                    equipment.setItem(EquipmentSlot.HAND, hand);
                    equipment.setItem(EquipmentSlot.OFF_HAND, offHand);

                    //不掉落,没有可以不设置
                    equipment.setHelmetDropChance(0);
                    equipment.setChestplateDropChance(0);
                    equipment.setLeggingsDropChance(0);
                    equipment.setBootsDropChance(0);
                    equipment.setItemInMainHandDropChance(0);
                    equipment.setItemInOffHandDropChance(0);

                    //属性
                    it.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000000);
                    it.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(0);
                    it.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(0);

                    //生命,一百万
                    it.setHealth(1000000);
                }
        );

    }


//    public static void spawn2(Location location) {
//        Skeleton skeleton = (Skeleton) GetEntity.world.spawnEntity(location, EntityType.SKELETON, false);
//
//        //特殊类型实体属性
//        //静音
//        skeleton.setSilent(true);
//        //NOAI
//        skeleton.setAI(false);
//        //不在日光下着火
//        skeleton.setShouldBurnInDay(false);
//        //不自然移除
//        skeleton.setRemoveWhenFarAway(false);
//
//        //通用实体属性
//        //名称
//        skeleton.customName(Component.translatable("testskeleton"));
//        skeleton.setCustomNameVisible(true);
//
//        //怪物实体属性
//        //队伍
//        Team.monsterTeam.addEntity(skeleton);
//        //Tags
//        Set<String> tags = skeleton.getScoreboardTags();
//        tags.add("m");
//        tags.add("test");
//        //不能拾取
//        skeleton.setCanPickupItems(false);
//        //战利品表
//        skeleton.setLootTable(MyLootTable.empty);
//
//        //法抗与韧性
//        PersistentDataContainer pdc = skeleton.getPersistentDataContainer();
//        pdc.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
//        pdc.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
//        pdc.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
//        pdc.set(DataContainer.id, PersistentDataType.STRING, "test");
//        Yuehua.monsterData.put(skeleton.getUniqueId(), new MonsterData(0, 0, 100, "test"));
//
//
//        //装备
//        EntityEquipment equipment = skeleton.getEquipment();
//
//        equipment.setArmorContents(armor);
//        equipment.setItem(EquipmentSlot.HAND, hand);
//        equipment.setItem(EquipmentSlot.OFF_HAND, offHand);
//
//        //不掉落
//        equipment.setHelmetDropChance(0);
//        equipment.setChestplateDropChance(0);
//        equipment.setLeggingsDropChance(0);
//        equipment.setBootsDropChance(0);
//        equipment.setItemInMainHandDropChance(0);
//        equipment.setItemInOffHandDropChance(0);
//
//        //属性
//        skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000000);
//        skeleton.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(0);
//        skeleton.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(0);
//
//        //生命,一百万
//        skeleton.setHealth(1000000);
//
//
//    }


}
