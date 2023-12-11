package com.xiaoxiaoowo.yuehua.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

public final class Breed implements Listener {
    @EventHandler
    public void onBreed(EntityBreedEvent e){
        e.setCancelled(true);
    }

}
