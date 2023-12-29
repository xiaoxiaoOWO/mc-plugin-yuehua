package com.xiaoxiaoowo.yuehua.commands;


import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.commands.playercommand.Yh;
import com.xiaoxiaoowo.yuehua.data.*;
import com.xiaoxiaoowo.yuehua.display.test.TestRay;
import com.xiaoxiaoowo.yuehua.event.player.Death;
import com.xiaoxiaoowo.yuehua.itemstack.other.Food;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.task.test.TestTask;
import com.xiaoxiaoowo.yuehua.task.test.TestTask3;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.*;


/* ①取实体数据，缓存第一快(缓存受到map容量影响，不过我的加载因子设置的很小，影响不大)，
Tags第二快（缺点是只能存string,所以只适合存标记(true,false代表有无tag，boolean很适合)，不适合存数据，也可以持久化），
其次persistentDataContainer（好处是持久化），
最慢是计分板（全是坏处）
 * */

/* ②取物品数据，取type最快，几乎0消耗，所以能用种类区别最好用种类；
CMD略快于Per，persistentDataContainer第二快,但是CMD可读性差(差不多一个MSPT增长21，一个23，只慢了10%但是可读性大幅度提升，而且CMD不能跨种类)
在物品确定了type，且只需要取唯一标识，用cmd
NBT第三快,
最慢是disPlayName和lore;
* */


/* ③开启异步线程是有损耗的，在本机大约在40000ns.其实不多，甚至比取一次计分板低
开启同步任务也有损耗，能不用尽量不用
 * */

/* ④ItemStack提前初始化好缓存起来更快
 * */

/* ⑤战利品表不要用，直接指令生成,更不如直接给到玩家背包里面
 * */

/* ⑥setKiller是很轻量级的操作
 * */

/* ⑦玩家Inv可以异步操作,但不安全，综合考虑还是不要异步操作Inv
 * */

/* ⑧玩家PDC可以异步，但是如果玩家已经不在线将会失效，包括Attribute，Effect，PDC,TAG等
 * */

/* ⑨GetNearByEntity,不如传入filter，底层原因估计是filter可以先筛再进行碰撞箱
 * */

/* ⑩instanceof 快于 tag,但在filter里面 tag更快,
结合九十，综合测试，得出结论，instanceof当类型符合时会更快，但类型大部分情况下不符合时tag更快.
原因是，JVM会在类的继承树中向上追溯，比较对象的类信息与instanceof右侧指定的类。当符合时，很快就能
完成匹配，而不符合时，将不断向上追溯
所以目前只有在getEntity里面用tag，因为大部分entity都不是玩家
 * */

/* PerSistentDataContainer底层应该是HashMap,即使5048项数据也不怎么影响get,TagSet同理
 * */

/* ray使用先范围get再计算距离直线距离的算法，最快
 * */

/* 生成粒子，当粒子多时必选异步，当粒子为10时，同步平均损耗：23950，异步平均损耗:33370，即使粒子很多异步消耗也不多，但带宽损耗多
 * */

/* sendMessage应该全部异步,send一个Component即使很短也比同步快2倍，同步平均：59068.75.异步平均： 34375.44.
发生信息，broadCast,sendTitle,sendActionBar,sendComponent,sendPlayerListHeader,sendPlayerListFooter,sendPlayerListHeaderAndFooter
这种发包的全部异步
 * */

/* 当玩家退出再进入后，之前的player不再生效
当实体被卸载再加载后，也会失效
* */


/*生成展示实体和tp都很耗费时间，相比之下粒子特效好很多
 * */
@SuppressWarnings("deprecation")
public final class Test implements CommandExecutor {
    //    private static ItemStack testItem;
    private static Player player;
    private static Entity entity;
    //    private static Entity entity;
    private static long a = 0;
//    private static LivingEntity entity;
//    private static PlayerInventory playerInventory;
//    private static Location location;
//    private static CommandSender commandSender = Bukkit.getConsoleSender();
//    private static final NamespacedKey NAMESPACED_KEY = DataContainer.attack;


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final int BAI = 100;
        final int QIAN = 1000;
        final int WAN = 10000;
        final int ERWAN = 20000;
        final int WUWAN = 50000;
        final int SHIWAN = 100000;
        final int WUSHIWAN = 500000;
        final int BAIWAN = 1000000;
        final int SanBaiWan = 3000000;
        if (sender instanceof Player player1) {
            if (!player1.isOp()) {
                player1.sendMessage(
                        Component.translatable("notpermit")
                );
            }
        }

        if (args.length != 1) {
            return true;
        }


        switch (args[0]) {

            case "addr" -> testEntityAddr();

            case "monsper" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                entity = GetEntity.getNearestMonster(player.getLocation(), 5, 5, 5);
                testMspt(Test::getMonPer, WUSHIWAN);
            }

