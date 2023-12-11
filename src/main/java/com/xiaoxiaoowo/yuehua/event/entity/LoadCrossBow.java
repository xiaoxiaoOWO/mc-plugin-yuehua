package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.itemstack.Air;
import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;


public final class LoadCrossBow implements Listener {
    @EventHandler
    public void onLoadCrossBow(EntityLoadCrossbowEvent e) {
        if (e.getEntity() instanceof Player player) {
            Data data = Yuehua.playerData.get(player.getUniqueId());
            if (data.job == 2) {
                PlayerInventory inventory = player.getInventory();
                //判断是否在第一格且副手没有弩
                if (inventory.getHeldItemSlot() == 0 && inventory.getItemInOffHand().getType() != Material.CROSSBOW) {
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
                ItemStack mainHand = inventory.getItemInMainHand();
                ItemStack offHand = inventory.getItemInOffHand();
                if (mainHand.getType() == Material.CROSSBOW) {
                    inventory.setItemInMainHand(Air.air);
                }
                if (offHand.getType() == Material.CROSSBOW) {
                    inventory.setItemInOffHand(Air.air);
                }
            }


        }
    }
}
