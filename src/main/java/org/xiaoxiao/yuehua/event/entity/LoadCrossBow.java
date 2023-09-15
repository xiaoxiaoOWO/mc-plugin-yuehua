package org.xiaoxiao.yuehua.event.entity;

import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.data.GongData;

public final class LoadCrossBow implements Listener {
    @EventHandler
    public void onLoadCrossBow(EntityLoadCrossbowEvent e) {
        if (e.getEntity() instanceof Player player) {
            Data data = Yuehua.playerData.get(player.getUniqueId());
            if (data.job == 2) {
                if (player.getInventory().getHeldItemSlot() == 0) {
                    GongData gongData = (GongData) data;
                    gongData.readyCrossBow = false;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            gongData.readyCrossBow = true;
                        }
                    }.runTaskLater(Yuehua.instance, 2);
                } else {
                    e.setCancelled(true);
                    player.sendPlainMessage("§c请将弩放在第一格");
                }
            } else {
                PlayerInventory inventory = player.getInventory();
                inventory.setItem(inventory.getHeldItemSlot(), new ItemStack(Material.AIR));
            }


        }
    }
}
