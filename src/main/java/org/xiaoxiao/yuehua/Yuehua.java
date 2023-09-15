package org.xiaoxiao.yuehua;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.xiaoxiao.yuehua.commands.Clearup;
import org.xiaoxiao.yuehua.commands.IntoGame;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.event.Spawner.Spawn;
import org.xiaoxiao.yuehua.event.entity.Death;
import org.xiaoxiao.yuehua.event.entity.*;
import org.xiaoxiao.yuehua.event.player.*;
import org.xiaoxiao.yuehua.system.Scores;
import org.xiaoxiao.yuehua.system.act.Act;
import org.xiaoxiao.yuehua.util.GetEntity;
import org.xiaoxiao.yuehua.util.MySender;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class Yuehua extends JavaPlugin {

    public static JavaPlugin instance;

    public static MySender console;

    public static HashMap<UUID, Data> playerData;

    public static Collection<? extends Player> players;


    @Override
    public void onEnable() {
        instance = this;
        console = new MySender();
        playerData = new HashMap<>(400);
        players = Bukkit.getOnlinePlayers();

        //默认配置文件与初始化
        saveDefaultConfig();
        init();

        //注册监听器
        registerListener();

        //注册命令
        registerCommand();

        //注册任务
        registerTask();
    }

    @Override
    public void onDisable() {
        // 保存配置
        saveConfig();

        //清理监听器
        HandlerList.unregisterAll(this);

        //取消任务
        Bukkit.getScheduler().cancelTasks(this);
    }

    private void init(){
        //@e
        GetEntity.init();
        //计分板
        Scores.init();
        //激活
        Act.init();

        //战士近战
        DamageByEntity.init();

        //射箭
        ShootBow.init();

        //右键
        Interact.init();

    }

    private void registerListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        //entity
        pluginManager.registerEvents(new Breed(), this);
        pluginManager.registerEvents(new DamageByEntity(), this);
        pluginManager.registerEvents(new Death(), this);
        pluginManager.registerEvents(new LoadCrossBow(), this);
        pluginManager.registerEvents(new PotionSpLash(), this);
        pluginManager.registerEvents(new ShootBow(), this);
        pluginManager.registerEvents(new SlimeSpilt(), this);
        pluginManager.registerEvents(new Transform(), this);
        //player
        pluginManager.registerEvents(new org.xiaoxiao.yuehua.event.player.Death(), this);
        pluginManager.registerEvents(new DropItem(), this);
        pluginManager.registerEvents(new Interact(), this);
        pluginManager.registerEvents(new InventorySlotChange(), this);
        pluginManager.registerEvents(new Join(), this);
        pluginManager.registerEvents(new Quit(), this);
        pluginManager.registerEvents(new Swap(), this);
        //Spawner
        pluginManager.registerEvents(new Spawn(), this);

    }

    private void registerCommand() {
        Objects.requireNonNull(Bukkit.getPluginCommand("clearup")).setExecutor(new Clearup());
        Objects.requireNonNull(Bukkit.getPluginCommand("intogame")).setExecutor(new IntoGame());
        Objects.requireNonNull(Bukkit.getPluginCommand("dataget")).setExecutor(new org.xiaoxiao.yuehua.commands.data.DataGet());
        Objects.requireNonNull(Bukkit.getPluginCommand("dataset")).setExecutor(new org.xiaoxiao.yuehua.commands.data.DataSet());
        Objects.requireNonNull(Bukkit.getPluginCommand("test")).setExecutor(new org.xiaoxiao.yuehua.commands.Test());
        Objects.requireNonNull(Bukkit.getPluginCommand("test2")).setExecutor(new org.xiaoxiao.yuehua.commands.Test2());
    }

    private void registerTask() {
    }
}
