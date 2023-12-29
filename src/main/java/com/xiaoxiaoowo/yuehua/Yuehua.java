package com.xiaoxiaoowo.yuehua;

import com.xiaoxiaoowo.yuehua.commands.Test;
import com.xiaoxiaoowo.yuehua.commands.blockcommand.*;
import com.xiaoxiaoowo.yuehua.commands.opcommand.*;
import com.xiaoxiaoowo.yuehua.commands.opcommand.data.DataCountGet;
import com.xiaoxiaoowo.yuehua.commands.opcommand.data.DataGet;
import com.xiaoxiaoowo.yuehua.commands.opcommand.data.DataSet;
import com.xiaoxiaoowo.yuehua.commands.opcommand.data.ItemDataGet;
import com.xiaoxiaoowo.yuehua.commands.playercommand.*;
import com.xiaoxiaoowo.yuehua.commands.playercommand.completer.ArrowCom;
import com.xiaoxiaoowo.yuehua.commands.playercommand.completer.YuanSuCom;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.DisPlayData;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.event.Inventory.Click;
import com.xiaoxiaoowo.yuehua.event.Inventory.Close;
import com.xiaoxiaoowo.yuehua.event.Inventory.Open;
import com.xiaoxiaoowo.yuehua.event.Projectile.Hit;
import com.xiaoxiaoowo.yuehua.event.Spawner.Spawn;
import com.xiaoxiaoowo.yuehua.event.entity.Death;
import com.xiaoxiaoowo.yuehua.event.entity.*;
import com.xiaoxiaoowo.yuehua.event.player.*;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.system.Team;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import com.xiaoxiaoowo.yuehua.utils.MyLootTable;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.*;

public final class Yuehua extends JavaPlugin {
    public static JavaPlugin instance;
    public static BukkitScheduler scheduler;
    public static CommandSender console;
    public static Collection<? extends Player> players;
    public static Map<UUID, Data> playerData;
    public static Map<UUID, MonsterData> monsterData;
    public static Map<UUID, DisPlayData> disPlayData;


    @Override
    public void onEnable() {
        instance = this;
        scheduler = Bukkit.getScheduler();
        console = Bukkit.createCommandSender(it -> {
        });
        players = Bukkit.getOnlinePlayers();
        //对map进行put,get,remove都要注意是在主线程中，对数据本身的操作可以在异步线程中
        //同样的由于ItemStack在加入玩家背包之前，在加入配方之前都是共享的，也不可以异步
        playerData = new HashMap<>(200);
        monsterData = new HashMap<>(8000);
        disPlayData = new HashMap<>(200);
        //数据库
        SQL.connect();

        //初始化
        init();

        //注册监听器
        registerListener();

        //注册命令
        registerCommand();


    }

    public static void sendMes(Component mes, Player player) {
        scheduler.runTaskAsynchronously(instance, () -> player.sendMessage(mes));
    }

    public static void sendMes(Component mes, Collection<Player> players) {
        scheduler.runTaskAsynchronously(instance, () -> players.forEach(it -> it.sendMessage(mes)));
    }

    public static void sendMes(Collection<Component> mess, Player player) {
        scheduler.runTaskAsynchronously(instance, () -> mess.forEach(player::sendMessage));
    }

    public static void sendMes(Collection<Component> mess, Collection<Player> players) {
        scheduler.runTaskAsynchronously(instance, () -> players.forEach(it -> mess.forEach(it::sendMessage)));
    }


    public static void async(Runnable runnable) {
        scheduler.runTaskAsynchronously(instance, runnable);
    }

    public static int asyncWithId(Runnable runnable) {
        return scheduler.runTaskAsynchronously(instance, runnable).getTaskId();
    }

    public static void asyncLater(Runnable runnable, long delay) {
        scheduler.runTaskLater(instance, runnable, delay);
    }

    public static int asyncLaterWithId(Runnable runnable, long delay) {
        return scheduler.runTaskLater(instance, runnable, delay).getTaskId();
    }

    public static void asyncTimer(Runnable runnable, long delay, long period) {
        scheduler.runTaskTimer(instance, runnable, delay, period);
    }

    public static int asyncTimerWithId(Runnable runnable, long delay, long period) {
        return scheduler.runTaskTimer(instance, runnable, delay, period).getTaskId();
    }

    public static void sync(Runnable runnable) {
        scheduler.runTask(instance, runnable);
    }

    public static int syncWithId(Runnable runnable) {
        return scheduler.runTask(instance, runnable).getTaskId();
    }

