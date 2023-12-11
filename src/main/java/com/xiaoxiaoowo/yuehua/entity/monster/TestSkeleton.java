package com.xiaoxiaoowo.yuehua.entity.monster;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.system.Team;
import com.xiaoxiaoowo.yuehua.utils.MyLootTable;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

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

        Skeleton skeleton = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON, false);

        new BukkitRunnable() {
            @Override
            public void run() {
                //队伍
                Team.monsterTeam.addEntity(skeleton);
                //Tags
                skeleton.addScoreboardTag("monster");



                //NOAI与持久化
                skeleton.setAI(false);
                skeleton.setPersistent(true);
                skeleton.setShouldBurnInDay(false);

                skeleton.spawnAt(location);


                //不能拾取
                skeleton.setCanPickupItems(false);

                //战利品表
                skeleton.setLootTable(MyLootTable.empty);

                //法抗与韧性
                skeleton.getPersistentDataContainer().set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                skeleton.getPersistentDataContainer().set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                Yuehua.monsterData.put(skeleton.getUniqueId(), new MonsterData(0, 0));

                //名称
                skeleton.customName(Component.translatable("testskeleton"));
                skeleton.setCustomNameVisible(true);

                //装备
                EntityEquipment equipment = skeleton.getEquipment();

                equipment.setArmorContents(armor);
                equipment.setItem(EquipmentSlot.HAND, hand);
                equipment.setItem(EquipmentSlot.OFF_HAND, offHand);

                //不掉落
                equipment.setHelmetDropChance(0);
                equipment.setChestplateDropChance(0);
                equipment.setLeggingsDropChance(0);
                equipment.setBootsDropChance(0);
                equipment.setItemInMainHandDropChance(0);
                equipment.setItemInOffHandDropChance(0);

                //属性
                skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000000);
                skeleton.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(0);
                skeleton.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(0);

                //生命,一百万
                skeleton.setHealth(1000000);
            }
        }.runTaskAsynchronously(Yuehua.instance);
    }


}
