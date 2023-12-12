package com.xiaoxiaoowo.yuehua.commands;


import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.commands.playercommand.Yh;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.entity.monster.TestSkeleton;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import de.tr7zw.nbtapi.NBT;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;


/* ①取实体数据，Tags最快（缺点是只能存string,所以只适合存标记，不适合存数据），
缓存第二快(缓存受到map容量影响，不过我的加载因子设置的很小，影响不大)，
其次persistentDataContainer（好处是持久化），
最慢是计分板（全是坏处）
 * */

/* ②取物品数据，取type最快，几乎0消耗，所以能用种类区别最好用种类；
persistentDataContainer第二快
NBT第三快,
最慢是disPlayName和lore;
* */


/* ③开启异步线程是有损耗的，在本机大约在40000ns.其实不多，甚至比取一次计分板低
 * */

/* ④ItemStack提起初始化好缓存起来更快
 * */


@SuppressWarnings("deprecation")
public final class Test implements CommandExecutor {
    private static ItemStack testItem;
    private static Player player;
    private static Location location ;
    private static final NamespacedKey NAMESPACED_KEY = DataContainer.attack;


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final int QIAN = 1000;
        final int WUWAN = 50000;
        final int SHIWAN = 100000;
        final int WUSHIWAN = 500000;
        final int BAIWAN = 1000000;
        if (sender instanceof Player player) {
            player.sendMessage(
                    Component.translatable("notpermit")
            );
            return true;
        }

        if (args.length != 1) {
            return true;
        }


        switch (args[0]) {
            case "async" -> {
                testTimeCost(Test::testAsync);
            }
            case "setItemId" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testItem = player.getInventory().getItemInMainHand();
                testTimeCost(Test::testSetItemId);
            }

