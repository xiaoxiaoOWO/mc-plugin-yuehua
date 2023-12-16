package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;


public final class LoadCrossBow implements Listener {
    @EventHandler
    public void onLoadCrossBow(EntityLoadCrossbowEvent e) {
        if (e.getEntity() instanceof Player player) {
            Data data = Yuehua.playerData.get(player.getUniqueId());
            PlayerInventory inventory = player.getInventory();
            if (data.job == 2) {
                //判断是否在第一格且副手没有弩
                if (inventory.getHeldItemSlot() == 0 && inventory.getItemInOffHand().getType() != Material.CROSSBOW) {
                    GongData gongData = (GongData) data;
                    gongData.readyCrossBow = false;
                    Yuehua.scheduler.runTaskLater(
                            Yuehua.instance, () -> gongData.readyCrossBow = true, 2L
                    );


                } else {
                    e.setCancelled(true);
                    player.sendMessage(
                            Component.translatable("not1c")
                    );
                }
            } else {
                ItemStack mainHand = inventory.getItemInMainHand();
                ItemStack offHand = inventory.getItemInOffHand();
                if (mainHand.getType() == Material.CROSSBOW) {
                    inventory.setItemInMainHand(null);
                }
                if (offHand.getType() == Material.CROSSBOW) {
                    inventory.setItemInOffHand(null);
                }
            }


        }
    }
}
