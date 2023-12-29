package com.xiaoxiaoowo.yuehua.event.entity;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import java.util.Random;

public final class ShootBow implements Listener {

    private static final Random random = new Random();

    @EventHandler
    public void onShootBow(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player player) {
            GongData data = (GongData) Yuehua.playerData.get(player.getUniqueId());
            data.readyBow = false;
            Arrow arrowEntity = (Arrow) e.getProjectile();
            arrowEntity.setCritical(false);

            if (data.branch != 1) {
                //未进阶，簌霖
                //取基本数据
                int arrow = data.arrow;
                int baoji = data.baoji;
                int baojixiaoguo = data.baojixiaoguo;

                //判断是否暴击
                if (random.nextInt(100) < baoji) {
                    arrow = arrow * baojixiaoguo / 100;
                }
                arrowEntity.setDamage(arrow);
            } else {
                //长虹
                long time = GetEntity.world.getGameTime() - data.time_pulling;

            }
            //射箭技能
            shoot(data, arrowEntity);



        }
    }

    private static void shoot(GongData data, Arrow arrow) {
        switch (data.slot0.id) {

        }
    }
}
