package com.xiaoxiaoowo.yuehua.commands.opcommand.data;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ItemDataGet implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp()) {
                player.sendPlainMessage("§c你没有权限执行此命令");
                return true;
            }

            if (args.length != 1) {
                player.sendPlainMessage("§c参数错误");
                return true;
            }

            int slot = Integer.parseInt(args[0]);

            ItemStack item = player.getInventory().getItem(slot);
            if (item == null || item.getType() == Material.AIR) {
                player.sendPlainMessage("§c物品不存在");
                return true;
            }

            NBTItem nbti = new NBTItem(item);
            player.sendPlainMessage(Objects.requireNonNull(nbti.toString()));
        }
        return true;
    }
}