            case "yinyong" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testYinYong);
            }

            case "parx" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testParX);
            }

            case "ca" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testCancle();
            }


            case "withTag" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                entity = GetEntity.getNearestMonster(player.getLocation(), 5, 5, 5);
                testMspt(Test::testWithTag, BAIWAN);
            }

            case "withPer" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                entity = GetEntity.getNearestMonster(player.getLocation(), 5, 5, 5);
                testMspt(Test::testWithPer, BAIWAN);
            }

            case "put" -> testTimeCost(Test::testAddToData);

            case "addrini" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                entity = GetEntity.getNearestMonster(player.getLocation(), 5, 5, 5);
            }

            case "addrp" -> testPlayerAddr();

            case "addrer" -> testEntityAddr();

            case "title" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testSendTitle);
            }

            case "atitle" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testSendTitleAysnc);
            }


            case "par" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testPar);
            }

            case "display" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testSummon);
            }

            case "tp" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testTp);
            }

            case "tag" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                entity = GetEntity.getNearestMonster(player.getLocation(), 5, 5, 5);
                testMspt(Test::testTag, SanBaiWan);
            }


            case "instanceof" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                entity = GetEntity.getNearestMonster(player.getLocation(), 5, 5, 5);
                testMspt(Test::testInstanceOf, SanBaiWan);
            }

            case "type" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                entity = GetEntity.getNearestMonster(player.getLocation(), 5, 5, 5);
                testMspt(Test::testType, SanBaiWan);
            }

            case "vec" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testVec();
            }

            case "msg" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testSendMes);
            }

            case "msg2" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testSendMes2);
            }

//            test ray3
//            test ray4
//            test ray5
            //test msg2

            case "par1" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testPar1);
            }

            case "par2" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testPar2);
            }

            case "par3" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testPar3);
            }

            case "par4" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testPar4);
            }

            case "ray1" -> testTimeCost(Test::testRay1);

            case "ray2" -> testTimeCost(Test::testRay2);

            case "ray3" -> testMspt(Test::testRay3, ERWAN);

//            case "ray4" -> testMspt(Test::testRay4, ERWAN);

            case "ray5" -> testMspt(Test::testRay5, ERWAN);

            case "ray6" -> testMspt(Test::testRay6, ERWAN);

//            case "sp" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                location = player.getLocation();
//                testTimeCost(Test::testSpawn1);
//            }
//
//            case "sp2" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                location = player.getLocation();
//                testTimeCost(Test::testSpawn2);
//            }


            case "initQkdTrue" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                Data data = Yuehua.playerData.get(player.getUniqueId());


                player.addScoreboardTag("qkd1");
                player.addScoreboardTag("qkd2");
                player.addScoreboardTag("qkd3");
                player.addScoreboardTag("qkd4");
                player.addScoreboardTag("qkd5");
                player.addScoreboardTag("qkd6");
                player.addScoreboardTag("qkd7");
                player.addScoreboardTag("qkd8");
                player.addScoreboardTag("qkd9");


                data.inventory1 = Bukkit.createInventory(player, 54, Component.translatable("qkd1"));
                data.inventory2 = Bukkit.createInventory(player, 54, Component.translatable("qkd2"));
                data.inventory3 = Bukkit.createInventory(player, 54, Component.translatable("qkd3"));
                data.inventory4 = Bukkit.createInventory(player, 54, Component.translatable("qkd4"));
                data.inventory5 = Bukkit.createInventory(player, 54, Component.translatable("qkd5"));
                data.inventory6 = Bukkit.createInventory(player, 54, Component.translatable("qkd6"));
                data.inventory7 = Bukkit.createInventory(player, 54, Component.translatable("qkd7"));
                data.inventory8 = Bukkit.createInventory(player, 54, Component.translatable("qkd8"));
                data.inventory9 = Bukkit.createInventory(player, 54, Component.translatable("qkd9"));

                data.inventory1.setItem(53, Yh.BACK_BEFORE);
                data.inventory2.setItem(53, Yh.BACK_BEFORE);
                data.inventory3.setItem(53, Yh.BACK_BEFORE);
                data.inventory4.setItem(53, Yh.BACK_BEFORE);
                data.inventory5.setItem(53, Yh.BACK_BEFORE);
                data.inventory6.setItem(53, Yh.BACK_BEFORE);
                data.inventory7.setItem(53, Yh.BACK_BEFORE);
                data.inventory8.setItem(53, Yh.BACK_BEFORE);
                data.inventory9.setItem(53, Yh.BACK_BEFORE);

                Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance, () -> {
                    String name = player.getName();

                    SQL.storePlayerInventory1(name, data.inventory1);
                    SQL.storePlayerInventory2(name, data.inventory2);
                    SQL.storePlayerInventory3(name, data.inventory3);
                    SQL.storePlayerInventory4(name, data.inventory4);
                    SQL.storePlayerInventory5(name, data.inventory5);
                    SQL.storePlayerInventory6(name, data.inventory6);
                    SQL.storePlayerInventory7(name, data.inventory7);
                    SQL.storePlayerInventory8(name, data.inventory8);
                    SQL.storePlayerInventory9(name, data.inventory9);

                });

            }

            case "initShipin" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                Data data = Yuehua.playerData.get(player.getUniqueId());

                data.shipinBar = Bukkit.createInventory(player, 9, Component.translatable("sp"));
                data.shipinBar.setItem(0, Yh.NO);
                data.shipinBar.setItem(1, Yh.NO);
                data.shipinBar.setItem(2, Yh.NO);
                data.shipinBar.setItem(3, Yh.NO);
                data.shipinBar.setItem(4, Yh.NO);
                data.shipinBar.setItem(5, Yh.NO);
                data.shipinBar.setItem(6, Yh.NO);
                data.shipinBar.setItem(7, Yh.NO);
                data.shipinBar.setItem(8, Yh.BACK_BEFORE);
                String name = player.getName();
                SQL.storeShiPin(name, data.shipinBar);


            }

            case "rPer" -> removePer();

            case "pset" -> testSetPlayerPer();

            case "pset2" -> testSetPlayerPer2();

            case "new" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testNewData);
                testTimeCost(Test::testNewDataAsync);
            }

            case "Async" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testNewDataAsync, BAI);
            }

            case "tran" -> testTranAtt();

