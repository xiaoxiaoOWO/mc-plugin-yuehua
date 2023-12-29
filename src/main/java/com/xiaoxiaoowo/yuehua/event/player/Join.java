package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.commands.playercommand.Yh;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.net.InetSocketAddress;

public final class Join implements Listener {
    public static final PotionEffect effect = new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 10, false, false, true);
    private static final Location WAITING = new Location(GetEntity.world, 218.5, 50, -1779.5);

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Location location = player.getLocation();
        player.teleport(WAITING);
        Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance, () -> {
            InetSocketAddress inetSocketAddress = player.getAddress();
            if (inetSocketAddress == null) {
                player.kick(Component.translatable("badnet"));
                return;
            }
            String ip = inetSocketAddress.getAddress().getHostAddress();
            //防止双开
            for (Player p : Yuehua.players) {
                InetSocketAddress address = p.getAddress();
                if (address == null) {
                    player.kick(Component.translatable("badnet"));
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



            PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();
            if (!persistentDataContainer.has(DataContainer.attack)) {
                //初始化视频槽
                Inventory shipinBar = Bukkit.createInventory(player, 9, Component.translatable("sp"));
                shipinBar.setItem(0, Yh.NO);
                shipinBar.setItem(1, Yh.NO);
                shipinBar.setItem(2, Yh.NO);
                shipinBar.setItem(3, Yh.NO);
                shipinBar.setItem(4, Yh.NO);
                shipinBar.setItem(5, Yh.NO);
                shipinBar.setItem(6, Yh.NO);
                shipinBar.setItem(7, Yh.NO);
                shipinBar.setItem(8, Yh.BACK_BEFORE);
                String name = player.getName();
                SQL.storeShiPin(name, shipinBar);

                //初始攻击速度
                player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(1);
                //初始化
                persistentDataContainer.set(DataContainer.money, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.slot0, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.slot1, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.slot2, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.slot8, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.slot36, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.slot37, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.slot38, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.slot39, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.slot40, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.eslot0, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.eslot1, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.eslot2, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.eslot3, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.eslot4, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.eslot5, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.eslot6, PersistentDataType.STRING, "null");
                persistentDataContainer.set(DataContainer.eslot7, PersistentDataType.STRING, "null");

                persistentDataContainer.set(DataContainer.task, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.fuben, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.relife, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.relifeStoneCount, PersistentDataType.INTEGER, 0);

                persistentDataContainer.set(DataContainer.race, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.job, PersistentDataType.INTEGER, 0);

                persistentDataContainer.set(DataContainer.cool_reduce, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.branch, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.baoji, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.baojixiaoguo, PersistentDataType.INTEGER, 150);
                persistentDataContainer.set(DataContainer.fakang, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.pofa, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.renxing, PersistentDataType.INTEGER, 0);
                persistentDataContainer.set(DataContainer.shengji, PersistentDataType.INTEGER, 100);

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

                persistentDataContainer.set(DataContainer.attack_add, PersistentDataType.INTEGER, 1);
                persistentDataContainer.set(DataContainer.attack_mul, PersistentDataType.INTEGER, 100);
                persistentDataContainer.set(DataContainer.attack, PersistentDataType.INTEGER, 1);


            }

            //根据职业初始化数据
            Data data = switch (persistentDataContainer.get(DataContainer.job, PersistentDataType.INTEGER)) {
                case 1 -> new ZhanData(player);
                case 2 -> new GongData(player);
                case 3 -> new DanData(player);
                default -> new Data(player);
            };

            Yuehua.sync(() -> Yuehua.playerData.put(player.getUniqueId(), data));

            if (persistentDataContainer.get(DataContainer.fuben, PersistentDataType.INTEGER) != 0) {
                player.setHealth(0);
                player.sendMessage(
                        Component.translatable("notmainland")
                );
            } else {
                player.teleportAsync(location);
            }




        });


    }

}

