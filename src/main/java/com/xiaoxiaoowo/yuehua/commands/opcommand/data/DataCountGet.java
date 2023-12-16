package com.xiaoxiaoowo.yuehua.commands.opcommand.data;

import com.xiaoxiaoowo.yuehua.Yuehua;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class DataCountGet implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp()) {
                player.sendMessage(
                        Component.translatable("notpermit")
                );
                return true;
            }

            player.sendMessage(
                    Component
                            .translatable("playerdatacount",Component.text(Yuehua.playerData.size()).color(NamedTextColor.YELLOW))
                            .appendNewline()
                            .append(Component.translatable("monsterdatacount",Component.text(Yuehua.monsterData.size()).color(NamedTextColor.YELLOW)))
            );
        }
        return true;
    }
}