    public static void syncLater(Runnable runnable, long delay) {
        scheduler.runTaskLater(instance, runnable, delay);
    }

    public static int syncLaterWithId(Runnable runnable, long delay) {
        return scheduler.runTaskLater(instance, runnable, delay).getTaskId();
    }

    public static void syncTimer(Runnable runnable, long delay, long period) {
        scheduler.runTaskTimer(instance, runnable, delay, period);
    }

    public static int syncTimerWithId(Runnable runnable, long delay, long period) {
        return scheduler.runTaskTimer(instance, runnable, delay, period).getTaskId();
    }


    @Override
    public void onDisable() {
        //保存玩家数据
        for (Player player : players) {
            UUID uuid = player.getUniqueId();
            Data data = Yuehua.playerData.get(uuid);

            PersistentDataContainer pdc = player.getPersistentDataContainer();
            pdc.set(DataContainer.money, PersistentDataType.INTEGER, data.money);
            pdc.set(DataContainer.JinCount, PersistentDataType.INTEGER, data.jinCount);
            pdc.set(DataContainer.MuCount, PersistentDataType.INTEGER, data.muCount);
            pdc.set(DataContainer.ShuiCount, PersistentDataType.INTEGER, data.shuiCount);
            pdc.set(DataContainer.HuoCount, PersistentDataType.INTEGER, data.huoCount);
            pdc.set(DataContainer.TuCount, PersistentDataType.INTEGER, data.tuCount);
            pdc.set(DataContainer.RefinedJinCount, PersistentDataType.INTEGER, data.refinedJinCount);
            pdc.set(DataContainer.RefinedMuCount, PersistentDataType.INTEGER, data.refinedMuCount);
            pdc.set(DataContainer.RefinedShuiCount, PersistentDataType.INTEGER, data.refinedShuiCount);
            pdc.set(DataContainer.RefinedHuoCount, PersistentDataType.INTEGER, data.refinedHuoCount);
            pdc.set(DataContainer.RefinedTuCount, PersistentDataType.INTEGER, data.refinedTuCount);
            pdc.set(DataContainer.ConcentratedJinCount, PersistentDataType.INTEGER, data.concentratedJinCount);
            pdc.set(DataContainer.ConcentratedMuCount, PersistentDataType.INTEGER, data.concentratedMuCount);
            pdc.set(DataContainer.ConcentratedShuiCount, PersistentDataType.INTEGER, data.concentratedShuiCount);
            pdc.set(DataContainer.ConcentratedHuoCount, PersistentDataType.INTEGER, data.concentratedHuoCount);
            pdc.set(DataContainer.ConcentratedTuCount, PersistentDataType.INTEGER, data.concentratedTuCount);

            if (data.job == 2) {
                GongData gongData = (GongData) data;
                pdc.set(DataContainer.arrow_count, PersistentDataType.INTEGER, gongData.arrow_count);
            }

            String name = player.getName();
            if (data.inventory1 != null) {
                SQL.storePlayerInventory1(name, data.inventory1);
            }
            if (data.inventory2 != null) {
                SQL.storePlayerInventory2(name, data.inventory2);
            }
            if (data.inventory3 != null) {
                SQL.storePlayerInventory3(name, data.inventory3);
            }
            if (data.inventory4 != null) {
                SQL.storePlayerInventory4(name, data.inventory4);
            }
            if (data.inventory5 != null) {
                SQL.storePlayerInventory5(name, data.inventory5);
            }
            if (data.inventory6 != null) {
                SQL.storePlayerInventory6(name, data.inventory6);
            }
            if (data.inventory7 != null) {
                SQL.storePlayerInventory7(name, data.inventory7);
            }
            if (data.inventory8 != null) {
                SQL.storePlayerInventory8(name, data.inventory8);
            }
            if (data.inventory9 != null) {
                SQL.storePlayerInventory9(name, data.inventory9);
            }
            if (data.shipinBar != null) {
                SQL.storeShiPin(name, data.shipinBar);
            }
        }

        //关数据库
        SQL.close();
    }

    private void init() {
        //@e
        GetEntity.init();
        //队伍
        Team.init();
        //LootTable
        MyLootTable.init();
    }

    private void registerListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();


        //entity
        pluginManager.registerEvents(new AddToWorld(), this);
        pluginManager.registerEvents(new Breed(), this);
        pluginManager.registerEvents(new DamageByEntity(), this);
        pluginManager.registerEvents(new Death(), this);
        pluginManager.registerEvents(new LoadCrossBow(), this);
        pluginManager.registerEvents(new PotionSpLash(), this);
        pluginManager.registerEvents(new RegainHealth(), this);
        pluginManager.registerEvents(new RemoveFromWorld(), this);
        pluginManager.registerEvents(new ShootBow(), this);
        pluginManager.registerEvents(new SlimeSpilt(), this);
        pluginManager.registerEvents(new Transform(), this);


