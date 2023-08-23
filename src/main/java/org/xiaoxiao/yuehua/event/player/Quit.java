package org.xiaoxiao.yuehua.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.xiaoxiao.yuehua.Yuehua;

public final class Quit implements org.bukkit.event.Listener{
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Yuehua.playerData.remove(e.getPlayer().getUniqueId());
    }
}
