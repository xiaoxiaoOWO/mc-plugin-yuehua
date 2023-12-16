package com.xiaoxiaoowo.yuehua.commands.opcommand;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public final class PerGet implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp()) {
                player.sendMessage(
                        Component.translatable("notpermit")
                );
                return true;
            }

            PersistentDataContainer pdc = player.getPersistentDataContainer();
            pdc.getKeys().forEach(it -> {
                switch (it.getKey()) {
                    case "slot0", "slot1", "slot2", "slot3", "slot4", "slot5", "slot8", "slot36", "slot37", "slot38", "slot39", "slot40",
                            "eslot0", "eslot1", "eslot2", "eslot3", "eslot4", "eslot5", "eslot6", "eslot7" ->
                            player.sendMessage(
                                    Component.text(it.getKey() + ": ").color(NamedTextColor.GREEN)
                                            .append(Component.text(pdc.get(it, PersistentDataType.STRING)).color(NamedTextColor.YELLOW))
                            );
                }
            });

            pdc.getKeys().forEach(it -> {
                switch (it.getKey()) {
                    case "slot0", "slot1", "slot2", "slot3", "slot4", "slot5", "slot8", "slot36", "slot37", "slot38", "slot39", "slot40",
                            "eslot0", "eslot1", "eslot2", "eslot3", "eslot4", "eslot5", "eslot6", "eslot7" -> {}
                    default -> player.sendMessage(
                            Component.text(it.getKey() + ": ").color(NamedTextColor.GREEN)
                                    .append(Component.text(pdc.get(it, PersistentDataType.INTEGER)).color(NamedTextColor.YELLOW))
                    );
                }


            });

//
        }
        return true;
    }
}
