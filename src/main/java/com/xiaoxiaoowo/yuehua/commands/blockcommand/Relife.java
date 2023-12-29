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
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public final class Relife implements CommandExecutor {
    public static final Location MIDDLE = new Location(GetEntity.world, 179, 42, 67);
    public static final Location CHA_DIAN_TAN = new Location(GetEntity.world, 687, 70, 115);
    public static final Location SHA_MO_KE_ZHAN = new Location(GetEntity.world, -328, 58, 594);
    public static final Location BAI_HU_RU_KOU = new Location(GetEntity.world, -418, 112, 164);
    public static final Location SHUI_CUN = new Location(GetEntity.world, -331, 24, -697);
    public static final Location SHENG_SHAN = new Location(GetEntity.world, 316, 51, -683);
    public static final Location WEN_QUAN = new Location(GetEntity.world, -459, 103, 332);

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

        //1->复活石，2->复活石种族，3->不用复活石
        switch (args[0]) {
            case "1" -> {
                switch (player.getPersistentDataContainer().get(DataContainer.relife, PersistentDataType.INTEGER)) {
                    case 0 -> {
                        switch (Yuehua.playerData.get(player.getUniqueId()).race) {
                            case 1 -> player.teleportAsync(IntoGame.TP_SHEN);
                            case 2 -> player.teleportAsync(IntoGame.TP_XIAN);
                            case 3 -> player.teleportAsync(IntoGame.TP_REN);
                            case 4 -> player.teleportAsync(IntoGame.TP_YAO);
                            case 5 -> player.teleportAsync(IntoGame.TP_ZHAN);
                        }
                    }

                    case 1 -> player.teleportAsync(MIDDLE);

                    case 2 -> player.teleportAsync(CHA_DIAN_TAN);

                    case 3 -> player.teleportAsync(SHA_MO_KE_ZHAN);

                    case 4 -> player.teleportAsync(BAI_HU_RU_KOU);

                    case 5 -> player.teleportAsync(SHUI_CUN);

                    case 6 -> player.teleportAsync(SHENG_SHAN);

                    case 7 -> player.teleportAsync(WEN_QUAN);
                }
            }

            case "2" -> {
                switch (Yuehua.playerData.get(player.getUniqueId()).race) {
                    case 1 -> player.teleportAsync(IntoGame.TP_SHEN);
                    case 2 -> player.teleportAsync(IntoGame.TP_XIAN);
                    case 3 -> player.teleportAsync(IntoGame.TP_REN);
                    case 4 -> player.teleportAsync(IntoGame.TP_YAO);
                    case 5 -> player.teleportAsync(IntoGame.TP_ZHAN);
                }
            }

            case "3" -> {
                int oldLevel = player.getLevel();
                int newLevel = Math.max(0, oldLevel - 5);
                player.setLevel(newLevel);
                switch (Yuehua.playerData.get(player.getUniqueId()).race) {
                    case 1 -> player.teleportAsync(IntoGame.TP_SHEN);
                    case 2 -> player.teleportAsync(IntoGame.TP_XIAN);
                    case 3 -> player.teleportAsync(IntoGame.TP_REN);
                    case 4 -> player.teleportAsync(IntoGame.TP_YAO);
                    case 5 -> player.teleportAsync(IntoGame.TP_ZHAN);
                }
            }
        }


        return true;
    }
}
