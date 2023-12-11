package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.system.Team;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.net.InetSocketAddress;
import java.util.UUID;

public final class Join implements Listener {
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 10, false, false, true);
    private static final Location WAITING = new Location(GetEntity.world, 207,50,-1766);

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Location location = player.getLocation();
        player.teleport(WAITING);
        new BukkitRunnable() {
            @Override
            public void run() {
                InetSocketAddress inetSocketAddress = player.getAddress();
                if (inetSocketAddress == null) {
                    player.kick(Component.text("网络故障！").color(NamedTextColor.DARK_RED));
                    return;
                }
                String ip = inetSocketAddress.getAddress().getHostAddress();
                //防止双开
                for (Player p : Yuehua.players) {
                    InetSocketAddress address = p.getAddress();
                    if (address == null) {
                        player.kick(Component.text("网络故障！").color(NamedTextColor.DARK_RED));
                        return;
                    }
                    if (address.getAddress().getHostAddress().equals(ip)) {
                        {
                            if (p != player) {
                                p.banPlayer("§c禁止多开");
                                return;
                            }
                        }
                    }
                }

                UUID uuid = player.getUniqueId();
                String name = player.getName();
                PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
                if(!persistentDataContainer.has(DataContainer.attack)){
                    //初始化
                    persistentDataContainer.set(DataContainer.qkd1,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.qkd2,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.qkd3,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.qkd4,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.qkd5,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.qkd6,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.qkd7,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.qkd8,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.qkd9,PersistentDataType.BOOLEAN,false);
                    persistentDataContainer.set(DataContainer.race, PersistentDataType.INTEGER, 0);
                    persistentDataContainer.set(DataContainer.job, PersistentDataType.INTEGER, 0);
                    persistentDataContainer.set(DataContainer.mainland, PersistentDataType.BOOLEAN, true);
                    persistentDataContainer.set(DataContainer.cool_reduce, PersistentDataType.INTEGER, 0);
                    persistentDataContainer.set(DataContainer.branch, PersistentDataType.INTEGER, 0);
                    persistentDataContainer.set(DataContainer.baoji, PersistentDataType.INTEGER, 0);
                    persistentDataContainer.set(DataContainer.baojixiaoguo, PersistentDataType.INTEGER, 150);
                    persistentDataContainer.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                    persistentDataContainer.set(DataContainer.pofa, PersistentDataType.INTEGER, 0);
                    persistentDataContainer.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                    persistentDataContainer.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);
                    persistentDataContainer.set(DataContainer.attack, PersistentDataType.INTEGER, 1);
                    persistentDataContainer.set(DataContainer.attack_add, PersistentDataType.INTEGER, 1);
                    persistentDataContainer.set(DataContainer.attack_mul, PersistentDataType.INTEGER, 100);
                    Team.playerTeam.addPlayer(player);
                }

                //根据职业初始化数据
                switch (persistentDataContainer.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    case 1 -> Yuehua.playerData.put(uuid, new ZhanData(player));
                    case 2 -> Yuehua.playerData.put(uuid, new GongData(player));
                    case 3 -> Yuehua.playerData.put(uuid, new DanData(player));
                    default -> Yuehua.playerData.put(uuid, new Data(player));
                }

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        //OP,玩家处理
                        if (player.isOp()) {
                            player.setGameMode(GameMode.CREATIVE);
                            player.addPotionEffect(effect);
                        } else {
                            //判断是否在大陆
                            if (!persistentDataContainer.get(DataContainer.mainland, PersistentDataType.BOOLEAN)) {
                                player.setHealth(0);
                                player.sendPlainMessage("§c妄图逃离副本机制，已受到惩罚");
                            }
                        }
                        player.teleport(location);
                    }
                }.runTask(Yuehua.instance);



            }
        }.runTaskLaterAsynchronously(Yuehua.instance, 1);

    }

}

