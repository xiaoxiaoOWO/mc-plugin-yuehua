package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public final class DropItem implements Listener {
    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Material type = e.getItemDrop().getItemStack().getType();
        switch (type) {
            case DIAMOND_PICKAXE, IRON_PICKAXE, WOODEN_PICKAXE, GOLDEN_PICKAXE, BOW, CROSSBOW, SHIELD -> {
                e.setCancelled(true);
                Yuehua.async(() -> e.getPlayer().sendMessage(
                        Component.translatable("cannotdrop")
                ));
            }
        }
    }
}
