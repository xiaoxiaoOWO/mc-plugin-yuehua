package org.xiaoxiao.yuehua.event.entity;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Score;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.GongData;
import org.xiaoxiao.yuehua.system.Scores;
import org.xiaoxiao.yuehua.system.shoot.BowShoot;
import org.xiaoxiao.yuehua.util.GetEntity;

import java.util.HashMap;

public final class ShootBow implements Listener {
    private static final HashMap<String, BowShoot> tasks = new HashMap<>(150, 0.3f);

    public static void init() {

    }


    @EventHandler
    public void onShootBow(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player player) {
            GongData data = (GongData) Yuehua.playerData.get(player.getUniqueId());
            data.ready = false;

            //自动补箭计数
            if (data.auto_arrow == 1) {
                if (++data.count_shoot == 64) {
                    data.count_shoot = 0;
                    Score score = Scores.arrow_count.getScore(player.getName());
                    int count = score.getScore();
                    if (count != 0) {
                        score.setScore(count - 64);
                        player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
                    } else {
                        player.sendPlainMessage("§c箭袋中的箭已经用完了");
                    }
                }
            }

            if (data.branch != 1) {
                //未进阶，簌霖
                //取基本数据
                int arrow = data.arrow;
                int baoji = data.baoji;
                int baojixiaoguo = data.baojixiaoguo;

                //判断是否暴击
                if (GetEntity.random.nextInt(100) < baoji) {
                    arrow = arrow * baojixiaoguo / 100;
                }
                Arrow arrowEntity = (Arrow) e.getProjectile();
                arrowEntity.setCritical(false);
                arrowEntity.setDamage(arrow);
            } else {
                //长虹
                long time = GetEntity.world.getTime() - data.time_pulling;

            }
            //射箭技能
            //tasks.get(gongData.slot0).run(player, gongData,arrowEntity);


            new BukkitRunnable() {

                @Override
                public void run() {
                    data.ready = true;
                }
            }.runTaskLater(Yuehua.instance, 2);


        }
    }
}
