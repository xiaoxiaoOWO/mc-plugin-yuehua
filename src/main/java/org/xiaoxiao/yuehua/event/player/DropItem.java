package org.xiaoxiao.yuehua.event.player;

import com.destroystokyo.paper.event.player.PlayerReadyArrowEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public final class DropItem implements Listener {
    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Material type = e.getItemDrop().getItemStack().getType();
        if (type == Material.DIAMOND_PICKAXE || type == Material.BOW || type == Material.CROSSBOW || type == Material.SHIELD) {
            e.setCancelled(true);
            e.getPlayer().sendPlainMessage("§c你不能丢弃该物品");

        }

    }
}