//            case "tag" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testTag, BAIWAN);
//            }

//            case "instance" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                entity = Bukkit.getEntity(player.getUniqueId());
//                testMspt(Test::testInstanceOf,BAIWAN);
//            }
//
            case "getM1" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetMon1, ERWAN);
            }

//            case "getM2" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testGetMon2, ERWAN);
//            }

//            case "getM3" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testGetMon3, ERWAN);
//            }
//
            case "getP1" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetPlayer1, WUWAN);
            }

//            case "getP2" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testGetPlayer2, WUWAN);
//            }


//            case "cache" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                for (int i = 0; i < BAIWAN * 5; i++) {
//                    if (Yuehua.playerData.get(player.getUniqueId()).attack == 1) {
//                        a++;
//                    }
//                }
//            }

            case "add100" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                Data data = Yuehua.playerData.get(player.getUniqueId());
                for (int i = 0; i < 100; i++) {
                    Yuehua.playerData.put(UUID.randomUUID(), data);
                }
            }

            case "add1000" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                add1000Tag();
            }

            case "r100" -> remove100Tag();

            case "r1000" -> remove1000Tag();

            case "add500" -> {
                add500Per();
            }

            case "add5000" -> {
                add5000Per();
            }

//            case "r100" -> {
//                clear100Per();
//            }

            case "r500" -> {
                clear500Per();
            }

            case "r5000" -> {
                clear5000Per();
            }

            case "get" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::perGet, SHIWAN);
            }


            case "async" -> {
                testTimeCost(Test::testAsync);
            }
//            case "setItemId" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testItem = player.getInventory().getItemInMainHand();
//                testTimeCost(Test::testSetItemId);
//            }
//
//            case "getItemId" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testItem = player.getInventory().getItemInMainHand();
//                testMspt(Test::testGetItemId, WUWAN);
//            }
//
//            case "getItemPer" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testItem = player.getInventory().getItemInMainHand();
//                testMspt(Test::testGetItemPer, SHIWAN);
//            }
//
//            case "getItemCMD" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testItem = player.getInventory().getItemInMainHand();
//                testMspt(Test::testGetItemCMD, SHIWAN);
//            }

//            case "getItemName" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testItem = player.getInventory().getItemInMainHand();
//                testMspt(Test::testGetItemName, WUWAN);
//            }
//            case "getItemType" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testItem = player.getInventory().getItemInMainHand();
//                testMspt(Test::testGetItemType, WUWAN);
//            }


            case "getCache" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetCache, WUSHIWAN);
            }
//
//            case "getPer" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::, WUSHIWAN);
//            }

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
                testMspt(Test::testGetEntity, ERWAN);
            }

            case "getEntity2" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testGetEntity2, ERWAN);
            }
//
//            case "getEntity3" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testGetEntity3,ERWAN);
//            }
//
//            case "getEntity4" ->{
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testGetEntity4,ERWAN);
//            }


//            case "perGet" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testItem = player.getInventory().getItemInMainHand();
//                testTimeCost(Test::testGetPersistentDataContainerData);
//            }
//
//            case "perGet2" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testTimeCost(Test::testGetPersistentDataContainerDataAndPrint);
//            }


            case "cacheGet" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testGetCache);
            }

            case "cacheSet" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testMspt(Test::testSetCache, SHIWAN);
            }


//            case "perSet" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testItem = player.getInventory().getItemInMainHand();
//                testTimeCost(Test::testSetPersistentDataContainer);
//            }

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

//            case "testGetFromNBT" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                PlayerInventory inventory = player.getInventory();
//                ItemStack[] itemStacks = NBT.itemStackArrayFromNBT(NBT.parseNBT(Yuehua.config.getString("test")));
//                inventory.setContents(itemStacks);
//            }

            case "initDB" -> {
                SQL.init();
            }

            case "initQkdFalse" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
//                persistentDataContainer.set(DataContainer.qkd1, PersistentDataType.BOOLEAN, false);
//                persistentDataContainer.set(DataContainer.qkd2, PersistentDataType.BOOLEAN, false);
//                persistentDataContainer.set(DataContainer.qkd3, PersistentDataType.BOOLEAN, false);
//                persistentDataContainer.set(DataContainer.qkd4, PersistentDataType.BOOLEAN, false);
//                persistentDataContainer.set(DataContainer.qkd5, PersistentDataType.BOOLEAN, false);
//                persistentDataContainer.set(DataContainer.qkd6, PersistentDataType.BOOLEAN, false);
//                persistentDataContainer.set(DataContainer.qkd7, PersistentDataType.BOOLEAN, false);
//                persistentDataContainer.set(DataContainer.qkd8, PersistentDataType.BOOLEAN, false);
//                persistentDataContainer.set(DataContainer.qkd9, PersistentDataType.BOOLEAN, false);
            }


