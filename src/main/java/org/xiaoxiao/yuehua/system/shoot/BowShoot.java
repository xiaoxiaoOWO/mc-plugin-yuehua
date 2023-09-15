package org.xiaoxiao.yuehua.system.shoot;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.xiaoxiao.yuehua.data.GongData;

public interface BowShoot {
    void run(Player player, GongData gongData, Arrow arrow);
}
