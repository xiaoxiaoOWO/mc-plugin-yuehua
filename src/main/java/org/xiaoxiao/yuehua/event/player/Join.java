package org.xiaoxiao.yuehua.event.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.DanData;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.data.GongData;
import org.xiaoxiao.yuehua.data.ZhanData;
import org.xiaoxiao.yuehua.system.Scores;

import java.util.UUID;

public final class Join implements Listener {
    private static final PotionEffect effect = new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 0, false, false, true);


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        String name = player.getName();
//        String ip = player.getAddress().getAddress().getHostAddress();
//        //防止双开
//        for (Player p : Yuehua.players) {
//            if (p.getAddress().getAddress().getHostAddress().equals(ip)) {
//                {
//                    if (p != player) {
//                        p.banPlayer("§c禁止多开");
//                        return;
//                    }
//                }
//            }
//        }


        //根据职业初始化数据
        int job = Scores.getJob(name);
        switch (job) {
            case 1 -> Yuehua.playerData.put(uuid, new ZhanData(player));
            case 2 -> Yuehua.playerData.put(uuid, new GongData(player));
            case 3 -> Yuehua.playerData.put(uuid, new DanData(player));
            default -> Yuehua.playerData.put(uuid, new Data(player));
        }


        //OP,玩家处理
        if (player.isOp()) {
            player.setGameMode(GameMode.CREATIVE);
            player.addPotionEffect(effect);
        } else {
            //判断是否在大陆
            if (Yuehua.playerData.get(player.getUniqueId()).mainland == -1) {
                player.setHealth(0);
                player.sendPlainMessage("§c你不在大陆，已受到惩罚");
            }
        }


        //1tick后ready
        new BukkitRunnable() {
            @Override
            public void run() {
                Yuehua.playerData.get(uuid).ready = true;
            }
        }.runTask(Yuehua.instance);
    }
}
