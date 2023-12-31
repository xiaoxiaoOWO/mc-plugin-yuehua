package com.xiaoxiaoowo.yuehua.commands.opcommand.data;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class DataGet implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp()) {
                player.sendMessage(
                        Component.translatable("notpermit")
                );
                return true;
            }
            String name = "xiaoxiaoOWO";
            if (args.length != 0) {
                name = args[0];
            }

            Data data = Yuehua.playerData.get(Objects.requireNonNull(Bukkit.getPlayer(name)).getUniqueId());
            player.sendMessage(
                    Component.text(data.toString()).color(NamedTextColor.GREEN)
            );
        }
        return true;
    }
}
