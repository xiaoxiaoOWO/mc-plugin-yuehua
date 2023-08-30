package org.xiaoxiao.yuehua.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.DanData;
import org.xiaoxiao.yuehua.data.GongData;
import org.xiaoxiao.yuehua.data.ZhanData;
import org.xiaoxiao.yuehua.event.player.Death;
import org.xiaoxiao.yuehua.util.GetEntity;
import org.xiaoxiao.yuehua.system.Scores;

import java.util.UUID;

public final class IntoGame implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            player.sendPlainMessage("§c你没有权限执行此命令！");
            return true;
        }
        Location location = new Location(GetEntity.world, 1217, 27, -380);
        Player player = GetEntity.getNearestPlayer(location, 1, 1, 1);
        UUID uuid = player.getUniqueId();
        String name = player.getName();

        Bukkit.dispatchCommand(Yuehua.console, "execute as " + uuid + " run function yh:selections/into_pangu/into_pangu");

        //种族BUFF
        int race = Scores.getRace(player.getName());
        switch (race) {
            case 1 -> player.addPotionEffect(Death.shen);
            case 2 -> player.addPotionEffect(Death.xian);
            case 3 -> player.addPotionEffect(Death.ren);
            case 4 -> player.addPotionEffect(Death.yao);
            case 5 -> player.addPotionEffect(Death.zhan);
        }


        Yuehua.playerData.remove(uuid);
        int job = Scores.getJob(name);
        switch (job) {
            case 1 -> Yuehua.playerData.put(uuid, new ZhanData(player));
            case 2 -> Yuehua.playerData.put(uuid, new GongData(player));
            case 3 -> Yuehua.playerData.put(uuid, new DanData(player));
        }

        //1tick后ready
        new BukkitRunnable() {
            @Override
            public void run() {
                Yuehua.playerData.get(uuid).ready = true;
            }
        }.runTask(Yuehua.instance);


        return true;
    }
}
