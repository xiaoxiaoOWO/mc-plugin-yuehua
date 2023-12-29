package com.xiaoxiaoowo.yuehua.commands.blockcommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class StoreRelifeStone implements CommandExecutor {
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
        PlayerInventory playerInventory = player.getInventory();


        int count = 0;
        Collection<ItemStack> itemStacks = (Collection<ItemStack>) playerInventory.all(Material.NETHER_STAR).values();

        for (ItemStack itemStack : itemStacks) {
            count += itemStack.getAmount();
            itemStack.setAmount(0);
        }


        PersistentDataContainer pdc = player.getPersistentDataContainer();
        count += pdc.get(DataContainer.relifeStoneCount, PersistentDataType.INTEGER);
        pdc.set(DataContainer.relifeStoneCount,PersistentDataType.INTEGER,count);
        int incount = count;

        Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance,()->{
            player.sendMessage(
                    Component.translatable("relifestonecount",
                            Component.text(incount).color(NamedTextColor.AQUA)
                    )
            );
        });



        return true;
    }
}
