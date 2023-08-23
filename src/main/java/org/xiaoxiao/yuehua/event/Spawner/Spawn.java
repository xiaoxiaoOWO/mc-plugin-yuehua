package org.xiaoxiao.yuehua.event.Spawner;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.xiaoxiao.yuehua.Yuehua;

public final class Spawn implements Listener {
    @EventHandler
    public void onSpawn(SpawnerSpawnEvent e) {
        Entity entity = e.getEntity();
        //获取位置与Tag
        Location location = entity.getLocation();
        String tag = entity.getScoreboardTags().toArray()[0].toString();
        //清除实体
        entity.remove();
        //获取坐标
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        //执行命令
        Bukkit.dispatchCommand(Yuehua.console,"execute positioned "+x+" "+y+" "+z+" run function yuehua:monsters/"+tag);
    }
}
