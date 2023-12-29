package com.xiaoxiaoowo.yuehua.commands.blockcommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public final class MarkRelife implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance,()->{
                player.sendMessage(
                        Component.translatable("notpermit")
                );
            });
            return true;
        }
        BlockCommandSender blockCommandSender = (BlockCommandSender) sender;
        Location location = blockCommandSender.getBlock().getLocation();
        Player player = GetEntity.getNearestPlayer(location, 5, 5, 5);
        PersistentDataContainer pdc = player.getPersistentDataContainer();

        switch (args[0]) {
            case "1" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 1);
            case "2" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 2);
            case "3" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 3);
            case "4" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 4);
            case "5" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 5);
            case "6" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 6);
            case "7" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 7);
            case "8" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 8);
            case "9" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 9);
            case "10" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 10);
            case "11" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 11);
            case "12" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 12);
            case "13" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 13);
            case "14" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 14);
            case "15" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 15);
            case "16" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 16);
            case "17" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 17);
            case "18" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 18);
            case "19" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 19);
            case "20" -> pdc.set(DataContainer.relife, PersistentDataType.INTEGER, 20);
        }

        Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance,()->{
            player.sendMessage(
                    Component.translatable("mark")
            );
        });


        return true;

    }
}