//            case "notInMainland" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
//                persistentDataContainer.set(DataContainer.mainland, PersistentDataType.BOOLEAN, false);
//            }

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
                new TestTask(30, player).runTaskTimer(Yuehua.instance, 0, 5);
            }

//            case "spawnItem" -> {
//                testTimeCost(Test::testSpawnItem);
//            }
//
//
//            case "spawnItem2" -> {
//                testMspt(Test::testSpawnItem2, QIAN);
//            }
//
//            case "loot" -> {
//                testMspt(Test::testLoot, QIAN);
//            }

//            case "loot" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                location = player.getLocation();
//                testItem = lootTable.populateLoot(GetEntity.random, new LootContext.Builder(location).luck(0).lootingModifier(0).lootedEntity(null).killer(null).build()).iterator().next();
//                testMspt(Test::testLoot, QIAN);
//            }
//
//            case "loot2" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                location = player.getLocation();
//                testItem = lootTable.populateLoot(GetEntity.random, new LootContext.Builder(location).luck(0).lootingModifier(0).lootedEntity(null).killer(null).build()).iterator().next();
//                testLoot2();
//            }


            case "giveItem" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::testGiveItem);
            }


            case "late" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testLateTask();
            }

            case "late2" -> {
                testLateTask2();
            }

            case "late3" -> {
                testLateTask3();
            }

            case "late4" -> {
                testLateTask4();
            }

            case "time" -> {
                testGetTime();
            }

            case "time2" -> {
                testMspt(Test::testGetTime, BAIWAN);
            }

            case "random" -> {
                testMspt(Test::testRandom, BAIWAN);
            }
            case "task" -> {
                testMspt(Test::testTask, WUWAN);
            }

//            case "clear" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                playerInventory = player.getInventory();
//                testTimeCost(Test::testClear);
//
//            }
//
//            case "null" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                playerInventory = player.getInventory();
//                testTimeCost(Test::testnull);
//            }

//            case "air" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                playerInventory = player.getInventory();
//                testTimeCost(Test::testAir);
//            }

//            case "count" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                playerInventory = player.getInventory();
//                testMspt(Test::testCount, WAN);
//            }
//
//            case "mycount" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                playerInventory = player.getInventory();
//                testMspt(Test::testMyCount, WAN);
//            }

            case "initArrow" -> {
                initArrow();
            }

            case "setPerAsync" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::setPerAsync);
            }
            case "setPerAsync2" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::setPerAsync2);
            }

//            case "asyncinvset" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                playerInventory = player.getInventory();
//                setInvAysnc();
//            }
//
//            case "asyncinvget" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                playerInventory = player.getInventory();
//                getInvAysnc();
//            }
//
//            case "summon"->{
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                entity = TestSkeleton2.spawn(player.getLocation());
//            }

//            case "setKiller" -> {
//                testTimeCost(Test::setKiller);
//            }
//
//            case "setKiller2" -> {
//                testMspt(Test::setKiller,BAIWAN);
//            }

            case "setTag" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::setTag);
            }

            case "remove" -> {
                player = Bukkit.getPlayer("xiaoxiaoOWO");
                testTimeCost(Test::removeTag);
            }

//            case "tag" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testGetPlayerTag,BAIWAN);
//            }
//
//            case "setCacue" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testTimeCost(Test::setPlayerCache);
//            }
//
//            case "cache" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::testGetPlayerCache,BAIWAN);
//            }
//
//            case "getA" -> {
//                getA();
//            }

//            case "Entity" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::getNumEntity, WUWAN);
//            }
//
//            case "Entity2" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::getNumEntity2, WUWAN);
//            }

//            case "player" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::getPlayer, WUWAN);
//            }
//
//            case "player2" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::getPlayer2, WUWAN);
//            }
//
//            case "player3" -> {
//                player = Bukkit.getPlayer("xiaoxiaoOWO");
//                testMspt(Test::getPlayer3, WUWAN);
//            }


        }

        return true;
    }

    private static void testParX() {
        TestRay.run(player);
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
//    private static void testGetItemId() {
//        String id = NBTReflectionUtil
//                .convertNMSItemtoNBTCompound(ReflectionMethod.ITEMSTACK_NMSCOPY
//                        .run((Object) null, new Object[]{testItem})).getString("id");
//    }

//    //测试取per
//    private static void testGetItemPer() {
//        String id = testItem.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING);
//    }
//
//    //测试取cmd
//    private static void testGetItemCMD() {
//        int cmd = testItem.getCustomModelData();
//    }
//
//    private static void testSetItemId() {
//        NBTItem nbtItem = new NBTItem(testItem);
//        nbtItem.setString("id", "test");
//        player.getInventory().setItemInMainHand(nbtItem.getItem());
//
//    }
//
//
//    //测试取itemName
//    private static void testGetItemName() {
//        String name = testItem.getDisplayName();
//    }
//
//    //测试取itemType
//    private static void testGetItemType() {
//        Material material = testItem.getType();
//    }

    //测试new 一个 Data
    private static void testNewData() {
        Data data = new Data(player);
    }

    //测试异步 new Data
    private static void testNewDataAsync() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Data data = new Data(player);
            }
        }.runTaskAsynchronously(Yuehua.instance);
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
        Collection<Entity> mobs = GetEntity.getMonsters(player.getLocation(), 4, 4, 4);
        for (Entity entity : mobs) {
            a++;
        }
    }

    private static void testGetEntity2() {
        Collection<Entity> mobs = GetEntity.getMonsters2(player.getLocation(), 4, 4, 4);
        for (Entity entity : mobs) {
            a++;
        }
    }