        //Inventory
        pluginManager.registerEvents(new Click(), this);
        pluginManager.registerEvents(new Close(), this);
        pluginManager.registerEvents(new Open(), this);


        //player
        pluginManager.registerEvents(new ConsumeItem(), this);
        pluginManager.registerEvents(new com.xiaoxiaoowo.yuehua.event.player.Death(), this);
        pluginManager.registerEvents(new DropItem(), this);
        pluginManager.registerEvents(new FlowerPotManipulate(), this);
        pluginManager.registerEvents(new Interact(), this);
        pluginManager.registerEvents(new InventorySlotChange(), this);
        pluginManager.registerEvents(new Join(), this);
        pluginManager.registerEvents(new Quit(), this);
        pluginManager.registerEvents(new Swap(), this);
        pluginManager.registerEvents(new ConsumeItem(), this);

        //projectile
        pluginManager.registerEvents(new Hit(), this);


        //Spawner
        pluginManager.registerEvents(new Spawn(), this);

    }

    private void registerCommand() {
        //blockcommand
        Objects.requireNonNull(Bukkit.getPluginCommand("intogame")).setExecutor(new IntoGame());
        Objects.requireNonNull(Bukkit.getPluginCommand("markrelife")).setExecutor(new MarkRelife());
        Objects.requireNonNull(Bukkit.getPluginCommand("relife")).setExecutor(new Relife());
        Objects.requireNonNull(Bukkit.getPluginCommand("renou")).setExecutor(new RenOu());
        Objects.requireNonNull(Bukkit.getPluginCommand("select")).setExecutor(new Select());
        Objects.requireNonNull(Bukkit.getPluginCommand("storerelifestone")).setExecutor(new StoreRelifeStone());

        //opcommand
        //DATA
        Objects.requireNonNull(Bukkit.getPluginCommand("datacountget")).setExecutor(new DataCountGet());
        Objects.requireNonNull(Bukkit.getPluginCommand("dataget")).setExecutor(new DataGet());
        Objects.requireNonNull(Bukkit.getPluginCommand("dataset")).setExecutor(new DataSet());
        Objects.requireNonNull(Bukkit.getPluginCommand("itemdataget")).setExecutor(new ItemDataGet());

        Objects.requireNonNull(Bukkit.getPluginCommand("clearup")).setExecutor(new Clearup());
        Objects.requireNonNull(Bukkit.getPluginCommand("gi")).setExecutor(new GI());
        Objects.requireNonNull(Bukkit.getPluginCommand("mytp")).setExecutor(new MyTp());
        Objects.requireNonNull(Bukkit.getPluginCommand("mytp")).setTabCompleter(new MyTpTab());
        Objects.requireNonNull(Bukkit.getPluginCommand("perget")).setExecutor(new com.xiaoxiaoowo.yuehua.commands.opcommand.PerGet());
        Objects.requireNonNull(Bukkit.getPluginCommand("setsign")).setExecutor(new SetSign());
        Objects.requireNonNull(Bukkit.getPluginCommand("mysummon")).setExecutor(new Summon());

        //playercommand
        Objects.requireNonNull(Bukkit.getPluginCommand("arrow")).setTabCompleter(new ArrowCom());
        Objects.requireNonNull(Bukkit.getPluginCommand("money")).setTabCompleter(new com.xiaoxiaoowo.yuehua.commands.playercommand.completer.MoneyCom());
        Objects.requireNonNull(Bukkit.getPluginCommand("ys")).setTabCompleter(new YuanSuCom());
        Objects.requireNonNull(Bukkit.getPluginCommand("arrow")).setExecutor(new ArrowCMD());
        Objects.requireNonNull(Bukkit.getPluginCommand("ki")).setExecutor(new Kill());
        Objects.requireNonNull(Bukkit.getPluginCommand("money")).setExecutor(new MoneyCMD());
        Objects.requireNonNull(Bukkit.getPluginCommand("yh")).setExecutor(new Yh());
        Objects.requireNonNull(Bukkit.getPluginCommand("ys")).setExecutor(new YuanSuCMD());

        //test
        Objects.requireNonNull(Bukkit.getPluginCommand("test")).setExecutor(new Test());

    }

}
