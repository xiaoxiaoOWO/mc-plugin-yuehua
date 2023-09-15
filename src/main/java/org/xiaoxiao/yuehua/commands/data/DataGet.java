package org.xiaoxiao.yuehua.commands.data;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.Data;

import java.util.Objects;

public final class DataGet implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp()) {
                player.sendPlainMessage("§c你没有权限");
                return true;
            }
            String name = "xiaoxiaoOWO";
            Data data = Yuehua.playerData.get(Objects.requireNonNull(Bukkit.getPlayer(name)).getUniqueId());
            player.sendPlainMessage(data.toString());
        }
        return true;
    }
}
