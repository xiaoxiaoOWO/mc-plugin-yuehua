package org.xiaoxiao.yuehua.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public final class Swap implements Listener {
    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
        e.getPlayer().sendPlainMessage("§c不要使用副手切换");
    }
}
