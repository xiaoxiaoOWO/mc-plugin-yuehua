package com.xiaoxiaoowo.yuehua.event.Inventory;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public final class Open implements Listener {
    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        Data data = Yuehua.playerData.get(e.getPlayer().getUniqueId());
        data.open = true;
        Yuehua.scheduler.runTask(
                Yuehua.instance, () -> data.open = false
        );
    }
}
