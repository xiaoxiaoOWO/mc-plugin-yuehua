package com.xiaoxiaoowo.yuehua.commands.opcommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;


public final class Clearup implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp()) {
                player.sendPlainMessage("§c你没有权限执行此命令！");
                return true;
            }
            int radius = 100;
            World world = GetEntity.world;
            new BukkitRunnable() {
                @Override
                public void run() {
                    Location location = player.getLocation();
                    int x0 = location.getBlockX();
                    int y0 = location.getBlockY();
                    int z0 = location.getBlockZ();
                    //清理周围的刷怪笼与红石结构
                    for (int x = -radius; x <= radius; x++) {
                        for (int y = -radius; y <= radius; y++) {
                            for (int z = -radius; z <= radius; z++) {
                                Block block = world.getBlockAt(x0 + x, y0 + y, z0 + z);
                                Material material = block.getType();
                                if (material == Material.SPAWNER) {
                                    block.setType(Material.AIR);
                                }
                                //清理红石系列
                                if (material == Material.REDSTONE_WIRE || material == Material.COMPARATOR || material == Material.REDSTONE_WALL_TORCH || material == Material.REDSTONE_TORCH || material == Material.REPEATER) {
                                    block.setType(Material.AIR);
                                }
                                //清理命令方块
                                if (material == Material.COMMAND_BLOCK || material == Material.CHAIN_COMMAND_BLOCK || material == Material.REPEATING_COMMAND_BLOCK) {
                                    block.setType(Material.AIR);
                                }
                            }
                        }
                    }
                }
            }.runTaskTimer(Yuehua.instance, 0, 100);

        }
        return true;
    }
}
