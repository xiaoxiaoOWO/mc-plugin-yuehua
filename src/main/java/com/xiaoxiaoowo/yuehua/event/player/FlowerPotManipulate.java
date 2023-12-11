package com.xiaoxiaoowo.yuehua.event.player;

import io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class FlowerPotManipulate implements Listener {

    @EventHandler
    public void onFlowerPotManipulate(PlayerFlowerPotManipulateEvent e) {
        e.setCancelled(true);
    }
}
