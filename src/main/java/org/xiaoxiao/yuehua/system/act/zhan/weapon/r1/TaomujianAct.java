package org.xiaoxiao.yuehua.system.act.zhan.weapon.r1;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.xiaoxiao.yuehua.data.ZhanData;
import org.xiaoxiao.yuehua.system.act.ActTaskZhan;

public final class TaomujianAct implements ActTaskZhan {

    @Override
    public void run(Player player, ZhanData data) {
        data.slot0 = "taomujian";
        player.sendPlainMessage("§6桃木剑激活");
    }
}
