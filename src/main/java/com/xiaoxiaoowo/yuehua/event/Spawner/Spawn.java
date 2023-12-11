package com.xiaoxiaoowo.yuehua.event.Spawner;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;


public final class Spawn implements Listener {


    @EventHandler
    public void onSpawn(SpawnerSpawnEvent e) {
        Entity entity = e.getEntity();
        //获取位置与Tag
        Location location = entity.getLocation();
        String tag = entity.getScoreboardTags().toArray()[0].toString();
        //清除实体
        entity.remove();
        //生成
        switch (tag){

        }

    }
}
