package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;


public final class Quit implements org.bukkit.event.Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Player player = e.getPlayer();
                UUID uuid = player.getUniqueId();
                Data data = Yuehua.playerData.get(uuid);
                Yuehua.playerData.remove(uuid);
                String name = player.getName();
                if(data.inventory1 != null){
                    SQL.storePlayerInventory1(name, data.inventory1);
                }
                if(data.inventory2 != null){
                    SQL.storePlayerInventory2(name, data.inventory2);
                }
                if(data.inventory3 != null){
                    SQL.storePlayerInventory3(name, data.inventory3);
                }
                if(data.inventory4 != null){
                    SQL.storePlayerInventory4(name, data.inventory4);
                }
                if(data.inventory5 != null){
                    SQL.storePlayerInventory5(name, data.inventory5);
                }
                if(data.inventory6 != null){
                    SQL.storePlayerInventory6(name, data.inventory6);
                }
                if(data.inventory7 != null){
                    SQL.storePlayerInventory7(name, data.inventory7);
                }
                if(data.inventory8 != null){
                    SQL.storePlayerInventory8(name, data.inventory8);
                }
                if(data.inventory9 != null){
                    SQL.storePlayerInventory9(name, data.inventory9);
                }
            }
        }.runTaskAsynchronously(Yuehua.instance);
    }
}
