package com.xiaoxiaoowo.yuehua.event.player;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public final class Swap implements Listener {
    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
        e.getPlayer().sendMessage(
                Component.translatable("notf")
        );
    }
}