//
//    private static void testGetEntity3() {
//        Collection<Creature> creatures = GetEntity.getMonstersWithPredictByType(player.getLocation(), 4, 4, 4);
//        for (Creature creature : creatures){
//            creature.setHealth(10);
//        }
//    }
//
//    private static void testGetEntity4(){
//        Collection<Entity> entities = GetEntity.getMonstersWithPredict2(player.getLocation(), 4, 4, 4);
//        for (Entity entity : entities){
//            Creature creature = (Creature) entity;
//            creature.setHealth(10);
//        }
//    }


    //测试CacheSet
    private static void testSetCache() {
        Yuehua.playerData.get(player.getUniqueId()).attack = 1;
    }

    //测试PersistentDataContainer
//    private static void testSetPersistentDataContainer() {
//        ItemMeta itemMeta = testItem.getItemMeta();
//        itemMeta.getPersistentDataContainer().set(NAMESPACED_KEY, PersistentDataType.STRING, "test");
//        testItem.setItemMeta(itemMeta);
//
//    }
//
//
//    private static void testGetPersistentDataContainerData() {
//        int attack = player.getPersistentDataContainer().get(NAMESPACED_KEY, PersistentDataType.INTEGER);
//    }
//
//    private static void testGetPersistentDataContainerDataAndPrint() {
//        String id = testItem.getPersistentDataContainer().get(NAMESPACED_KEY, PersistentDataType.STRING);
//        Bukkit.broadcast(Component.text(id));
//    }

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

    private static void testGiveItem() {
        ItemStack baozi = Food.baoZi;
        baozi.setAmount(640);
        player.getInventory().addItem(baozi);

    }


    private static void testLateTask() {
        PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
        persistentDataContainer.set(DataContainer.JinCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.MuCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.ShuiCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.HuoCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.TuCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.RefinedJinCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.RefinedMuCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.RefinedShuiCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.RefinedHuoCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.RefinedTuCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.ConcentratedJinCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.ConcentratedMuCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.ConcentratedShuiCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.ConcentratedHuoCount, PersistentDataType.INTEGER, 0);
        persistentDataContainer.set(DataContainer.ConcentratedTuCount, PersistentDataType.INTEGER, 0);
    }


    private static void testLateTask2() {
        Player player1 = Bukkit.getPlayer("xiaoxiaoOWO");
        new BukkitRunnable() {
            @Override
            public void run() {
                player1.addPotionEffect(Death.xian);
            }
        }.runTaskLater(Yuehua.instance, 100);
    }

    private static void testLateTask3() {
        Player player1 = Bukkit.getPlayer("xiaoxiaoOWO");
        new BukkitRunnable() {
            @Override
            public void run() {
                player1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
            }
        }.runTaskLater(Yuehua.instance, 100);
    }

    private static void testLateTask4() {
        Player player1 = Bukkit.getPlayer("xiaoxiaoOWO");
        new BukkitRunnable() {
            @Override
            public void run() {
                player1.getPersistentDataContainer().set(DataContainer.attack, PersistentDataType.INTEGER, 100);
            }
        }.runTaskLater(Yuehua.instance, 100);
    }

    private static void testGetTime() {
        Bukkit.broadcast(Component.text(
                GetEntity.world.getGameTime()
        ));
    }

//    private static void testSpawnItem() {
//        GetEntity.world.dropItem(location, YuanSu.huo);
//
//    }
//
//    private static void testSpawnItem2() {
//        Entity entity = GetEntity.world.dropItem(location, YuanSu.huo);
//
//    }
//
//
//    private static void testLoot() {
//        Bukkit.dispatchCommand(commandSender, "loot spawn 1305 75 44 loot yh:item/yuansu/huo");
//
//    }

    private static void testLoot2() {


    }

    private static void testRandom() {
        int a = GetEntity.random.nextInt();
    }

    private static void testTask() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTask(Yuehua.instance);
    }

