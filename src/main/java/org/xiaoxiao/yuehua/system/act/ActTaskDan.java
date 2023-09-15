package org.xiaoxiao.yuehua.system.act;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.xiaoxiao.yuehua.data.DanData;

public interface ActTaskDan {
    void run(Player player, DanData data);
}
