package com.xiaoxiaoowo.yuehua;

import com.xiaoxiaoowo.yuehua.commands.Test;
import com.xiaoxiaoowo.yuehua.commands.blockcommand.IntoGame;
import com.xiaoxiaoowo.yuehua.commands.blockcommand.RenOu;
import com.xiaoxiaoowo.yuehua.commands.blockcommand.Select;
import com.xiaoxiaoowo.yuehua.commands.opcommand.Clearup;
import com.xiaoxiaoowo.yuehua.commands.opcommand.GI;
import com.xiaoxiaoowo.yuehua.commands.opcommand.data.DataGet;
import com.xiaoxiaoowo.yuehua.commands.opcommand.data.DataSet;
import com.xiaoxiaoowo.yuehua.commands.opcommand.data.ItemDataGet;
import com.xiaoxiaoowo.yuehua.commands.playercommand.Yh;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.MonsterData;
import com.xiaoxiaoowo.yuehua.event.Inventory.Click;
import com.xiaoxiaoowo.yuehua.event.Inventory.Close;
import com.xiaoxiaoowo.yuehua.event.Projectile.Hit;
import com.xiaoxiaoowo.yuehua.event.Spawner.Spawn;
import com.xiaoxiaoowo.yuehua.event.entity.Death;
import com.xiaoxiaoowo.yuehua.event.entity.*;
import com.xiaoxiaoowo.yuehua.event.player.*;
import com.xiaoxiaoowo.yuehua.system.Team;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import com.xiaoxiaoowo.yuehua.utils.MyLootTable;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.*;

public final class Yuehua extends JavaPlugin {
    public static JavaPlugin instance;
    public static BukkitScheduler scheduler;
    public static Collection<? extends Player> players;
    public static Map<UUID, Data> playerData;
    public static Map<UUID, MonsterData> monsterData;
    public static FileConfiguration config;

    @Override
    public void onEnable() {
        instance = this;
        scheduler = Bukkit.getScheduler();
        players = Bukkit.getOnlinePlayers();
        playerData = new HashMap<>(1000);
        monsterData = new HashMap<>(10000);

        //配置文件
        saveDefaultConfig();
        config = getConfig();

        //数据库
        SQL.connect();

        //初始化
        init();

        //注册监听器
        registerListener();

        //注册命令
        registerCommand();

    }




    @Override
    public void onDisable() {
        scheduler.cancelTasks(Yuehua.instance);
        //保存玩家数据
        for(Player player : players){
            UUID uuid = player.getUniqueId();
            Data data = Yuehua.playerData.get(uuid);
            Yuehua.playerData.remove(uuid);
            String name = player.getName();
            if(data.inventory1 != null){
                SQL.storePlayerInventory1(name, data.inventory1);
            }
            if(data.inventory2 != null){
                SQL.storePlayerInventory2(name, data.inventory2);
            }
            if(data.inventory3 != null){
                SQL.storePlayerInventory3(name, data.inventory3);
            }
            if(data.inventory4 != null){
                SQL.storePlayerInventory4(name, data.inventory4);
            }
            if(data.inventory5 != null){
                SQL.storePlayerInventory5(name, data.inventory5);
            }
            if(data.inventory6 != null){
                SQL.storePlayerInventory6(name, data.inventory6);
            }
            if(data.inventory7 != null){
                SQL.storePlayerInventory7(name, data.inventory7);
            }
            if(data.inventory8 != null){
                SQL.storePlayerInventory8(name, data.inventory8);
            }
            if(data.inventory9 != null){
                SQL.storePlayerInventory9(name, data.inventory9);
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
        pluginManager.registerEvents(new Breed(), this);
        pluginManager.registerEvents(new DamageByEntity(), this);
        pluginManager.registerEvents(new Death(), this);
        pluginManager.registerEvents(new LoadCrossBow(), this);
        pluginManager.registerEvents(new PotionSpLash(), this);
        pluginManager.registerEvents(new RegainHealth(), this);
        pluginManager.registerEvents(new ShootBow(), this);
        pluginManager.registerEvents(new SlimeSpilt(), this);
        pluginManager.registerEvents(new Transform(), this);



        //Inventory
        pluginManager.registerEvents(new Click(), this);
        pluginManager.registerEvents(new Close(), this);



        //player
        pluginManager.registerEvents(new ConsumeItem(),this);
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
        pluginManager.registerEvents(new Hit(),this);


        //Spawner
        pluginManager.registerEvents(new Spawn(), this);
    }

    private void registerCommand() {
        //blockcommand
        Objects.requireNonNull(Bukkit.getPluginCommand("intogame")).setExecutor(new IntoGame());
        Objects.requireNonNull(Bukkit.getPluginCommand("renou")).setExecutor(new RenOu());
        Objects.requireNonNull(Bukkit.getPluginCommand("select")).setExecutor(new Select());

        //opcommand
        //DATA
        Objects.requireNonNull(Bukkit.getPluginCommand("dataget")).setExecutor(new DataGet());
        Objects.requireNonNull(Bukkit.getPluginCommand("dataset")).setExecutor(new DataSet());
        Objects.requireNonNull(Bukkit.getPluginCommand("itemdataget")).setExecutor(new ItemDataGet());

        Objects.requireNonNull(Bukkit.getPluginCommand("clearup")).setExecutor(new Clearup());
        Objects.requireNonNull(Bukkit.getPluginCommand("gi")).setExecutor(new GI());

        //playercommand
        Objects.requireNonNull(Bukkit.getPluginCommand("yh")).setExecutor(new Yh());

        //test
        Objects.requireNonNull(Bukkit.getPluginCommand("test")).setExecutor(new Test());

    }

}