//    private static void testClear() {
//        playerInventory.clear(0);
//    }
//
//    private static void testnull() {
//        playerInventory.setItem(0, null);
//    }
//
//    private static void testCount() {
//        HashMap<Integer, ? extends ItemStack> hashMap = playerInventory.all(Material.ARROW);
//        int count = 0;
//        for (Map.Entry<Integer, ? extends ItemStack> entry : hashMap.entrySet()) {
//            count += entry.getValue().getAmount();
//        }
//    }
//
//    private static void testMyCount() {
//        int count = 0;
//        HashMap<Integer, ItemStack> hashMap = new HashMap<>(60);
//        for (int i = 0; i < 36; i++) {
//            ItemStack itemStack = playerInventory.getItem(i);
//            if (itemStack != null && itemStack.getType() == Material.ARROW) {
//                count += itemStack.getAmount();
//                hashMap.put(i, itemStack);
//            }
//        }
//    }

    private static void initArrow() {
        player.getPersistentDataContainer().set(DataContainer.arrow_count_max, PersistentDataType.INTEGER, 10000);
        GongData data = (GongData) Yuehua.playerData.get(player.getUniqueId());
        data.arrow_count_max = 10000;
    }

    private static void setPerAsync() {
        new BukkitRunnable() {
            @Override
            public void run() {
                player.getPersistentDataContainer().set(DataContainer.attack, PersistentDataType.INTEGER, 100);
            }
        }.runTaskAsynchronously(Yuehua.instance);
    }

    private static void setPerAsync2() {
        new BukkitRunnable() {
            @Override
            public void run() {
                player.getPersistentDataContainer().set(DataContainer.attack, PersistentDataType.INTEGER, 1);
            }
        }.runTaskAsynchronously(Yuehua.instance);
    }
//
//    private static void setInvAysnc() {
//        playerInventory.clear(0);
//    }
//
//    private static void getInvAysnc() {
//        playerInventory.getItem(0);
//    }
//
//
//    private static void setKiller() {
//        entity.setKiller(null);
//    }

    private static void setTag() {
        player.addScoreboardTag("test");
    }

    private static void removeTag() {
        player.removeScoreboardTag("test");
    }

    //    private static void testGetPlayerTag(){
//        if(player.getScoreboardTags().contains("test")){
//            a++;
//        }
//    }
//
//    private static void testGetPlayerCache() {
//        if (Yuehua.playerData.get(player.getUniqueId()).attack == 1) {
//            a++;
//        }
//    }
//
//    private static void setPlayerCache(){
//        Yuehua.playerData.get(player.getUniqueId()).attack = 1;
//    }
//
//    private static void getA() {
//        Bukkit.broadcast(Component.text(a));
//    }


//    private static void getNumEntity(){
//        Collection<Entity> entities = GetEntity.getNumberLimitMonsters(player.getLocation(), 4, 4, 4, 3);
//        for (Entity entity : entities){
//            Creature creature = (Creature) entity;
//            creature.setHealth(10);
//        }
//    }
//
//    private static void getNumEntity2(){
//        Entity[] entities = GetEntity.getNumberLimitMonsters2(player.getLocation(), 4, 4, 4, 3);
//        for (Entity entity : entities){
//            Creature creature = (Creature) entity;
//            creature.setHealth(10);
//        }
//    }

//    private static void getPlayer() {
//        ArrayList<Player> players = GetEntity.getPlayers(player.getLocation(), 4, 4, 4);
//        for (Player player : players) {
//        }
//    }
//
//    private static void getPlayer2() {
//        Collection<Entity> players = GetEntity.getPlayers2(player.getLocation(), 4, 4, 4);
//        for (Entity entity : players) {
//            Player player = (Player) entity;
//        }
//    }
//
//    private static void getPlayer3() {
//        Collection<Entity> players = GetEntity.getPlayers3(player.getLocation(), 4, 4, 4);
//        for (Entity entity : players) {
//            Player player = (Player) entity;
//        }
//    }


    private static void perGet() {
        int attack = player.getPersistentDataContainer().get(DataContainer.attack, PersistentDataType.INTEGER);
    }

    private static void add100Per() {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        for (int i = 0; i < 100; i++) {
            pdc.set(new NamespacedKey("yh", i + ""), PersistentDataType.INTEGER, 1);
        }
        Bukkit.broadcast(Component.text(pdc.getKeys().size()));
    }


    private static void add500Per() {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        for (int i = 0; i < 500; i++) {
            pdc.set(new NamespacedKey("yh", i + ""), PersistentDataType.INTEGER, 1);
        }
        Bukkit.broadcast(Component.text(pdc.getKeys().size()));
    }

    private static void add5000Per() {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        for (int i = 0; i < 5000; i++) {
            pdc.set(new NamespacedKey("yh", i + ""), PersistentDataType.INTEGER, 1);
        }
        Bukkit.broadcast(Component.text(pdc.getKeys().size()));
    }

    private static void clear100Per() {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        for (int i = 0; i < 100; i++) {
            pdc.remove(new NamespacedKey("yh", i + ""));
        }
        Bukkit.broadcast(Component.text(pdc.getKeys().size()));
    }

    private static void clear500Per() {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        for (int i = 0; i < 500; i++) {
            pdc.remove(new NamespacedKey("yh", i + ""));
        }
        Bukkit.broadcast(Component.text(pdc.getKeys().size()));
    }


    private static void clear5000Per() {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        for (int i = 0; i < 5000; i++) {
            pdc.remove(new NamespacedKey("yh", i + ""));
        }
        Bukkit.broadcast(Component.text(pdc.getKeys().size()));
    }

    //    private static void testInstanceOf(){