            case "getItemId" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testItem = player.getInventory().getItemInMainHand();
                testMspt(Test::testGetItemId, WUWAN);
            }

            case "getItemName" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testItem = player.getInventory().getItemInMainHand();
                testMspt(Test::testGetItemName, WUWAN);
            }
            case "getItemType" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testItem = player.getInventory().getItemInMainHand();
                testMspt(Test::testGetItemType, WUWAN);
            }


            case "getCache" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetCache, WUSHIWAN);
            }

            case "getPer" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetPersistentDataContainerData, WUSHIWAN);
            }

            case "newData" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testNewData);
            }

            case "newZhanData" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testNewZhanData, QIAN);
            }

            case "newGongData" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testNewGongData, QIAN);
            }

            case "newDanData" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testNewDanData, QIAN);
            }

            case "getTags" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetTag, BAIWAN);
            }
            case "getEntity" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testGetEntity);
            }

            case "perGet" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testItem = player.getInventory().getItemInMainHand();
                testTimeCost(Test::testGetPersistentDataContainerData);
            }

            case "perGet2" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testGetPersistentDataContainerDataAndPrint);
            }


            case "cacheGet" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testGetCache);
            }

            case "cacheSet" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testSetCache, SHIWAN);
            }


            case "perSet" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testItem = player.getInventory().getItemInMainHand();
                testTimeCost(Test::testSetPersistentDataContainer);
            }

            case "setHealth" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testSetHealth);
            }

            case "testInventory" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                PlayerInventory playerInventory = player.getInventory();
                Bukkit.broadcast(Component.text(playerInventory.getSize()));
                Bukkit.broadcast(Component.text(playerInventory.getMaxStackSize()));

            }

            case "testInventory2" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                PlayerInventory playerInventory = player.getInventory();
                for (int i = 0; i < 41; i++) {
                    ItemStack itemStack = playerInventory.getItem(i);
                    if (itemStack == null) {
                        Bukkit.broadcast(Component.text(i + "is null"));
                        continue;
                    }
                    if (itemStack.getType() == Material.AIR) {
                        Bukkit.broadcast(Component.text(i + "is air"));
                    }
                }
            }

            case "testInventory3" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                PlayerInventory playerInventory = player.getInventory();
                System.out.println(playerInventory.toString());
            }

            case "testGetFromNBT" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                PlayerInventory inventory = player.getInventory();
                ItemStack[] itemStacks = NBT.itemStackArrayFromNBT(NBT.parseNBT(Yuehua.config.getString("test")));
                inventory.setContents(itemStacks);
            }

            case "initDB" -> {
                SQL.init();
            }

            case "initQkdFalse" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
                persistentDataContainer.set(DataContainer.qkd1, PersistentDataType.BOOLEAN, false);
                persistentDataContainer.set(DataContainer.qkd2, PersistentDataType.BOOLEAN, false);
                persistentDataContainer.set(DataContainer.qkd3, PersistentDataType.BOOLEAN, false);
                persistentDataContainer.set(DataContainer.qkd4, PersistentDataType.BOOLEAN, false);
                persistentDataContainer.set(DataContainer.qkd5, PersistentDataType.BOOLEAN, false);
                persistentDataContainer.set(DataContainer.qkd6, PersistentDataType.BOOLEAN, false);
                persistentDataContainer.set(DataContainer.qkd7, PersistentDataType.BOOLEAN, false);
                persistentDataContainer.set(DataContainer.qkd8, PersistentDataType.BOOLEAN, false);
                persistentDataContainer.set(DataContainer.qkd9, PersistentDataType.BOOLEAN, false);
            }

            case "initQkdTrue" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                persistentDataContainer.set(DataContainer.qkd1, PersistentDataType.BOOLEAN, true);
                persistentDataContainer.set(DataContainer.qkd2, PersistentDataType.BOOLEAN, true);
                persistentDataContainer.set(DataContainer.qkd3, PersistentDataType.BOOLEAN, true);
                persistentDataContainer.set(DataContainer.qkd4, PersistentDataType.BOOLEAN, true);
                persistentDataContainer.set(DataContainer.qkd5, PersistentDataType.BOOLEAN, true);
                persistentDataContainer.set(DataContainer.qkd6, PersistentDataType.BOOLEAN, true);
                persistentDataContainer.set(DataContainer.qkd7, PersistentDataType.BOOLEAN, true);
                persistentDataContainer.set(DataContainer.qkd8, PersistentDataType.BOOLEAN, true);
                persistentDataContainer.set(DataContainer.qkd9, PersistentDataType.BOOLEAN, true);


                data.inventory1 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯一"));
                data.inventory2 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯二"));
                data.inventory3 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯三"));
                data.inventory4 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯四"));
                data.inventory5 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯五"));
                data.inventory6 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯六"));
                data.inventory7 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯七"));
                data.inventory8 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯八"));
                data.inventory9 = Bukkit.createInventory(player, 54, Component.text("§l§b乾坤袋☯九"));

                data.inventory1.setItem(53, Yh.BACK_BEFORE);
                data.inventory2.setItem(53, Yh.BACK_BEFORE);
                data.inventory3.setItem(53, Yh.BACK_BEFORE);
                data.inventory4.setItem(53, Yh.BACK_BEFORE);
                data.inventory5.setItem(53, Yh.BACK_BEFORE);
                data.inventory6.setItem(53, Yh.BACK_BEFORE);
                data.inventory7.setItem(53, Yh.BACK_BEFORE);
                data.inventory8.setItem(53, Yh.BACK_BEFORE);
                data.inventory9.setItem(53, Yh.BACK_BEFORE);

            }

            case "notInMainland" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
                persistentDataContainer.set(DataContainer.mainland, PersistentDataType.BOOLEAN, false);
            }

//            case "getScore" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testGetScore, SHIWAN);
//            }

            case "getPersist" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetPer, SHIWAN);
            }
//
//            case "setScore" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testSetScore, SHIWAN);
//            }

            case "setPer" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testSetPer, SHIWAN);
            }

            case "getCa" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetCa, SHIWAN);
            }

            case "setCa" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testSetCa, SHIWAN);
            }

