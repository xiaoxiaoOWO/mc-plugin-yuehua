package com.xiaoxiaoowo.yuehua.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SlimeSplitEvent;

public final class SlimeSpilt implements Listener{
    @EventHandler
    public void onSlimeSpilt(SlimeSplitEvent e){
        e.setCancelled(true);
    }
}