//        if(entity instanceof Player){
//            a++;
//        }
//    }
//
//    private static void testTag() {
//        if (player.getScoreboardTags().contains("test")) {
//            a++;
//        }
//    }

    private static void add100Tag() {
        for (int i = 0; i < 100; i++) {
            player.addScoreboardTag("test" + i);
        }
    }

    private static void add1000Tag() {
        for (int i = 0; i < 1000; i++) {
            player.addScoreboardTag("test" + i);
        }
    }

    private static void remove100Tag() {
        for (int i = 0; i < 100; i++) {
            player.removeScoreboardTag("test" + i);
        }
    }

    private static void remove1000Tag() {
        for (int i = 0; i < 1000; i++) {
            player.removeScoreboardTag("test" + i);
        }
    }

    private static void testTranAtt() {
        AttributeModifier attributeModifier = new AttributeModifier(UUID.randomUUID(), "TEST", 10.0, AttributeModifier.Operation.ADD_NUMBER);
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).addTransientModifier(attributeModifier);
    }

    private static void testGetMon1() {
        Collection<Entity> entities = GetEntity.getMonsters(player.getLocation(), 4, 4, 4);
    }

    //    private static void testGetMon2() {
//        Collection<Entity> entities = GetEntity.getMonsters2(player.getLocation(), 4, 4, 4);
//    }
//
//    private static void testGetMon3() {
//        Collection<Entity> entities = GetEntity.getMonsters3(player.getLocation(), 4, 4, 4);
//    }
//
    private static void testGetPlayer1() {
        Collection<Entity> entities = GetEntity.getPlayers(player.getLocation(), 4, 4, 4);
    }

//    private static void testGetPlayer2() {
//        Collection<Entity> entities = GetEntity.getPlayers2(player.getLocation(), 4, 4, 4);
//    }

    private static void testSetPlayerPer() {
        player.getPersistentDataContainer().set(DataContainer.attack, PersistentDataType.INTEGER, 10);
    }

    private static void testSetPlayerPer2() {
        player.getPersistentDataContainer().set(DataContainer.attack, PersistentDataType.INTEGER, 1);
    }

    private static void removePer() {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.getKeys().forEach(pdc::remove);
    }

//    private static void testSpawn1() {
//        TestSkeleton.spawn(location);
//    }
//
//    private static void testSpawn2() {
//        TestSkeleton.spawn2(location);
//    }

    private static void testVec() {
        Vector vector = player.getEyeLocation().getDirection();
        Bukkit.broadcast(Component.text(vector.length()));
    }


    private static void testRay1() {
        //无意义了
        Entity entity = player.getTargetEntity(50);
        Bukkit.broadcast(Component.text(String.valueOf(entity.getUniqueId())));
    }

    private static void testRay2() {
        Entity entity = player.rayTraceEntities(50).getHitEntity();
        Bukkit.broadcast(Component.text(String.valueOf(entity.getUniqueId())));
    }

    //取直线第一个遇到的用
    private static void testRay3() {
        Location location = player.getEyeLocation();
        Vector direction = location.getDirection();
        RayTraceResult rayTraceResult = GetEntity.world.rayTraceEntities(location, direction, 100, it -> it.getScoreboardTags().contains("monster"));
        if (rayTraceResult != null) {
            Entity entity1 = rayTraceResult.getHitEntity();
        }
    }


    //不好的方式