//            case "initScore" ->{
//                initScore();
//            }
//
//            case "clearScore" ->{
//                clearScore();
//            }

            case "spawn" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                location = player.getLocation();
                testSpawn();
            }

        }

        return true;
    }


    private static void testTimeCost(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long end = System.nanoTime();
        Bukkit.broadcast(Component.text(end - start));
    }

    private static void testMspt(Runnable runnable, int time) {
        for (int i = 0; i < time; i++) {
            runnable.run();
        }
    }


    //测试异步线程开销
    private static void testAsync() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskAsynchronously(Yuehua.instance);
    }

    //测试取itemId
    private static void testGetItemId() {
        String id = NBTReflectionUtil
                .convertNMSItemtoNBTCompound(ReflectionMethod.ITEMSTACK_NMSCOPY
                        .run((Object) null, new Object[]{testItem})).getString("id");
    }

    private static void testSetItemId() {
        NBTItem nbtItem = new NBTItem(testItem);
        nbtItem.setString("id", "test");
        player.getInventory().setItemInMainHand(nbtItem.getItem());

    }


    //测试取itemName
    private static void testGetItemName() {
        String name = testItem.getDisplayName();
    }

    //测试取itemType
    private static void testGetItemType() {
        Material material = testItem.getType();
    }

    //测试new 一个 Data
    private static void testNewData() {
        Data data = new Data(player);
    }

    //测试new 一个 ZhanData
    private static void testNewZhanData() {
        ZhanData zhanData = new ZhanData(player);
    }

    //测试new 一个 GongData
    private static void testNewGongData() {
        GongData gongData = new GongData(player);
    }

    //测试new 一个 DanData
    private static void testNewDanData() {
        DanData danData = new DanData(player);
    }


    //测试取缓存
    private static void testGetCache() {
        int attack = Yuehua.playerData.get(player.getUniqueId()).attack;
    }

    //测试取Tag
    private static void testGetTag() {
        Set<String> tags = player.getScoreboardTags();
    }

    //测试取附件怪物
    private static void testGetEntity() {
        List<Creature> creatures = GetEntity.getMonsters(player.getLocation(), 4, 4, 4);
    }


    //测试CacheSet
    private static void testSetCache() {
        Yuehua.playerData.get(player.getUniqueId()).attack = 1;
    }

    //测试PersistentDataContainer
    private static void testSetPersistentDataContainer() {
        ItemMeta itemMeta = testItem.getItemMeta();
        itemMeta.getPersistentDataContainer().set(NAMESPACED_KEY, PersistentDataType.STRING, "test");
        testItem.setItemMeta(itemMeta);
    }


    private static void testGetPersistentDataContainerData() {
        int attack = player.getPersistentDataContainer().get(NAMESPACED_KEY, PersistentDataType.INTEGER);
    }

    private static void testGetPersistentDataContainerDataAndPrint() {
        String id = testItem.getPersistentDataContainer().get(NAMESPACED_KEY, PersistentDataType.STRING);
        Bukkit.broadcast(Component.text(id));
    }

    private static void testSetHealth() {
        player.setHealth(20);

    }

    private static void testStore() {
    }

//    private static void testSetScore() {
//        Team.test.getScore(player).setScore(1);
//    }
//
//    private static void initScore() {
//        for (int i = 0; i < 200; i++) {
//            String str = i + "";
//            Team.test.getScore(str).setScore(1);
//        }
//    }
//
//    private static void clearScore() {
//        for (int i = 0; i < 200; i++) {
//            String str = i + "";
//            Team.test.getScore(str).resetScore();
//        }
//    }

    private static void testSetPer() {
        player.getPersistentDataContainer().set(DataContainer.attack, PersistentDataType.INTEGER, 1);
    }

    private static void testSetCa() {
        Yuehua.playerData.get(player.getUniqueId()).attack = 1;
    }

//    private static void testGetScore() {
//        int a = Team.test.getScore(player).getScore();
//    }

    private static void testGetPer() {
        int a = player.getPersistentDataContainer().get(DataContainer.attack, PersistentDataType.INTEGER);
    }

    private static void testGetCa() {
        int a = Yuehua.playerData.get(player.getUniqueId()).attack;
    }

    private static void testSpawn() {
        TestSkeleton.spawn(location);
    }

}

