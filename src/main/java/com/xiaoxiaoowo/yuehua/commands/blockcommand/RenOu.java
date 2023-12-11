package com.xiaoxiaoowo.yuehua.commands.blockcommand;

import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.jetbrains.annotations.NotNull;

public final class RenOu implements CommandExecutor {
    private static Skeleton skeleton;
    private static Location location;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            player.sendPlainMessage("§c你没有权限执行此命令！");
            return true;
        }


        if (skeleton == null) {
            BlockCommandSender blockCommandSender = (BlockCommandSender) sender;
            Location location1 = blockCommandSender.getBlock().getLocation();
            skeleton = (Skeleton) GetEntity.getNearestMonster(location1, 4, 4, 4);
            location = skeleton.getLocation();
        } else {
            double hp = skeleton.getHealth();
            skeleton.setHealth(1000000);
            double damage = 1000000 - hp;
            if (damage < 1e-6) {
                return true;
            }
            for (Player player : GetEntity.getPlayers(location, 8, 8, 3)) {
                player.sendMessage(
                        Component.text("伤害为： ").color(NamedTextColor.GREEN)
                                .append(Component.text(damage).color(NamedTextColor.RED))
                );
            }
        }

        return true;
    }
}