//    private static void testRay4() {
//        Location location = player.getEyeLocation();
//        Vector direction = location.getDirection();
//        double dx = direction.getX() / 2;
//        double dy = direction.getY() / 2;
//        double dz = direction.getZ() / 2;
//        for (int i = 0; i < 100; i++) { // 假设最大距离为50，每次移动1
//            Entity entity = GetEntity.getOneMonster(location, dx, dy, dz);
//            if (entity != null) {
//                break;
//            }
//            location.add(direction);
//        }
//    }

    //不好的方式
    private static void testRay6() {
        Location location = player.getEyeLocation();
        Vector direction = location.getDirection();
        double dx = direction.getX() / 2;
        double dy = direction.getY() / 2;
        double dz = direction.getZ() / 2;
        List<Creature> creatures = new ArrayList<>(20);
        for (int i = 0; i < 100; i++) { // 假设最大距离为50，每次移动1
            Collection<Entity> monsters = GetEntity.getMonsters(location, dx, dy, dz);
            for (Entity entity1 : monsters) {
                if (entity1 instanceof Creature creature) {
                    creatures.add(creature);
                }
            }
            location.add(direction);
        }
    }

    //取群体用
    private static void testRay5() {
        Location location = player.getEyeLocation();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        Vector direction = location.getDirection();
        double dx = direction.getX() * 50;
        double dy = direction.getY() * 50;
        double dz = direction.getZ() * 50;
        Location midPoint = new Location(GetEntity.world, x + dx, y + dy, z + dz);
        Collection<Entity> monsters = GetEntity.getMonsters(midPoint, dx + 0.5, dy + 0.5, dz + 0.5);
        List<Creature> creatures = new ArrayList<>(monsters.size());
        Vector eyeVector = location.toVector();
        for (Entity entity1 : monsters) {
            if (entity1 instanceof Creature creature) {
                Vector eyeToEntityFeet = creature.getLocation().toVector();
                eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 1).subtract(eyeVector);
                double distance = eyeToEntityFeet.crossProduct(direction).length();
                if (distance < 1.25) {
                    creatures.add(creature);
                }
            }
        }
    }

    private static void testPar1() {
        Location location = player.getEyeLocation();
        Vector direction = location.getDirection();

        Color startColor = Color.fromRGB(255, 0, 0); // 红色
        Color endColor = Color.fromRGB(0, 0, 255);   // 蓝色
        Particle.DustTransition dustTransition = new Particle.DustTransition(startColor, endColor, 1); // 最后一个参数是粒子大小

        for (int i = 0; i < 10; i++) {
            GetEntity.world.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1, 0, 0, 0, dustTransition);
            location.add(direction);
        }
    }

    private static void testPar2() {
        Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance, () -> {
            Location location = player.getEyeLocation();
            Vector direction = location.getDirection();

            Color startColor = Color.fromRGB(255, 0, 0); // 红色
            Color endColor = Color.fromRGB(0, 0, 255);   // 蓝色
            Particle.DustTransition dustTransition = new Particle.DustTransition(startColor, endColor, 1); // 最后一个参数是粒子大小

            for (int i = 0; i < 10; i++) {
                GetEntity.world.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1, 0, 0, 0, dustTransition);
                location.add(direction);
            }
        });
    }

    private static void testPar3() {
        Location location = player.getEyeLocation();
        Vector direction = location.getDirection();

        Color startColor = Color.fromRGB(255, 0, 0); // 红色
        Color endColor = Color.fromRGB(0, 0, 255);   // 蓝色
        Particle.DustTransition dustTransition = new Particle.DustTransition(startColor, endColor, 1); // 最后一个参数是粒子大小

        for (int i = 0; i < 10000; i++) {
            GetEntity.world.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1, 0, 0, 0, dustTransition);
            location.add(direction);
        }
    }

    private static void testPar4() {
        Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance, () -> {
            Location location = player.getEyeLocation();
            Vector direction = location.getDirection();

            Color startColor = Color.fromRGB(255, 0, 0); // 红色
            Color endColor = Color.fromRGB(0, 0, 255);   // 蓝色
            Particle.DustTransition dustTransition = new Particle.DustTransition(startColor, endColor, 1); // 最后一个参数是粒子大小

            for (int i = 0; i < 10000; i++) {
                GetEntity.world.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1, 0, 0, 0, dustTransition);
                location.add(direction);
            }
        });
    }

    //
    private static void testTag() {
        if (entity.getScoreboardTags().contains("p")) {
        }
    }

    private static void testInstanceOf() {
        if (entity instanceof Player) {
        }
    }

    private static void testType() {
        if (entity.getType() == EntityType.PLAYER) {
        }
    }

    private static void testSendMes() {
        player.sendMessage(
                Component.translatable("badarg")
        );
    }

    private static void testSendMes2() {
        Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance, () -> {
            player.sendMessage(
                    Component.translatable("badarg")
            );
        });

    }

    private static void testSendTitle() {
        player.showTitle(Death.title);
    }

    private static void testSendTitleAysnc() {
        Yuehua.async(() -> {
            player.showTitle(Death.title);
        });
    }

    private static void testTp() {
        player.teleport(player.getLocation().add(new Vector(0, 1, 0)));
    }

    private static void testSummon() {
        GetEntity.world.spawn(player.getLocation(), ItemDisplay.class, it -> it.setItemStack(Food.baoZi));
    }

    private static void testPar() {
        GetEntity.world.spawnParticle(Particle.FLAME, player.getLocation(), 1, 0, 0, 0, 0);
    }


    private static void testPlayerAddr() {
        if (player == Bukkit.getPlayer("xiaoxiaoOWO")) {
            Bukkit.broadcast(Component.text("true"));
        }
    }

    private static void testEntityAddr() {
       entity = GetEntity.getNearestMonster(player.getLocation(), 4, 4, 4);
       Bukkit.broadcast(Component.text(entity.toString()));
    }

    private static void testAddToData() {
        MonsterData monsterData = new MonsterData(1, 1, 1, "1");
        Yuehua.monsterData.put(UUID.randomUUID(), monsterData);
    }

    private static void testWithTag() {
        Iterator<String> iterator = entity.getScoreboardTags().iterator();
        while (iterator.hasNext()) {
            switch (iterator.next()) {
                case "m" -> {
                }
                case "test" -> a++;
            }
        }
    }

    private static void testWithPer() {
        switch (entity.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING)) {
            case "m" -> {
            }
            case "test" -> a++;
        }
    }

    private static void testCancle() {
        int taskId = Yuehua.syncTimerWithId(new TestTask3(), 0, 20);
        Yuehua.playerData.get(player.getUniqueId()).taskIds.add(taskId);
    }

    private static void testYinYong(){
        entity = GetEntity.getNearestMonster(player.getLocation(), 4, 4, 4);
        Yuehua.syncTimer(()->{
            Bukkit.broadcast(
                    Component.text(entity.isDead())
            );
        },0,20);
    }

    private static void getMonPer(){
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        switch (pdc.get(DataContainer.id, PersistentDataType.STRING)){
            case "renou" -> {
            }
            case "test" -> a++;
        }
    }



}

